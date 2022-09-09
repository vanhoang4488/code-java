package examplecomparable;

import javafx.scene.control.Label;

import java.io.*;
import java.util.ArrayList;

public class Dictionay {
    private ArrayList<Word> listWord = new ArrayList<Word>();
    private Object p = new Object();
    public Dictionay(){
        readData();
        exportData();
    }
    public void readData(){
            try{
                FileInputStream fileName = new FileInputStream("dictionaries.dat");
            BufferedInputStream buff = new BufferedInputStream(fileName);
            ObjectInputStream obj = new ObjectInputStream(buff);
            listWord = (ArrayList<Word>) obj.readObject();
           System.out.println(listWord.size());
            buff.close();obj.close();
            }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    public void exportData(){
        try{
            FileOutputStream fileName = new FileOutputStream("dictionaries.dat");
            BufferedOutputStream buff = new BufferedOutputStream(fileName);
            ObjectOutputStream obj = new ObjectOutputStream(buff);
            obj.writeObject(listWord);
            buff.close();obj.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
