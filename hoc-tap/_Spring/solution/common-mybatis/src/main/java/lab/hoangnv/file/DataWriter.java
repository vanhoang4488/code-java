package lab.hoangnv.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public abstract class DataWriter {

    public static void write(String filename, List<? extends Object> data) throws IOException {

        File file = new File(filename);
        FileWriter writer = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(writer);

        for(Object object : data){
            bw.write(object.toString());
            bw.newLine();
        }
        bw.close();
        writer.close();
    }
}
