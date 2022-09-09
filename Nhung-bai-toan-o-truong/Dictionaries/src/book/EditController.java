package book;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class EditController implements Initializable {
    private int lines = 1;
    @FXML
    private TextField tEdit1 = new TextField();
    @FXML
    private TextField tEdit2 = new TextField();
    @FXML
    private TextArea tViet = new TextArea();
    @FXML
    private Button bEdit = new Button();
    @FXML
    private MenuItem Item = new MenuItem();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tEdit2.textProperty().addListener((observable, oldVal, newVal) ->{
            bEdit.setDisable(newVal.trim().isEmpty());
            Item.setDisable(newVal.trim().isEmpty());
        });
        
        tViet.textProperty().addListener((observable, oldVal, newVal) ->{
            if(newVal.trim().isEmpty()){
                bEdit.setDisable(true);
                Item.setDisable(true);
            }else{
                bEdit.setDisable(tEdit2.getText().trim().isEmpty());
                Item.setDisable(tEdit2.getText().trim().isEmpty());
            }   
        });
        
    }  
    
    public void setWord(Word word){
        tEdit1.setText(word.getWord_target());
        tViet.setText(word.getWord_explain());
    }
    
    @FXML
    public void edit(ActionEvent event){
            Alert aEdit = new Alert(Alert.AlertType.CONFIRMATION);
            aEdit.setHeaderText("Notification");
            aEdit.setContentText("Ban co muon sua tu nay?");
            ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
            aEdit.getButtonTypes().setAll(yes, no);
            Optional<ButtonType> result = aEdit.showAndWait();
            if(result.get() == yes){
                   DictionaryCommandline.mydic.edit(tEdit1.getText().trim(), tEdit2.getText().trim(), tViet.getText().trim());
            }   
    }
    
    @FXML
    private void cancel(ActionEvent event){
        DictionaryCommandline.sEdit.close();
    }
    
    @FXML
    private void keyEng1(KeyEvent key){
        if(key.getCode().equals(KeyCode.ENTER) || key.getCode().equals(KeyCode.DOWN)){
            DictionaryCommandline.mydic.outputBroad(tViet, tEdit1.getText().trim());
            tEdit2.requestFocus();
            tEdit2.selectAll();
        }
            
    }
    
    @FXML
    private void keyEng2(KeyEvent key){
        if(key.getCode().equals(KeyCode.ENTER) || key.getCode().equals(KeyCode.DOWN))
            tViet.requestFocus();
        if(key.getCode().equals(KeyCode.UP)){
            tEdit1.requestFocus();
            tEdit1.selectAll();
        }       
    }
    
    @FXML
    private void keyViet(KeyEvent key){
        if(key.getCode().equals(KeyCode.ENTER) || key.getCode().equals(KeyCode.DOWN))
            lines++;
        if(key.getCode().equals(KeyCode.UP)){
            if(lines == 1){
                tEdit2.requestFocus();
                tEdit2.selectAll();
            }
            else
                lines--;
        }
    }
}
