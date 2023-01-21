package demo.ctvftech.connector;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConnector {

	private static MybatisConnector instance;
	private SqlSessionFactory sqlSessionFactory;
	
	private MybatisConnector() throws IOException {
		
		String resource = "META-INF/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public static MybatisConnector getInstance() throws IOException {
		
		if(instance == null) 
			instance = new MybatisConnector();
		
		return instance;
	}
	
	public SqlSessionFactory getSqlSessionFactory() {
		
		return sqlSessionFactory;
	}
}
