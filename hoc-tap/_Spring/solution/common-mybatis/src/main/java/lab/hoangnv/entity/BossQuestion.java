package lab.hoangnv.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BossQuestion {
    private String branchId;
    private String knowledgeTreeId;
    private String grade;
    private String sourceType;

    @Override
    public String toString(){
        return String.format("%s,%s,%s,%s", sourceType, branchId, knowledgeTreeId, grade);
    }
}
