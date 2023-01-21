package demo.ctvftech.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import demo.ctvftech.attributes.RequestATT;
import demo.ctvftech.models.User;

@Service
public class MyService {

	public List<User> readData(HttpServletRequest request, int page){
		
		SqlSession sqlSession = RequestATT.getSqlSession(request);
		
		List<User> list = sqlSession.selectList("userMapper.selectUser", page);
		
		return list;
	}
}
