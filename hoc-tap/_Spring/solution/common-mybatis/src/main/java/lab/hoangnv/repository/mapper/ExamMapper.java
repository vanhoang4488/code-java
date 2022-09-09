package lab.hoangnv.repository.mapper;

import lab.hoangnv.entity.Exam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ExamMapper {

    @Select("SELECT examId FROM yn_platform_exam.examquestion")
    List<Exam> select();
}
