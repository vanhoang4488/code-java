package demo.ctvftech.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface CrudAPI<T, ID> {

	//tìm kiếm thông tin chi tiết dựa vào id.
	ModelAndView findData(HttpServletRequest request, @PathVariable(name = "id") String id);
	
	ModelAndView readData(HttpServletRequest request, @RequestParam(value = "page", required = false) Integer page);
	ModelAndView createData(HttpServletRequest request, @RequestBody T dto) throws Exception;
	ModelAndView updateData(HttpServletRequest request, @RequestBody T dto) throws Exception;
	ModelAndView deleteData(HttpServletRequest request, @RequestParam List<ID> idList);
}
