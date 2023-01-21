package springBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyComponent {
	
	@Autowired
	private MyRepository myRepository;
	
	public void getTT() {
		System.out.println(myRepository.getDate());
		System.out.println(myRepository.getString());
	}
}
