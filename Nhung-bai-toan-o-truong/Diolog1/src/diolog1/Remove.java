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

public class Remove extends Application {
    
    @Override
    public void start(Stage stage) {
        VBox vDelete = new VBox();
        Label label = new Label("Delete Dictionary");
        TextField tDelete = new TextField();
        tDelete.setMaxWidth(200);
        tDelete.setPromptText("Nhap tu can xoa tai day.....");
        Button delete = new Button("REMOVE");
        delete.setDisable(true);
        tDelete.textProperty().addListener(event ->{
           delete.setDisable(tDelete.getText().trim().isEmpty());
        });        
        delete.setOnAction(event ->{
            Alert aDelete = new Alert(Alert.AlertType.CONFIRMATION);
            aDelete.setHeaderText("Notification");
            aDelete.setContentText("Ban co muon xoa tu nay?");
            ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
            aDelete.getButtonTypes().setAll(yes, no);
            Optional<ButtonType> result = aDelete.showAndWait();
            if(result.get() == yes){
               Alert adver = new Alert(Alert.AlertType.INFORMATION);
               adver.setHeaderText("Notification");
               if(tDelete.getText().equals("a"))
                   adver.setContentText("Ban da xoa tu thanh cong");
               else
                   adver.setContentText("Tu can xoa khong ton tai");
               adver.show();
            }   
        });
        vDelete.getChildren().addAll(label, tDelete,delete);
        vDelete.setSpacing(10);
        vDelete.setAlignment(Pos.CENTER);
        Scene sDelete = new Scene(vDelete, 300, 200);
        stage.setTitle("Delete Word");
        stage.setScene(sDelete);
        stage.show();
    }
}
