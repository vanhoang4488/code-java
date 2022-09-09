package lab.hoangnv.service.impl;

import lab.hoangnv.client.SubjectRequestCli;
import lab.hoangnv.entity.SubjectDocument;
import lab.hoangnv.repository.impl.SubjectRespository;
import lab.hoangnv.service.AbstractService;
import lab.hoangnv.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectService extends AbstractService implements IService {

    @Autowired
    private SubjectRespository subjectRespository;

    /*
    * Ở đây ta sẽ tiến hành tìm document theo id
    * Nhưng id của ta có 2 dạng:
    * +> 1 là ObjectId do mongodb tự tạo.
    * +> 2 là id dạng chuỗi do ta tự thêm vào.
     */
    public SubjectRequestCli findByObjectId(String id){
        SubjectDocument document = subjectRespository.findByObjectId(id);

        return subjectConvert.convert(document);
    }

    public List<SubjectRequestCli> findByCurrentPage(int currentPage, int pageSize){
        int skipSize = (currentPage - 1) * pageSize;
        Pageable pageable = PageRequest.of(skipSize, pageSize);
        List<SubjectDocument> documents = subjectRespository.findAll(pageable).toList();

        List<SubjectRequestCli> subjects = documents.stream()
                .map(subjectDocument -> subjectConvert.convert(subjectDocument))
                .collect(Collectors.toList());

        return subjects;
    }

    public List<SubjectDocument> saveAll(List<SubjectDocument> documents){

        if(documents == null || documents.isEmpty()) return null;

        return subjectRespository.saveAll(documents);
    }

    public SubjectRequestCli partialUpdate(String id, String fieldName, Object fieldValue){

        return subjectConvert.convert(subjectRespository.partialUpdate(id, fieldName, fieldValue));
    }
}
