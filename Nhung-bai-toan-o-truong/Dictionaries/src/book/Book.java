package book;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Book extends Application {
    @Override
    public void start(Stage stage) {
        try{  
        Parent root = FXMLLoader.load(getClass().getResource("Splash.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("Addstyle.css").toExternalForm());
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
   
    public static void main (String[] args) {
        
        launch(args);
        
        if(Thread.currentThread().isAlive()){
            DictionaryCommandline.mydic.dictionaryExportToFile();
            System.exit(0);
        }
    }
    
}
