package App;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class DeleteController implements Initializable {
    private Controller command = new Controller();
    @FXML
    private TextField tEng = new TextField();
    @FXML
    private Button bDelete = new Button();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bDelete.setDisable(true);
        tEng.textProperty().addListener((obsesrvable, oldVal, newVal)->{
            bDelete.setDisable(newVal.trim().isEmpty());
        });
    }

    public void yeuCau(){
        Alert aDelete = new Alert(Alert.AlertType.CONFIRMATION);
        aDelete.setHeaderText("Notification");
        aDelete.setContentText("Ban co muon xoa tu nay?");
        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
        aDelete.getButtonTypes().setAll(yes, no);
        Optional<ButtonType> result = aDelete.showAndWait();
        if(result.get() == yes){
            command.listView("xoa", tEng.getText().trim(), "", "");
        }
    }

    public void setEng(Word word){
        tEng.setText(word.getWord_target());
    }

    @FXML
    private void delete(ActionEvent event){
        yeuCau();
        tEng.selectAll();
    }

    @FXML
    private void keyDelete(KeyEvent key){
        if(key.getCode().equals(KeyCode.ENTER)){
            yeuCau();
            tEng.selectAll();
        }
    }

    @FXML
    private void cancel(ActionEvent event){
        Controller.sDelete.close();
    }
}
