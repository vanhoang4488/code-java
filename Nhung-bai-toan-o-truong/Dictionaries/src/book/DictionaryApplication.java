package book;
import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class DictionaryApplication {
    private ArrayList<Word> myList = new ArrayList<Word>();
    public static  Hashtable<String, String> listWord = new Hashtable<String, String>();
    private static Stage stage = new Stage();
    private static String path2;
    public DictionaryApplication(){
        runApplication();
        path2 = System.getProperty("user.dir") + "\\am thanh\\";
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
    
    public String tuAmThanh(String eng){
        if(listWord.containsKey(eng))
            return eng;
        return "";
    }
    
    public void SaveFile(String eng1, String eng2){
         eng2 = path2 + eng2 ;
        try {
            Path source = Paths.get(eng1);
            Path destination = Paths.get(eng2);
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void DeleteFile(String eng){
        eng = path2 + eng + ".mp3";
        File xoafile = new File(eng);
        xoafile.delete();
    }
    
    public String chooseFile(String eng){
        FileChooser fc = new FileChooser();
        fc.setTitle("Chooser file English");
        FileChooser.ExtensionFilter music = new FileChooser.ExtensionFilter("file", "*.mp3");
        fc.getExtensionFilters().add(music);
        File english = fc.showOpenDialog(stage);
        eng = eng + ".mp3";
        try{
           if(english.getName().equals(eng)){
               SaveFile(english.getPath(), eng);
               return "yes";
            }
        }catch(Exception e){}   
        return "";
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
        DictionaryCommandline controller = loader.getController();
        SplashController.stage.setScene(scene);
        SplashController.stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void add(String eng, String viet){
        if(!listWord.containsKey(eng)){
          if(!chooseFile(eng).isEmpty()){
             myList.add(new Word(eng, viet));
             listWord.put(eng, viet);
             Collections.sort(myList);
             listView();
             notify("Ban da them tu thanh cong");
          }else{
             notify("Them tu that bai");
          }
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
           DeleteFile(eng);
           listView();
           notify("Ban da xoa tu thanh cong");
        }
        else{
            notify("Tu can xoa khong co trong tu dien");
        }
    }
    
    public void edit(String eng, String eng2, String viet){
        if(!listWord.containsKey(eng2) && listWord.containsKey(eng)){
            if(!chooseFile(eng2).isEmpty()){
                DeleteFile(eng);
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
        
        if(eng.equals(eng2) && listWord.containsKey(eng)){
            myList.remove(new Word(eng, viet));
            myList.add(new Word(eng2, viet));
            listWord.put(eng2, viet);
            Collections.sort(myList);
            listView();
            notify("Ban da sua tu thanh cong");
        }
        
        if((listWord.containsKey(eng2) && !listWord.containsKey(eng)) || !listWord.containsKey(eng))
            notify("Sua tu that bai");
    }
    
    public void outputBroad(TextArea broad , String text){
        if(listWord.containsKey(text)){
           broad.setText(listWord.get(text));
        }  
        else{
            broad.setText("");
            notify("Tu khong co trong tu dien");
        }
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