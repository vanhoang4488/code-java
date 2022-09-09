package App;

public class Word implements Comparable<Word> {
    private String word_target;
    private String word_explain;

    public Word() {
        word_target = null;
        word_explain = null;
    }

    public Word(String _word_target, String _word_explain) {
        this.word_target = _word_target;
        this.word_explain = _word_explain;
    }

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

    @Override
    public int compareTo(Word o) {
        return getWord_target().compareTo(o.getWord_target());
    }

    public String toString(){
        return this.getWord_target();
    }
}