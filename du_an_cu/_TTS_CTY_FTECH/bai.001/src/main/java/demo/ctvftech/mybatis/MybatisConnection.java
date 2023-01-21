package demo.ctvftech.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConnection {

	private static MybatisConnection INSTANCE;
	private SqlSessionFactory sqlSessionFactory;
	
	private MybatisConnection() throws IOException {
		
		String resource = "src/main/resources/META-INF/mybatis-config.xml";
		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public static MybatisConnection getInstance() throws IOException {
		
		if(INSTANCE == null) {
			
			INSTANCE = new MybatisConnection();
		}
		
		return 	INSTANCE;
	}
	
	public SqlSessionFactory getSqlSessionFactory() {
		
		return sqlSessionFactory;
	}
}
