package main;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class DictionaryManagement {
     Scanner input = new Scanner(System.in);  
     private String inanh;
     private String inviet;
     private String wordFind;
     
     public ArrayList insertFromCommandline(ArrayList<Word> l){
         int n ;
         System.out.print("Nhap so luong tu: ");
         n = input.nextInt();
         inanh = input.nextLine();
         for(int i=0; i<n; i++)
         {
             Word c = new Word();
             inanh = input.nextLine();     
             inviet = input.nextLine();
             c.setWord_target(inanh);
             c.setWord_explain(inviet);
             l.add(c);
         }
         return l;
     } 
     public ArrayList insertFromFile(ArrayList<Word> k)throws Exception{
         File file = new File("dictionaries.txt");
         FileReader fileReader = new FileReader(file);
         BufferedReader reader = new BufferedReader(fileReader);
         
         String line;
         while((line=reader.readLine()) != null)
         {
             String[] results = line.split("\t");
             Word c = new Word(results[0],results[1]);
             k.add(c);
         }
         reader.close();
         return k;
     }
     public void dictionaryLookup(ArrayList<Word> k){
         System.out.print("Tu can tin kiem la: ");
         wordFind = input.next();
         for(int i =0; i<k.size(); i++)
         {
             if(wordFind.equals(k.get(i).getWord_target()))
             {
                System.out.print("Tu giai nghia la: ");
                System.out.println(k.get(i).getWord_explain());
             }
         }
     }      
}
