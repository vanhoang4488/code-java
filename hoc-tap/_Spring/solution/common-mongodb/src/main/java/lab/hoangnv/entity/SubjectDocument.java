package lab.hoangnv.entity;

import lab.hoangnv.entity.base.BaseEntity;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "subject")
public class SubjectDocument extends BaseEntity {

    @MongoId(targetType = FieldType.OBJECT_ID)
    private String id;

    private String name;
    private AuthorDocument author;
    private NxbDocument nxb;
    private int grade;
    private String content;
    private String[] comments;
}
