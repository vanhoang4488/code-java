/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediastream;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.media.*;  // import JMF classes
import javax.media.format.AudioFormat;
import javax.media.protocol.DataSource;
import javax.media.protocol.FileTypeDescriptor;
import javax.swing.JFileChooser;
import javazoom.jl.converter.Converter;

/**
*
* @author BUDDHIMA
*/
public class TruyenMedia {
    private Player audioPlayer = null;
    public void truyen(){
        try {
            // TODO code application logic here
            JFileChooser fc = new JFileChooser();
            fc.showOpenDialog(null);
            File file = fc.getSelectedFile();
            System.out.println("????????????????????");
            File file2 = new File("Documents");
            Converter convert = new Converter();
            convert.convert(file.getName(), file2.getName());
            System.out.println(file.getPath());
            System.out.println(file2.getPath());
            
            MediaLocator locator = new MediaLocator("file://" + file.getPath());
            DataSource data = Manager.createDataSource(locator);
            FileTypeDescriptor outputFile = new FileTypeDescriptor(FileTypeDescriptor.WAVE);
            AudioFormat[] aFormat = new AudioFormat[1];
            aFormat[0] = new AudioFormat(AudioFormat.LINEAR);
            ProcessorModel pro = new ProcessorModel(data, aFormat, outputFile);
            Processor process = Manager.createRealizedProcessor(pro);
            DataSource ra = process.getDataOutput();
            MediaLocator outLocator = new MediaLocator("Downloads\\a font.mp3");
            DataSink sink = Manager.createDataSink(data, outLocator);
            sink.open();
            sink.start();
            process.start();
            sink.stop();
            process.stop();
            process.close();
//sap.stop();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}