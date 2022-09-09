/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Nguyen Van Hoang
 */
public class Sample2Controller implements Initializable {
    SampleController  hoang = new SampleController();
    @FXML
    private TextField text = new TextField();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML 
    private void button(ActionEvent e){
        try {
            hoang.add(text.getText());
        } catch (IOException ex) {
            Logger.getLogger(Sample2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
