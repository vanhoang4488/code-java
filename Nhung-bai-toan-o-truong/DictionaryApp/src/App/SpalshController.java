package App;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SpalshController implements Initializable {
    public static Stage stage = new Stage();
    @FXML
    private AnchorPane rootPane = new AnchorPane();
    public void initialize(URL url, ResourceBundle rb){

            new Splash().start();
    }
    class Splash extends Thread{
         public void run(){
             try{
                 Thread.sleep(5000);
                 Platform.runLater(new Runnable() {
                     @Override
                     public void run() {
                         Parent root = null;
                         try{
                             root = FXMLLoader.load(getClass().getResource("sample.fxml"));
                             Scene scene = new Scene(root);
                             stage.setScene(scene);
                             stage.setTitle("dictionary");
                             stage.show();
                         }catch(Exception e){
                             e.printStackTrace();
                         }

                         rootPane.getScene().getWindow().hide();
                     }
                 });
             }catch(Exception e){
                 e.printStackTrace();
             }

         }
    }
}
