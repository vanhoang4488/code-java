package Music;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javazoom.jl.player.Player;

public class Music {
    public static Player player;
    
    public void stop(){
        if(player != null){
            player.close();
        }    
    }
    
    public void play(){
        try {
            FileInputStream file = new FileInputStream("a font.mp3");
            BufferedInputStream buf = new BufferedInputStream(file);
            player = new Player(buf);
            player.play();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
