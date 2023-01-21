package hoc.spring_001;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewAPI {

	@GetMapping("/test")
	public String testAPI() {
		return "success";
	}
}
