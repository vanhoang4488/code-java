package os;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ImageParse {

    private static final Pattern IMG_PATTERN = Pattern.compile("<img [^<>]+>");

    private static final Pattern URL_PATTERN = Pattern.compile("src=\"[^\"\"]+\"");

    private ImageParse () {}

    public static List<Cursor> getImages (List<Cursor> cursors) {
        List<Cursor> imgs = new ArrayList<>();
        cursors.forEach(cursor -> {
            if(CursorType.STRING.equals(cursor.getType())) {
               findAllImg(imgs, cursor);
            }
            else imgs.add(cursor);
        });

        return imgs;
    }

    private static void findAllImg (List<Cursor> imgs, Cursor cursor) {
        int head = 0;
        String str = cursor.getContent();
        Matcher matcher = IMG_PATTERN.matcher(str);
        while (matcher.find()) {
            int start = matcher.start();

            String sub= str.substring(head, start);
            if (!imgs.isEmpty() && sub.trim().isEmpty()) {
                imgs.get(imgs.size()-1).getImgBytes().add(imgUrlParse(matcher.group()));
            }
            else {
                if (!sub.trim().isEmpty()) imgs.add(new Cursor(CursorType.STRING, sub));
                Cursor img = new Cursor(CursorType.IMAGE, matcher.group());
                List<byte[]> imgBytes = new ArrayList<>();
                imgBytes.add(imgUrlParse(matcher.group()));
                img.setImgBytes(imgBytes);
                imgs.add(img);
            }

            head = matcher.end();
        }

        // can't find --> add current cursor
        if (head == 0) imgs.add(cursor);
    }

    private static byte[] imgUrlParse (String imgUrl) {
        Matcher matcher = URL_PATTERN.matcher(imgUrl);
        if (matcher.find()) {
            String path = matcher.group().substring(5, matcher.group().length()-1);
            try {
                URL url = new URL(path);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestProperty("Charsert", "UTF-8");
                connection.setConnectTimeout(1000);
                connection.connect();
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                InputStream in = connection.getInputStream();
                byte[] bytes = new byte[1024];
                int index = 0;
                while ((index = in.read(bytes)) != -1) out.write(bytes, 0, index);
                return  out.toByteArray();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}
