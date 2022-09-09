package main;
import java.util.ArrayList;

public class DictionaryCommandline {
      public void showAllWords(ArrayList<Word> l)
      {
          System.out.println("No 	| English 		| Vietnamese");
          for(int i=0; i<l.size(); i++)
          {
              System.out.print(i+1);
              System.out.print("	| " + l.get(i).getWord_target());
              System.out.println("			| "+l.get(i).getWord_explain());
          }
      }
      public void dictionaryBasic(){
          DictionaryManagement dic1 = new DictionaryManagement();
          l = dic1.insertFromCommandline(l);
          showAllWords(l);
      }     
      public ArrayList dictionaryAdvanced( ){
          DictionaryManagement dic2 = new DictionaryManagement();
          try{
              k = dic2.insertFromFile(k);
          }
          catch(Exception e){
              e.printStackTrace();
          }
          dic2.dictionaryLookup(k);
          showAllWords(k);
          return k;
      } 
}
