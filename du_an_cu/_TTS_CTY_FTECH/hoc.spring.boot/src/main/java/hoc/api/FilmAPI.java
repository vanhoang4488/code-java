package hoc.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilmAPI {

	@GetMapping("/film")
	public void getFilmList(@RequestParam(value = "name", required = false) int page) {
		
		
	}
	
	@GetMapping("/film")
	public void getFilmList() {
		
	}
}
