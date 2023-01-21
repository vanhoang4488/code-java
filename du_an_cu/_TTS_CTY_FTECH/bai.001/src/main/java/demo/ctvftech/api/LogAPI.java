package demo.ctvftech.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import demo.ctvftech.dto.Log;
import demo.ctvftech.entity.LogsEntity;
import demo.ctvftech.services.LogsService;

@RestController
public class LogAPI {
	
	@Autowired
	private LogsService service;
	
	@GetMapping("/log/")
	public ModelAndView readData(HttpServletRequest request, @RequestParam(name="page", required=false) Integer page) {
		
		if(page == null) page = 1;
		
		List<Log> list = new ArrayList<>();
		
		for(LogsEntity entity : service.readData("LogsEntity", page)) 
			list.add(new Log(entity));
			
		request.setAttribute("logs", list);
		
		return new ModelAndView("log");
	}

}
