package lab.hoangnv.client;

import lab.hoangnv.entity.base.BaseEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubjectRequestCli extends BaseEntity {

    private String id;
    private String name;
    private String author;
    private String nxb;
    private int grade;
    private String content;
    private String[] comments;
}
