package springBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import languages.imp.English;
import languages.imp.Vietnamese;

@Service
public class VietnameseService {
   
	@Autowired
	private Vietnamese language;
	
	public void sayGreeting() {
		String st = language.getGreeting();
		System.out.println(st);
	}
	
	@Autowired
	private English language2;
	
	public void sayGreeting2() {
		String st = language2.getGreeting();
		System.out.println(st);
	}
}
