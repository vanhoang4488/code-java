/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

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

/**
 * FXML Controller class
 *
 * @author Nguyen Van Hoang
 */
public class SplashController implements Initializable {
    @FXML 
     private AnchorPane rootPane;
    
    public static Stage stage = new Stage();
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new Splash().start();
    }    
    
    class Splash extends Thread{
        
        public void run(){
          try{
              SampleController hoang = new SampleController();
          } 
          catch(Exception e){
              e.printStackTrace();
          }
        }
    }
}
