package testfile;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

public class TestFile {
    public static void main(String[] args) {
       ArrayList<Word> File = new ArrayList<Word>();
       try{
           File file = new File("vnedict.txt");
           FileReader fileReader = new FileReader(file);
           BufferedReader reader = new BufferedReader(fileReader);
           
           String line;
           System.out.println("No 	| English 		| Vietnamese");
           
           while((line = reader.readLine()) != null){
               try{
               String[] results = line.split(":");      
               Word c = new Word();
               c.setWord_explain(results[0]);
               c.setWord_target(results[1]);
               File.add(c);
               }
               catch(RuntimeException e)
               {
               }
           }
           for(int i=0; i<File.size(); i++)
           {
               System.out.print(i+1);
               System.out.print("	| " + File.get(i).getWord_target());
               System.out.println("			| "+File.get(i).getWord_explain());
           }
           reader.close();
         }
       catch(FileNotFoundException e){
            e.printStackTrace(); 
       } catch (IOException ex) {
            Logger.getLogger(TestFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}