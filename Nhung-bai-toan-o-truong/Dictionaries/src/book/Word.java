package book;

import java.io.Serializable;

public class Word implements Comparable<Word>, Serializable{
     private String word_target;
     private String word_explain;
     
    public String getWord_target() {
        return word_target;
    }

    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    public String getWord_explain() {
        return word_explain;
    }

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }
     
    public Word(){}
    public Word(String eng, String viet){
        word_target = eng;
        word_explain = viet;
    }
    
    public String toString(){
        return this.getWord_target();
    }

    @Override
    public int compareTo(Word o) {
        return this.getWord_target().compareToIgnoreCase(o.getWord_target());
    }
    
    public boolean equals(Object o){
        try{
            Word word = (Word) o;
            return this.getWord_target().equals(word.getWord_target());
        }
        catch (Exception ex){
            return (this == o);
        }
    }
    
    public int hashCode(){
        return this.word_target.hashCode();
    }
}

