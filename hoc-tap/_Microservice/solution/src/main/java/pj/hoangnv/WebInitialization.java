package pj.hoangnv;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import pj.hoangnv.config.WebConfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebInitialization implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
        root.register(WebConfig.class);
        root.setServletContext(servletContext);
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher",
                new DispatcherServlet(root));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
