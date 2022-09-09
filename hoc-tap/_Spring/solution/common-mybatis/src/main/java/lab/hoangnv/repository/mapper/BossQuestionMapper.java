package lab.hoangnv.repository.mapper;

import lab.hoangnv.entity.BossQuestion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BossQuestionMapper {

    @Select("SELECT branchId, knowledgeTreeIds, grade, sourceType FROM yn_platform_exam.question")
    List<BossQuestion> select();
}
