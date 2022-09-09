package App;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable {
     private Dictionary dict = new Dictionary();
     public static Stage sAdd = new Stage();
     public static Stage sDelete = new Stage();
     public static Stage sEdit = new Stage();
     private int pos = 0;
     private Parent pAdd, pDelete, pEdit;
     private ObservableList<Word> dic ;
     @FXML
     private TextField text = new TextField();
     @FXML
     private Label broad = new Label();
     @FXML
     private ListView<Word> list = new ListView<Word>();

    public void initialize(URL url, ResourceBundle rb) {
        dic = FXCollections.observableArrayList(dict.getData());
        list.setItems(dic);
        list.getSelectionModel().selectIndices(0);
        broad.setText(list.getSelectionModel().getSelectedItem().getWord_explain());
        list.getSelectionModel().selectedItemProperty().addListener((observable, olsVal, newVal)->{
            broad.setText(newVal.getWord_explain());
        });
    }

    public void dictionarySearch(String action, String eng1, String eng2, String viet){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(action + "Dictionary");
        alert.setHeaderText("Notification");
        System.out.println(eng1);
        pos = dict.searchWord(eng1);
        System.out.println("hoang la " + pos);
        if(pos != -1){
            switch(action){
                case "them":
                    alert.setContentText("Tu da ton tai trong tu dien");
                    break;
                case "xoa":
                    dict.delete(pos);
                    dic.remove(pos);
                    alert.setContentText("Ban da xoa tu thanh cong");
                    break;
                case "sua":
                    dict.edit(eng1, eng2, viet);
                    dic.remove(pos);
                    dic.add(pos, new Word(eng2, viet));
                    alert.setContentText("Ban da sua tu thanh cong");
                    break;
                case "find":
                    dict.outputLabel(broad, pos);
                    alert.setContentText("Tim kiem thanh cong");
                    break;
            }
        }else{
            if(action.equals("them")){
                dict.addNewWord(new Word(eng1, viet));
                dic.add(new Word(eng1, viet));
                alert.setContentText("Ban da them tu thanh cong");
            }else
                alert.setContentText("Tim kiem that bai");
        }
        alert.show();
    }

    public void listView(String action, String eng1, String eng2, String viet) {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("sample.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("Addstyle.css").toExternalForm());
            Controller controller = loader.getController();
            controller.dictionarySearch(action, eng1, eng2, viet);
            SpalshController.stage.setScene(scene);
            SpalshController.stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    @FXML
    private void extra(ActionEvent event) throws IOException {
        pAdd = FXMLLoader.load(getClass().getResource("Add.fxml"));
        Scene scene = new Scene(pAdd);
        scene.getStylesheets().add(getClass().getResource("Addstyle.css").toExternalForm());
        sAdd.setTitle("Add Dictionary");
        sAdd.setScene(scene);
        sAdd.show();
    }


    @FXML
    private void remove(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Delete.fxml"));
        pDelete = loader.load();
        Scene scene = new Scene(pDelete);
        scene.getStylesheets().add(getClass().getResource("Addstyle.css").toExternalForm());
        DeleteController controller = loader.getController();
        Word word = list.getSelectionModel().getSelectedItem();
        try{
            broad.getText().isEmpty();
            controller.setEng(word);
            System.out.println("hoang");
        }
        catch(Exception e){
            System.out.println("hoang");
            controller.setEng(new Word("",""));
        }
        sDelete.setTitle("Delete Dictionary");
        sDelete.setScene(scene);
        sDelete.show();
    }



    @FXML
    private void repair(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Edit.fxml"));
        pEdit = loader.load();
        Scene scene = new Scene(pEdit);
        scene.getStylesheets().add(getClass().getResource("Addstyle.css").toExternalForm());
        EditController controller = loader.getController();
        Word word = list.getSelectionModel().getSelectedItem();
        try{
            broad.getText().isEmpty();
            controller.setWord(word);
        }
        catch(Exception e){
            controller.setWord(new Word("",""));
        }
        sEdit.setTitle("Edit Dictionary");
        sEdit.setScene(scene);
        sEdit.show();
    }

    @FXML
    private void find(ActionEvent event){
        dictionarySearch("find", text.getText().trim(),"","");
        text.selectAll();
    }

    @FXML
    private void getText(KeyEvent key){
        if(key.getCode().equals(KeyCode.ENTER)){
            dictionarySearch("find", text.getText().trim(),"","");
            text.selectAll();
        }
    }

    @FXML
    private void close(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Ban that su muon dong tu dien?");
        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(yes, no);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == yes) {
            Platform.exit();
            System.exit(0);
        }
    }

}
