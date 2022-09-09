package App;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.stage.StageStyle;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Spalsh.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("Addstyle.css").toExternalForm());
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Dictionary");
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
