package iternet;
import java.io.*;
import java.net.*;

public class Iternet {

    
    public static void main(String[] args) {
        try{
            URL url = new URL("https://translate.google.com");
            URLConnection conn = url.openConnection();
            
            InputStream stream = conn.getInputStream();
            InputStreamReader ir = new InputStreamReader(stream);
            BufferedReader reader = new BufferedReader(ir);
            
            String line;
            while((line = reader.readLine()) !=  null){
                
                System.out.println(line);
            }
            
            reader.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
