package diolog1;

import java.util.Optional;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Add extends Application {
    
    @Override
    public void start(Stage stage) {
        VBox vAdd= new VBox();
        Label label = new Label("Addional Dictionary");
        TextField tAdd = new TextField();
        tAdd.setMaxWidth(200);
        tAdd.setPromptText("Nhap tu can them vao day......");
        Button add = new Button("ADD"); 
        add.setDisable(true);
        tAdd.textProperty().addListener(event ->{
           add.setDisable(tAdd.getText().trim().isEmpty());
        });
        add.setOnAction(event ->{
            Alert aAdd = new Alert(Alert.AlertType.CONFIRMATION);
            aAdd.setHeaderText("Notification");
            aAdd.setContentText("Ban co muon them tu nay?");
            ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
            aAdd.getButtonTypes().setAll(yes, no);
            Optional<ButtonType> result = aAdd.showAndWait();
            if(result.get() == yes){
               Alert adver = new Alert(Alert.AlertType.INFORMATION);
               adver.setHeaderText("Notification");
               if(tAdd.getText().equals("a"))
                   adver.setContentText("Ban da them tu thanh cong");
               else
                   adver.setContentText("Tu da co trong tu dien");
               adver.show();
            }   
        });
        vAdd.getChildren().addAll(label, tAdd, add);
        vAdd.setSpacing(10);
        vAdd.setAlignment(Pos.CENTER);
        Scene sAdd = new Scene(vAdd, 300, 200);
        stage.setTitle("ADD Word");
        stage.setScene(sAdd);
        stage.show();
    }  
}
