package lab.hoangnv.service.impl;

import lab.hoangnv.entity.BossQuestion;
import lab.hoangnv.file.DataWriter;
import lab.hoangnv.repository.impl.BossQuestionRepository;
import lab.hoangnv.service.AbstractService;
import lab.hoangnv.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BossQuestionService extends AbstractService implements IService {

    @Autowired
    private BossQuestionRepository repository;

    @Override
    public ResponseEntity<Object> select(){
        List<BossQuestion> data = new ArrayList<>();
        try{
            DataWriter.write(bossQuestionFilename, data);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return ResponseEntity.ok("success");
    }
}
