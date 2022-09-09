package lab.hoangnv.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public abstract class AbstractService {

    @Value("${exam.filename}")
    public String examFilename;

    @Value("${bossQuestion.filename}")
    public String bossQuestionFilename;
}
