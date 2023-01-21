package demo.ctvftech.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.ctvftech.entity.WorksEntity;
import demo.ctvftech.entity.relationship.WorkAssginEntity;
import demo.ctvftech.repository.DefaultIDFactory;

@Service
public class WorksService extends CrudService<WorksEntity, String>{

	@Autowired
	private DefaultIDFactory idFactory;
	
	@Override
	public DefaultIDFactory getIDFactory() {
		
		return idFactory;
	}
	
	// tìm kiếm thông tin lịch phân công theo công việc đó, hay danh sách nhân viên được thực hiện công việc đó.
	public List<WorkAssginEntity> findTuples(String id){
		
		String hql = "SELECT * FROM WorkAssginEntity WHERE work_id = :id";
		
		Query query = this.getRepository().get().createQuery(hql);
		
		query.setParameter("id", id);
		
		@SuppressWarnings("unchecked")
		List<WorkAssginEntity> list = new ArrayList<WorkAssginEntity>(query.getResultList());
		
		return list;
	}
}
