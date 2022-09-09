package lab.hoangnv.repository.impl;

import lab.hoangnv.entity.SubjectDocument;
import lab.hoangnv.repository.CustomSubjectRepositoryAb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.BasicUpdate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;


@Repository
public class CustomSubjectRepositoryAbImpl implements CustomSubjectRepositoryAb {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public SubjectDocument findByObjectId(String id){

        return mongoTemplate.findOne(BasicQuery.query(Criteria.where("_id").is(id)),
                SubjectDocument.class);
    }

    @Override
    public SubjectDocument partialUpdate(String id, String fieldName, Object fieldValue){
        // ở đây đối tượng mongoTemplate trả về không phải đối tượng đã được sửa giá trị.
        // mà là đối tượng ta tìm kiếm được thông qua truy vấn Find().
        // có nghĩa đây là đối tượng trước khi bị sửa đổi.
        return mongoTemplate.findAndModify(BasicQuery.query(Criteria.where("_id").is(id)),
                BasicUpdate.update(fieldName, fieldValue), FindAndModifyOptions.none(), SubjectDocument.class);
    }
}
