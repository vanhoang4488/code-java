package diagram;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class MainDiagram extends Application {
    private Stage stage = new Stage();
    private String name ="";

    public MainDiagram(){
        start(stage);
    }
    
    public MainDiagram(String text){
        name = text;
        start(stage);
    }
    
    @Override
    public void start(Stage stage1) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("layer.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle(name);
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
}
