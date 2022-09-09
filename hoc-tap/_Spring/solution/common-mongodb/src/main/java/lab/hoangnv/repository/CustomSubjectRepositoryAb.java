package lab.hoangnv.repository;

import lab.hoangnv.entity.SubjectDocument;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomSubjectRepositoryAb {

    SubjectDocument findByObjectId(String id);

    SubjectDocument partialUpdate(String id, String fieldName, Object fieldValue);
}
