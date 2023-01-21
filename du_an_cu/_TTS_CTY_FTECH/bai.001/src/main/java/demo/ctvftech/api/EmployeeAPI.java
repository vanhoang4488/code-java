/*
 * Xửa lý thêm, xóa, sửa phần thông tin nhân viên trong bảng employees
 * Không xử lý phần tài khoản đăng nhập của nhân viên.
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

import demo.ctvftech.dto.Employee;
import demo.ctvftech.entity.EmployeesEntity;
import demo.ctvftech.services.EmployeesService;

@RestController
@RequestMapping("/employee")
public class EmployeeAPI implements CrudAPI<Employee, String> {

	@Autowired
	private EmployeesService service;

	private final String symbol = "FTECH";

	@Override
	@GetMapping("/{id}")
	public ModelAndView findData(HttpServletRequest request, @PathVariable(name="id") String id) {
		
		if(id == null || id.isEmpty()) return  new ModelAndView("employee");
		
		Employee employee = new Employee(service.findTuple(EmployeesEntity.class, id));
		
		request.setAttribute("employee", employee);
		
		return new ModelAndView("employeeInfo");
	}
	
	
	@GetMapping(value = "/")
	public ModelAndView readData(HttpServletRequest request, @RequestParam(value = "page", required = false) Integer page) {

		if (page == null)
			page = 1;

		List<Employee> list = new ArrayList<>();

		for (EmployeesEntity entity : service.readData("EmployeesEntity", page)) {

			list.add(new Employee(entity));
		}
		
		request.setAttribute("employees", list);

		return new ModelAndView("employee");
	}

	@PostMapping(value = "/")
	public ModelAndView createData(HttpServletRequest request, @RequestBody Employee employee) throws Exception {

		if (employee.getReportTo() != null) {

			if (!service.checkId("EmployeesEntity", employee.getReportTo())) {
				
				request.setAttribute("notice", "Mã người quản lý không tồn tại");
				
				return new ModelAndView("registerEmployee");
			}
				
		}

		EmployeesEntity entity = employee.toEntity();

		if(employee.getReportTo() != null) 
			entity.setManager( new EmployeesEntity(employee.getReportTo()) );

		if (!service.createData(entity, symbol)) 
			return new ModelAndView("error");
		
		return new ModelAndView("registerEmployee");
	}

	@PutMapping(value = "/")
	public ModelAndView updateData(HttpServletRequest request, @RequestBody Employee employee) throws Exception {

		EmployeesEntity entity = employee.toEntity();

		if(employee.getReportTo() != null) 
			entity.setManager( new EmployeesEntity(employee.getReportTo()) );

		if (!service.updateData(entity, entity.getId()))
			return new ModelAndView("error.jsp");
		
		return new ModelAndView("employeeInfo");
	}

	@DeleteMapping(value = "/")
	public ModelAndView deleteData(HttpServletRequest request, @RequestParam List<String> idList) {

		for(String id : idList) {
			
			service.deleteData(EmployeesEntity.class, id);
		}

		return new ModelAndView("employee");
	}
}
