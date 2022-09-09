package book;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import javafx.scene.control.Alert;
import javazoom.jl.player.Player;


public class Music {
    private Player player;
    private String eng;
    public static String path;
    public Music(){
        path = System.getProperty("user.dir") + "\\am thanh\\"; 
    }
    public void setEng(String eng) {
        this.eng = eng;
    }
    
    public void stop(){
        if(player != null){
            player.close();
        }    
    }
    
    public void play(){
        try {
            eng = path + eng +".mp3";
            FileInputStream file = new FileInputStream(eng);
            BufferedInputStream buf = new BufferedInputStream(file);
            player = new Player(buf);
            player.play();
        } catch (Exception ex) {}
    }
    
}
