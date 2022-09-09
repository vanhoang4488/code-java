package helloworld;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
/**
 *
 * @author TUNGDUONG
 */
public class HelloWorld extends Application implements ChangeListener{
 
    @Override
    public void start(Stage stage) {
        HBox root = new HBox();
        
        ToggleGroup group = new ToggleGroup();
        CheckBox checkBox1 = new CheckBox("Green");
        CheckBox checkBox2 = new CheckBox("Yellow");
        CheckBox checkBox3 = new CheckBox("Red");
        CheckBox checkBox4 = new CheckBox("White");
        CheckBox checkBox5 = new CheckBox("Black");
        RadioButton checkBox = new RadioButton("new");
        checkBox.setToggleGroup(group);
        checkBox1.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val){
                root.setStyle("-fx-background-color:#C0FF00;");
            }
        });
        checkBox2.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val){
                root.setStyle("-fx-background-color:#FFFF00;");
            }
        });
        checkBox3.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val){
                root.setStyle("-fx-background-color:#FF0000;");
            }
        });
        checkBox4.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val){
                root.setStyle("-fx-background-color:#FAF8CC;");
            }
        });
        root.setSpacing(5);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(checkBox1, checkBox2, checkBox3, checkBox4, checkBox5);
 
        Scene scene = new Scene(root, 400, 300);
        stage.setTitle("JavaFX ProgressBar - Kênh Lập Trình");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}