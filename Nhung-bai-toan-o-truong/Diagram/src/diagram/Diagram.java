/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagram;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class Diagram implements Initializable {
    @FXML
    private Pane pane = new Pane();
    @FXML
    private Canvas canvas = new Canvas();
    //@FXML
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                
    }    
    
    
    @FXML
    private void newFile(ActionEvent event){
        Dialog<String> dialog = new Dialog<String>();
        dialog.setTitle("new file");
        
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.FINISH, ButtonType.CANCEL);
        
        HBox root = new HBox();
        TextField newfile = new TextField();
        newfile.setPromptText("Nhap ten file o day...");
        Label label = new Label("new:   ");
        root.getChildren().addAll(label, newfile);
        
        Node finish = dialog.getDialogPane().lookupButton(ButtonType.FINISH);
        finish.setDisable(true);
        newfile.textProperty().addListener((observable, oldVal, newVal)->{
            finish.setDisable(newfile.getText().trim().isEmpty());
        });
        
        dialog.getDialogPane().setContent(root);
        dialog.setResultConverter( value ->{
            if(value == ButtonType.FINISH)
                return newfile.getText().trim();
            return null;
        });
        
        Optional<String> results = dialog.showAndWait();
        results.ifPresent(value ->{
            MainDiagram diagram = new MainDiagram(value);
        });
    }
    
    @FXML
    private void Triangle(ActionEvent event){
        
    }
    
}
