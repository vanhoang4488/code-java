package pj.hoangnv;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConfigurationProperties
public class TestController {

    public int waitMillis;

    @Value("${spring.application.name}")
    public String port;

    @GetMapping("/test")
    public String test() {
        System.out.println(waitMillis);
        System.out.println(port);
        return "ok";
    }

    public int getWaitMillis() {
        return waitMillis;
    }

    public void setWaitMillis(int waitMillis) {
        this.waitMillis = waitMillis;
    }
}
