/*
 * Xử lý phần thêm, xóa, sửa bảng offices
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

import demo.ctvftech.dto.Office;
import demo.ctvftech.entity.EmployeesEntity;
import demo.ctvftech.entity.OfficesEntity;
import demo.ctvftech.services.OfficesService;

@RestController
@RequestMapping("/office")
public class OfficeAPI implements CrudAPI<Office, String>{

	@Autowired
	private OfficesService service;
	
	private final String symbol = "OFTECH";

	@Override
	@GetMapping("/{id}")
	public ModelAndView findData(HttpServletRequest request, @PathVariable(name = "id") String id) {
		
		if(id == null || id.isEmpty()) return new ModelAndView("office");
		
		Office office = new Office(service.findTuple(OfficesEntity.class, id));
		
		request.setAttribute("office", office);
		
		return new ModelAndView("officeInfo");
		
	}
	
	@GetMapping(value = "/")
	public ModelAndView readData(HttpServletRequest request, @RequestParam(value = "page", required = false) Integer page) {

		if (page == null)
			page = 1;

		List<Office> list = new ArrayList<>();

		for (OfficesEntity entity : service.readData("OfficesEntity", page)) {

			list.add(new Office(entity));
		}
		
		request.setAttribute("offices", list);

		return new ModelAndView("office");
	}

	@PostMapping(value = "/")
	public ModelAndView createData(HttpServletRequest request, @RequestBody Office office) throws Exception {
		
		if (!service.checkId("OfficesEntity", office.getManagerId())) {
			
			request.setAttribute("notice", "Mã người quản lý không tồn tại");
			
			return new ModelAndView("officeInfo");
		}

		OfficesEntity entity = office.toEntity();

		entity.setManagerId(new EmployeesEntity(office.getManagerId()));
		
		if (!service.createData(entity, symbol))
			return new ModelAndView("error");
		
		return new ModelAndView("officeInfo");
	}

	@PutMapping(value = "/")
	public ModelAndView updateData(HttpServletRequest request, @RequestBody Office office) throws Exception{
		
		if (!service.checkId("OfficesEntity", office.getManagerId())) {
			
			request.setAttribute("notice", "Mã người quản lý không tồn tại");
			
			return new ModelAndView("officeInfo");
		}

		OfficesEntity entity = office.toEntity();
		
		entity.setManagerId(new EmployeesEntity(office.getManagerId()));
		
		if (!service.updateData(entity, entity.getId()))
			return new ModelAndView("error");
		
		return new ModelAndView("officeInfo");
	}

	@DeleteMapping(value = "/")
	public ModelAndView deleteData(HttpServletRequest request, @RequestParam List<String> idList) {

		for(String id : idList)
			service.deleteData(OfficesEntity.class, id);
		
		return new ModelAndView("office");
	}
}
