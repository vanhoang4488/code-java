package lab.hoangnv.repository.impl;

import lab.hoangnv.entity.SubjectDocument;
import lab.hoangnv.repository.CustomSubjectRepositoryAb;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRespository extends MongoRepository<SubjectDocument, String>, CustomSubjectRepositoryAb {
}
