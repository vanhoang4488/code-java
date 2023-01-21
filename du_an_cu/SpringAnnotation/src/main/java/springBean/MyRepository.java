package springBean;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class MyRepository {
     
	public Date getDate() {
		return new Date();
	}
	
	public String getString() {
		return "String Apache Name";
	}
}
