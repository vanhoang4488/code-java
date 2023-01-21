package demo.ctvftech.services;

import java.util.List;

import demo.ctvftech.entity.LogsEntity;
import demo.ctvftech.repository.IRepository;

public interface IService<T, ID>{

	//tìm kiếm thông tin một bộ dựa vào Id.
	T findTuple(Class<T> clazz, ID id);
	
	List<T> readData(String className, int page);
	boolean createData(T entity, String symbol);
	boolean updateData(T entity, ID id);
	boolean deleteData(Class<T> clazz, ID id);
	
	boolean checkId(String className, ID id) throws Exception;
	LogsEntity createLog(String type, T entity, ID id)throws Exception;
	LogsEntity createLog(Class<T> clazz, ID id) throws Exception;
	
	IRepository getRepository();
}
