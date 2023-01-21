package demo.ctvftech.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import demo.ctvftech.models.User;
import demo.ctvftech.service.MyService;

@Controller
@RequestMapping("/user")
public class UserAPI {

	@Autowired
	private MyService service;
	
	@GetMapping("/")
	public String selectData(@RequestParam(name="page", required=false) Integer page){
		
		if(page == null) page = 1;
		
		//List<User> list = service.readData(request, page);
		System.out.println("------------------");
		return "?????";
	}
}
