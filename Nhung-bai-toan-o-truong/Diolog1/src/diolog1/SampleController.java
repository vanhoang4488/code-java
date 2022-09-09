package diolog1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SampleController implements Initializable {
    Stage sAdd = new Stage();
    Stage sDelete = new Stage();
    Stage sEdit = new Stage();
    @FXML
      private TextField text1 = new TextField();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    @FXML
    private void extra(ActionEvent event) {
        Add add = new Add();
        add.start(sAdd);
    }
    @FXML
    private void remove(ActionEvent event) {
        Remove delete = new Remove();
        delete.start(sDelete);
    }

    @FXML
    private void repair(ActionEvent event) {
        Repair edit = new Repair();
        edit.start(sEdit);
    } 
    @FXML
    private void find(ActionEvent event){
        
    }
}
