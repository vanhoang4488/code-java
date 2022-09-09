package lab.hoangnv.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Exam {
    private String examId;

    @Override
    public String toString(){
        return examId;
    }
}
