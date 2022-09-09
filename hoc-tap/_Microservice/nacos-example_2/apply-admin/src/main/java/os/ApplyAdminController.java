package os;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class ApplyAdminController {

    private final ManageClient manageClient;

    private static final String MSG = "apply-admin";

    @RequestMapping("/service")
    public String getService(){
        log.info("=========>{}<==========", MSG);
        return MSG + ": " + manageClient.getService();
    }
}
