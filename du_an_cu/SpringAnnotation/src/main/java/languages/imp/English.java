package languages.imp;

import languages.language;

public class English implements language{
    
	public String getGreeting() {
		return "Hello";
	}
	
	public String getBye() {
		return "Bye bye";
	}
}
