package demo.ctvftech.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeAPI {

	@GetMapping(value = "/")
	public ModelAndView home() {
		
		return new ModelAndView("home");
	}
}
