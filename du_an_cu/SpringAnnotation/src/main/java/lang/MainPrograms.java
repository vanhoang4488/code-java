package lang;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import languages.language;
import mainSpringBean.AppConfig;
import springBean.MyComponent;
import springBean.VietnameseService;

public class MainPrograms {
      public static void main(String[] args) {
    	  ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    	  
    	  System.out.println("------------------");
    	  language language = (language) context.getBean("vietnamese");
    	  System.out.println(language);
    	  System.out.println(language.getGreeting());
    	  
    	  language eng = (language) context.getBean("english");
    	  System.out.println(eng);
    	  System.out.println(eng.getGreeting());
    	  
    	  System.out.println("------------------");
    	  VietnameseService vietnamese = (VietnameseService) context.getBean("vietnameseService");
    	  vietnamese.sayGreeting();
    	  
    	  System.out.println("-------------------");
    	  MyComponent component = (MyComponent) context.getBean("myComponent");
    	  component.getTT();
    	  
      }
}
