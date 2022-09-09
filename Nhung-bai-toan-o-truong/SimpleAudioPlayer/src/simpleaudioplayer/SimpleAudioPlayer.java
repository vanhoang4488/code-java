package simpleaudioplayer;
import java.awt.Component;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javafx.stage.Stage;
import javax.media.*;  // import JMF classes
import javax.swing.JFileChooser;
import javazoom.jl.converter.Converter;

/**
*
* @author BUDDHIMA
*/
public class SimpleAudioPlayer {
    private Player audioPlayer = null;
    public SimpleAudioPlayer(URL url) {
        try {
            //MediaLocator ml=new MediaLocator(url);
            audioPlayer = Manager.createPlayer(url);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    public SimpleAudioPlayer(File file) throws MalformedURLException {
        this(file.toURI().toURL());
    }
    public void play() {
        audioPlayer.start(); // start playing
    }
    public void stop() {
        audioPlayer.stop();  //stop playing
        audioPlayer.close();
    }
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            JFileChooser fc = new JFileChooser();
            fc.showOpenDialog(null);
            File file = fc.getSelectedFile();
            File file2 = new File("Documents");
            Converter convert = new Converter();
            convert.convert(file.getName(), file2.getName());
            SimpleAudioPlayer sap = new SimpleAudioPlayer(file2);
            sap.play();
            //sap.stop();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}