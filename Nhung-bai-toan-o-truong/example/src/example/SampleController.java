/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nguyen Van Hoang
 */
public class SampleController implements Initializable {
    @FXML
    private ListView<String> list = new ListView<String>();
    ObservableList<String> dic = FXCollections.observableArrayList("a", "b", "c");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        list.setItems(dic);
    }    
    
    
    @FXML
    private void btn(ActionEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sample2.fxml"));
        Parent root = loader.load();
        Scene scene= new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    public void cogang(String a){
        dic.add(a);
    }
    public void add(String a) throws IOException{
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        SampleController controller = loader.getController();
        controller.cogang(a);
        Scene scene= new Scene(root);
        SplashController.stage.setScene(scene);
        SplashController.stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
