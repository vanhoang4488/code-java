package lab.hoangnv.entity;

import lab.hoangnv.entity.base.BaseEntity;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "nxbs")
public class NxbDocument extends BaseEntity {

    @MongoId(targetType = FieldType.OBJECT_ID)
    private String id;

    private String name;
    private String address;
    private String[] branch;
}
