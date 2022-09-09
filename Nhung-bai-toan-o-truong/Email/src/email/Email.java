package email;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.layout.VBox;

public class Email extends Application {
    
    public void start(Stage stage){
        VBox root = new VBox();
        Label label = new Label("In Your INBOX");
        label.setMaxWidth(300);
        label.setFont(new Font("Aril",20));
        label.setAlignment(Pos.CENTER);
        
        TextField text = new TextField();
        text.setMaxWidth(300);
        text.setMinHeight(25);
        text.setPromptText("Enter your email here......");
        //text.setTooltip(new Tooltip("Enter your email here...."));
        
        Button but = new Button("SIGN IN");
        but.setMaxWidth(300);
        but.setMinHeight(30);
        but.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                root.setStyle("-fx-background-color:#C0FF00;");
            }
        });
        
        root.setSpacing(10);
        root.getChildren().addAll(label,text,but);
        root.setAlignment(Pos.CENTER);
        
        /*HBox root2 = new HBox();
        Label lb = new Label();
        Image img = new Image(getClass().getResourceAsStream("meo.png"));
        lb.setGraphic(new ImageView(img));*/
        
        Scene sc = new Scene(root,500,500);
        //Scene sc2 = new Scene(root2,500,500);
        stage.setTitle("Java Fx");
        stage.setScene(sc);
        //stage.setScene(sc2);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
