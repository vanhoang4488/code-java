package App;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class AddController implements Initializable {
    private Controller command = new Controller();
    private int lines = 1;
    @FXML
    private TextField textEng = new TextField();
    @FXML
    private TextArea textViet = new TextArea();
    @FXML
    private Button bAdd = new Button();
    @FXML
    private MenuItem Item = new MenuItem();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bAdd.setDisable(true);
        textEng.textProperty().addListener((obsesrvable, oldVal, newVal)->{
            if(!newVal.trim().isEmpty()){
                bAdd.setDisable(textViet.getText().trim().isEmpty());
                Item.setDisable(textViet.getText().trim().isEmpty());
            }
            else{
                bAdd.setDisable(true);
                Item.setDisable(true);
            }
        });
        textViet.textProperty().addListener((obsesrvable, oldVal, newVal)->{
            if(!newVal.trim().isEmpty()){
                bAdd.setDisable(textViet.getText().trim().isEmpty());
                Item.setDisable(textViet.getText().trim().isEmpty());
            }
            else{
                bAdd.setDisable(true);
                Item.setDisable(true);
            }
        });
    }

    @FXML
    public void add(ActionEvent event){
        Alert aAdd = new Alert(Alert.AlertType.CONFIRMATION);
        aAdd.setHeaderText("Notification");
        aAdd.setContentText("Ban co muon them tu nay?");
        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
        aAdd.getButtonTypes().setAll(yes, no);
        Optional<ButtonType> result = aAdd.showAndWait();
        if(result.get() == yes){
            command.listView("them", textEng.getText().trim(), "", textViet.getText().trim());
        }
    }

    @FXML
    private void cancel(ActionEvent event){
        Controller.sAdd.close();
    }

    @FXML
    private void keyEng(KeyEvent key){
        if(key.getCode().equals(KeyCode.ENTER) || key.getCode().equals(KeyCode.DOWN))
            textViet.requestFocus();
    }

    @FXML
    private void keyViet(KeyEvent key){
        if(key.getCode().equals(KeyCode.ENTER) || key.getCode().equals(KeyCode.DOWN))
            lines++;
        if(key.getCode().equals(KeyCode.UP)){
            if(lines == 1){
                textEng.requestFocus();
                textEng.selectAll();
            }
            else
                lines--;
        }
    }


}
