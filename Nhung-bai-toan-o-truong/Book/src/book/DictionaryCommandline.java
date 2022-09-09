package book;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import Music.Music;

public class DictionaryCommandline implements Initializable {
    public static boolean mark = true;
    public static Stage sAdd = new Stage(); 
    public static Stage sDelete = new Stage();
    public static Stage sEdit = new Stage();
    public  static DictionaryApplication  mydic =  new DictionaryApplication(); 
    private Parent pAdd, pDelete, pEdit;
    private ObservableList<Word> dictionaries;
    private Thread thread1, thread2;
    private Music music = new Music();
    @FXML
      private TextField text1 = new TextField();
    @FXML
      private Label broad = new Label();
    @FXML
      private ListView<Word> list = new  ListView<Word>();
    @FXML
      private AnchorPane mainRoot = new AnchorPane();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dictionaries = FXCollections.observableArrayList(mydic.taken());
        list.setItems(dictionaries); 
        list.getSelectionModel().selectIndices(0);
        broad.setText(list.getSelectionModel().getSelectedItem().getWord_explain());
        list.getSelectionModel().selectedItemProperty().addListener((observable, oldVal, newVal)->{
            broad.setText(newVal.getWord_explain());
        });
        
        if(mark){
            sAdd.initOwner(SplashController.stage);
            sDelete.initOwner(SplashController.stage);
            sEdit.initOwner(SplashController.stage);
            mark = false;
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
        loader.setLocation(getClass().getResource("Delete2.fxml"));
        pDelete = loader.load();
        Scene scene = new Scene(pDelete);
        scene.getStylesheets().add(getClass().getResource("Addstyle.css").toExternalForm());
        DeleteController controller = loader.getController();
        Word word = list.getSelectionModel().getSelectedItem();
        try{
            broad.getText().isEmpty();
            controller.setEng(word);
        }
        catch(Exception e){
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
        mydic.outputLabel(broad, text1.getText().trim());
        text1.selectAll();
    }
    
    @FXML
    private void getText(KeyEvent key){
        if(key.getCode().equals(KeyCode.ENTER)){
            mydic.outputLabel(broad, text1.getText().trim());
            text1.selectAll();
        }
    } 
    
    @FXML
    private void close(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Ban that su muon dong tu dien?");
        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(yes, no);
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == yes){
            mydic.dictionaryExportToFile();
            Platform.exit();
            System.exit(0);
        }  
    }
    
    @FXML
    private void music(ActionEvent event){
        thread1 = new Thread(new Runnable(){
            @Override
            public void run() {
                music.stop();
            }
        });
        
        thread2 = new Thread(new Runnable(){
            @Override
            public void run() {
                music.play();
            }   
        });
        
        thread1.start();
        try{
            thread1.join(1);
        }catch(Exception e){
            e.printStackTrace();
        }
        thread2.start();
    }
}
