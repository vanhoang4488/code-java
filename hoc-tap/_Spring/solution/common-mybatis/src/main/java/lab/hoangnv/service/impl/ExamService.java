package lab.hoangnv.service.impl;

import lab.hoangnv.entity.Exam;
import lab.hoangnv.file.DataWriter;
import lab.hoangnv.repository.impl.ExamRepository;
import lab.hoangnv.service.AbstractService;
import lab.hoangnv.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ExamService extends AbstractService implements IService {

    @Autowired
    private ExamRepository repository;

    @Override
    public ResponseEntity<Object> select(){
        List<Exam> data = repository.select();
        try {
            DataWriter.write(examFilename, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("success");
    }
}
