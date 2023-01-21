/*
 * Xửa lý thêm, xóa, sửa bảng works, work_assgin
 */

package demo.ctvftech.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import demo.ctvftech.dto.Work;
import demo.ctvftech.dto.WorkAssgin;
import demo.ctvftech.entity.EmployeesEntity;
import demo.ctvftech.entity.WorksEntity;
import demo.ctvftech.entity.relationship.WorkAssginEntity;
import demo.ctvftech.services.WorksService;

@RestController
@RequestMapping(value = "/work")
public class WorkAPI implements CrudAPI<Work, String> {

	@Autowired
	private WorksService service;

	private final String symbol = "WFTECH";

	@Override
	@GetMapping("/{id}")
	public ModelAndView findData(HttpServletRequest request, @PathVariable(name = "id") String id) {
		
		if(id == null || id.isEmpty()) return new ModelAndView("work");
		
		Work work = new Work(service.findTuple(WorksEntity.class, id));
		
		request.setAttribute("work", work);
		
		List<WorkAssgin> list = new ArrayList<>();
		
		for(WorkAssginEntity entity : service.findTuples(id))
			list.add(new WorkAssgin(entity));
		
		request.setAttribute("employees", list);
		
		return new ModelAndView("workdetail");
	}
	
	@GetMapping(value = "/")
	public ModelAndView readData(HttpServletRequest request, @RequestParam(value = "page", required = false) Integer page) {

		if (page == null)
			page = 1;

		List<Work> list = new ArrayList<>();

		for (WorksEntity entity : service.readData("WorksEntity", page)) {

			list.add(new Work(entity));
		}
		
		request.setAttribute("works", list);

		return new ModelAndView("work");
	}

	@PostMapping(value = "/")
	public ModelAndView createData(HttpServletRequest request, @RequestBody Work work) throws Exception {

		if (!service.checkId("EmployeesEntity", work.getCreatedId())) {
			
			request.setAttribute("notice", "Mã người lên kế hoạch không tồn tại");
			
			return new ModelAndView("workdetail");
		}

		WorksEntity entity = work.toEntity();

		entity.setCreatedEmployee(new EmployeesEntity(work.getCreatedId()));

		if (!service.createData(entity, symbol))
			return new ModelAndView("error");

		return new ModelAndView("workdetail");
	}

	@PutMapping(value = "/")
	public ModelAndView updateData(HttpServletRequest request, @RequestBody Work work) throws Exception {

		if (!service.checkId("EmployeesEntity", work.getCreatedId())) {
			
			request.setAttribute("notice", "Mã người lên kế hoạch không tồn tại");
			
			return new ModelAndView("workdetail");
			
		}

		WorksEntity entity = work.toEntity();

		entity.setCreatedEmployee(new EmployeesEntity(work.getCreatedId()));

		if (!service.updateData(entity, entity.getId()))
			return new ModelAndView("error");

		return new ModelAndView("workdetail");
	}

	@DeleteMapping(value = "/{id}")
	public ModelAndView deleteData(HttpServletRequest request, @RequestParam List<String> idList) {

		for(String id : idList)
			service.deleteData(WorksEntity.class, id);

		return new ModelAndView("work");
	}
}
