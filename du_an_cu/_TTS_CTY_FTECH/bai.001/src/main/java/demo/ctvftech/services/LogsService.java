package demo.ctvftech.services;

import javax.persistence.Query;

import org.springframework.stereotype.Service;

import demo.ctvftech.entity.LogsEntity;
import demo.ctvftech.repository.IDFactory;
import demo.ctvftech.repository.IRepository;

@Service
public class LogsService extends CrudService<LogsEntity, Integer>{

	@Override
	public boolean createData(LogsEntity entity, String symbol) {
		
		return false;
	}
	
	@Override
	public boolean updateData(LogsEntity entity, Integer ID) {
		
		return false;
	}
	
	@Override
	public boolean deleteData(Class<LogsEntity> clazz, Integer ID) {
		
		return false;
	}
	
	@Override
	public IDFactory<Integer> getIDFactory() {
		
		return new IDFactory<Integer>() {

			@Override
			public Integer createID(IRepository repository, String className, String symbol) {
				
				String hql = String.format("SELECT MAX(stt) FROM %s", className);

				Query query = repository.get().createQuery(hql);
				
				return (Integer)query.getResultList().get(0);
			}
			
		};
	}
}
