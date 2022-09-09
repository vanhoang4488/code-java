package book;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class SplashController implements Initializable {

    public static Stage stage = new Stage();
    
    @FXML 
     private AnchorPane rootPane;
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new Splash().start();
    }    
    
    class Splash extends Thread{
        
        public void run(){
          try{
              Thread.sleep(3000);
              Platform.runLater( new Runnable(){
                  public void run(){
                      Parent root = null;
                      try {
                          root = FXMLLoader.load(getClass().getResource("sample.fxml"));
                          Scene scene = new Scene(root);
                          stage.setTitle("Dictionary");
                          stage.setScene(scene);
                          stage.show();
                          
                      } catch (IOException ex) {
                          ex.printStackTrace();
                      }
                      
                      
                      rootPane.getScene().getWindow().hide();
                  }
              });
          } 
          catch(Exception e){
              e.printStackTrace();
          }
        }
        
    }
    
}
