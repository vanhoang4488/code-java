package lab.hoangnv.client;

import lab.hoangnv.manage.subject.SubjectFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubjectController {

    @Autowired
    @Qualifier("${manage.application.name}")
    private SubjectFeign subjectFeign;
}
