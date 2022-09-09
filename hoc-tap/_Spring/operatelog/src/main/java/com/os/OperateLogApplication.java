package com.os;

import com.os.annotation.EnableOpLog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableOpLog
public class OperateLogApplication extends SpringBootServletInitializer {

    public static void main(String[] args){

        new SpringApplicationBuilder(OperateLogApplication.class)
                .web(WebApplicationType.SERVLET).run(args);
    }

    @Override
    public SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(OperateLogApplication.class);
    }
}
