package lab.hoangnv.repository.impl;

import lab.hoangnv.entity.Exam;
import lab.hoangnv.repository.AbstractRepository;
import lab.hoangnv.repository.IRepository;
import lab.hoangnv.repository.RepositoryBuilder;
import lab.hoangnv.repository.mapper.ExamMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class ExamRepository extends AbstractRepository implements IRepository<Exam, String> {

    @Override
    public List<Exam> select(){
        List<Exam> exams = null;
        try(SqlSession session = RepositoryBuilder.getInstance().openSession()){
            ExamMapper mapper = session.getMapper(ExamMapper.class);
            exams = mapper.select();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return exams;
    }
}
