package App;

import javafx.scene.control.Label;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
public class Dictionary {
    private ArrayList<Word> listWord = new ArrayList<Word>();
    public Dictionary(){
        readData();
    }
    public void readData(){
         
                try{
        File fileName = new File("AnhVietdict.txt");
                FileReader fr = new FileReader(fileName);
                BufferedReader br = new BufferedReader(fr);
                String line ;
                ArrayList<String> target = new ArrayList<String>();
                ArrayList<String> explain = new ArrayList<String>();
                String mean="" ;
                int i=-1;
                while((line=br.readLine()) !=null){
                    if(line.charAt(0)!=' '){
                        if(i>=0)
                            explain.add(mean);
                        i++ ;
                        target.add(line);
                        mean = "" ;
                    }
                    else{
                        mean += line;
                        mean +='\n';
                    }
                }
                explain.add(mean);  // add last object
                br.close(); fr.close();

                for(int j=1; j<target.size(); j++)
                {
                    for(int x = j+1; x< target.size(); x++)
                        if(target.get(x).equals(target.get(j))){
                            target.remove(x);
                            explain.remove(x);
                        }
                    Word word = new Word();
                    word.setWord_target(target.get(j));
                    word.setWord_explain(explain.get(j));
                    myList.add(word);
                }
                System.out.println(myList.size());
                //Collections.sort(listWord);
            }
        catch(Exception e){
            System.out.println("File not found");
        }
    }

    public ArrayList<Word> getData(){
        System.out.println(listWord.get(0).getWord_explain());
        return this.listWord ;
    }

    public void addNewWord (Word newWord){
        this.listWord.add(newWord) ;
        Collections.sort(listWord);
        exportData();
    }
    public void delete (int pos){
        this.listWord.remove(pos) ;
        Collections.sort(listWord);
        exportData();
    }
    public void edit(String eng1, String eng2, String viet){
        this.listWord.remove(new Word(eng1, viet)) ;
        this.listWord.add(new Word(eng2, viet)) ;
        Collections.sort(listWord);
        exportData();
    }

    public void outputLabel(Label label, int vitri){
        label.setText(listWord.get(vitri).getWord_explain());
    }

    public int searchWord(String input ){
        System.out.println(input);
        System.out.println(input.length());
        int left = 0, right = listWord.size();
        while(left<=right){
            int mid = (left+right)/2 ;
            if(listWord.get(mid).getWord_target().compareTo(input)== 0){
                return mid;
            }
            if(listWord.get(mid).getWord_target().compareTo(input)<0){
                left = mid +1;
            }
            if(listWord.get(mid).getWord_target().compareTo(input)>0){
                right = mid -1;
            }
        }
         System.out.println("kkakjf");
        return -1;
    }
//xuat du lieura file
    public void exportData(){
        try{
            File fileName = new File("D:\\uet\\java\\B_Exe\\DictionaryApp\\src\\Dictionary\\AnhVietdict.txt");
            FileWriter fw = new FileWriter(fileName);
            PrintWriter pw = new PrintWriter(fw) ;
            for(int i=0; i<listWord.size(); i++)
            {
                pw.println(listWord.get(i).getWord_target());
                pw.println(listWord.get(i).getWord_explain());
            }
            fw.close(); pw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
