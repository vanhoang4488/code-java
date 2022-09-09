package lab.hoangnv.entity;

import lab.hoangnv.entity.base.BaseEntity;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "authors")
public class AuthorDocument extends BaseEntity {

    @MongoId(targetType = FieldType.OBJECT_ID)
    private String id;

    private String name;
    // Bút danh.
    private String alias;
    private String birthday;
    private String address;
}
