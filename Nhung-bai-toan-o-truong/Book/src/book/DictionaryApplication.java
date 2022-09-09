package book;
import java.util.*;
import java.io.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

public class DictionaryApplication {
    private String  value  ;
    private ArrayList<Word> myList = new ArrayList<Word>();
    private Hashtable<String, String> listWord = new Hashtable<String, String>();
    
    public DictionaryApplication(){
        runApplication();
    }
    
    public void runApplication(){
        try {
            FileInputStream file = new FileInputStream("dictionaries.dat");
            BufferedInputStream buff = new BufferedInputStream(file);
            ObjectInputStream obj = new ObjectInputStream(buff);
            myList = (ArrayList<Word>) obj.readObject();
            buff.close();
            obj.close();
            Collections.sort(myList);
            for(Word word : myList)
                listWord.put(word.getWord_target(), word.getWord_explain());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Word> taken(){
        return myList;
    }
    
    public void notify(String notice){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Dictionary");
        alert.setHeaderText("Notification");
        alert.setContentText(notice);
        alert.show();
    }
    
    public void listView() {
        try{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("Addstyle.css").toExternalForm());
        DictionaryCommandline controller = loader.getController();
        SplashController.stage.setScene(scene);
        SplashController.stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void add(String eng, String viet){
        if(!listWord.containsKey(eng)){
          myList.add(new Word(eng, viet));
          listWord.put(eng, viet);
          Collections.sort(myList);
          listView();
          notify("Ban da them tu thanh cong");
        }
        else{
           notify("Tu da co trong tu dien"); 
        }
        
    }
    
    public void delete(String eng){
        if(listWord.containsKey(eng)){
           String viet = listWord.get(eng);
           myList.remove(new Word(eng, viet));
           listWord.remove(eng, viet);
           Collections.sort(myList);
           listView();
           notify("Ban da xoa tu thanh cong");
        }
        else{
            notify("Tu can xoa khong co trong tu dien");
        }
    }
    
    public void edit(String eng, String eng2, String viet){
        if(!listWord.containsKey(eng2) || eng.equals(eng2)){
          myList.remove(new Word(eng, viet));
          myList.add(new Word(eng2, viet));
          listWord.remove(eng, viet);
          listWord.put(eng2, viet);
          Collections.sort(myList);
          listView();
          notify("Ban da sua tu thanh cong");
        }else{
          notify("Sua tu that bai");
        }
    }
    
    public void outputLabel(Label label , String text){
        if(listWord.containsKey(text))
           label.setText(listWord.get(text));
        else
            notify("Tu khong co trong tu dien");
    }
    
    public void dictionaryExportToFile(){
        try{
            FileOutputStream file = new FileOutputStream("dictionaries.dat");
            BufferedOutputStream buff = new BufferedOutputStream(file);
            ObjectOutputStream obj = new ObjectOutputStream(buff);
            obj.writeObject(myList);
            buff.close();
            obj.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}