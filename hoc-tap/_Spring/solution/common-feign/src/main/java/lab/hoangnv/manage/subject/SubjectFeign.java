package lab.hoangnv.manage.subject;

import lab.hoangnv.config.FeignAuthConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "${manage.application.name}",
        fallback = SubjectFallBackImpl.class,
        configuration = FeignAuthConfig.class,
        path = "/ftech.gg.ai")
public interface SubjectFeign {

    void sync();
}
