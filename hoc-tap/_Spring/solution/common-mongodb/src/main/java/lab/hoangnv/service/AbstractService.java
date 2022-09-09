package lab.hoangnv.service;

import lab.hoangnv.convert.SubjectConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractService {

    @Autowired
    protected SubjectConvert subjectConvert;
}
