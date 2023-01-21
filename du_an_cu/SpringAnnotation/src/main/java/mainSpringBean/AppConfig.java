package mainSpringBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import languages.language;
import languages.imp.English;
import languages.imp.Vietnamese;

@Configuration
@ComponentScan({"springBean"})
public class AppConfig {
    
	@Bean(name="vietnamese")
	public Vietnamese getInstanceVietnamese() {
		return new Vietnamese();
	}
	
	@Bean(name="english")
	public English getInstanceEnglish() {
		return new English();
	}
}
