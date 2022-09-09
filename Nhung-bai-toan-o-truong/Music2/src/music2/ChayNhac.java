package music2;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javazoom.jl.converter.Converter;
import java.awt.Component;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javafx.stage.Stage;
import javax.media.*;  // import JMF classes
import javax.media.format.AudioFormat;
import javax.media.protocol.DataSource;
import javax.media.protocol.FileTypeDescriptor;
import javax.swing.JFileChooser;
import javazoom.jl.converter.Converter;
/**
 *
 * @author Nguyen Van Hoang
 */
public class ChayNhac {
    public static Player player;
    private Player audioPlayer = null;
    public ChayNhac(URL url) {
        try {
            //MediaLocator ml=new MediaLocator(url);
            audioPlayer = Manager.createPlayer(url);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    public ChayNhac(File file) throws MalformedURLException {
        this(file.toURI().toURL());
    }
    public void play() {
        audioPlayer.start(); // start playing
    }
    public void stop() {
        audioPlayer.stop();  //stop playing
        audioPlayer.close();
    }
    public void a(){
        try {
            JFileChooser fc = new JFileChooser();
            fc.showOpenDialog(null);
            File file = fc.getSelectedFile();
            File file2 = new File("Documents");
            Converter convert = new Converter();
            convert.convert(file.getName(), file2.getName());
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
