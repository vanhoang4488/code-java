package lab.hoangnv.repository.impl;

import lab.hoangnv.entity.BossQuestion;
import lab.hoangnv.repository.AbstractRepository;
import lab.hoangnv.repository.IRepository;
import lab.hoangnv.repository.RepositoryBuilder;
import lab.hoangnv.repository.mapper.BossQuestionMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class BossQuestionRepository extends AbstractRepository implements IRepository<BossQuestion, String> {

    @Override
    public List<BossQuestion> select(){
        List<BossQuestion> questions = null;
        try(SqlSession session = RepositoryBuilder.getInstance().openSession()){
            BossQuestionMapper mapper = session.getMapper(BossQuestionMapper.class);
            questions = mapper.select();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return questions;
    }
}
