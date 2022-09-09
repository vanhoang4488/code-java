package lab.hoangnv.controller;

import lab.hoangnv.client.SubjectRequestCli;
import lab.hoangnv.entity.SubjectDocument;
import lab.hoangnv.service.impl.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/user")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @RequestMapping("/subject/{subjectId}")
    public ResponseEntity<Object> findByObjectId(@PathVariable String subjectId){
        SubjectRequestCli subject = subjectService.findByObjectId(subjectId);
        if(subject == null)
            return ResponseEntity.ok("failed");

        return ResponseEntity.ok(subject);
    }

    @RequestMapping("/subject")
    public ResponseEntity<Object> findByCurrentPage(@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage,
                                            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
        List<SubjectRequestCli> documents = subjectService.findByCurrentPage(currentPage, pageSize);
        return ResponseEntity.ok(documents);
    }

    @PostMapping("/subject")
    public ResponseEntity<Object> saveAll(@RequestBody List<SubjectDocument> documents){

        if(subjectService.saveAll(documents) == null)
            return ResponseEntity.ok("failed");
        return ResponseEntity.ok("success");
    }

    /*
     * Ở đây chúng ta sẽ không làm theo kiểu thô là chèn thằng dữ liệu vào như cách làm với hàm merge của JPA.
     * Mà sẽ tiến hành tìm kiếm và sủa đúng tên cột.
     * trường nào có giá trị không phải null  thì ta sẽ tiến hành sửa giá trị.
     */
    @PutMapping("/subject/{subjectId}")
    public ResponseEntity<Object> partialUpdateSubject(@PathVariable String subjectId,
                                                       @RequestBody SubjectDocument document)
            throws Exception {

        /*
         * Ở đây chúng ta hoàn toàn biết tất cả phương thức của SubjectDocument
         * nhưng vẫn dùng Java Reflection vì muốn tạo ra cách làm chung cho tất cả các lớp entity khác.
         */
        for(final Field field : SubjectDocument.class.getDeclaredFields()){
            String fieldName = field.getName();

            if(fieldName.equals("id")) continue;

            Method method = SubjectDocument.class
                    .getDeclaredMethod("get" + StringUtils.capitalize(fieldName));
            method.setAccessible(true);
            Object fieldValue = method.invoke(document);

            if(Objects.nonNull(fieldValue) && !Objects.equals(fieldValue, 0)){
                SubjectRequestCli subject = subjectService.partialUpdate(subjectId, fieldName, fieldValue);
                return ResponseEntity.ok(subject);
            }
        }

        return ResponseEntity.ok("failed");
    }
}
