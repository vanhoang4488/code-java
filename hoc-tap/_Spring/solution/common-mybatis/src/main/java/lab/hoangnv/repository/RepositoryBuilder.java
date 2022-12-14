package lab.hoangnv.repository;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;

@Repository
public class RepositoryBuilder {

    private volatile static SqlSessionFactory sqlSessionFactory;
    private RepositoryBuilder(){}
    public static SqlSessionFactory getInstance() throws IOException {
        if(sqlSessionFactory == null){
            synchronized (RepositoryBuilder.class){
                if(sqlSessionFactory == null){
                    String resource = "mybatis/mybatis-config.xml";
                    InputStream inputStream = Resources.getResourceAsStream(resource);
                    sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                }
            }
        }

        return sqlSessionFactory;
    }
}
