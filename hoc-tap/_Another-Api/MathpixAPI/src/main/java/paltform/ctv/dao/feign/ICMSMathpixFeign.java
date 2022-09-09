package paltform.ctv.dao.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "CMSMathpixFeign", url="${mathpix.domain}")
public interface ICMSMathpixFeign {

    @PostMapping(path = "/v3/text", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> imageScan(@RequestParam String headers, @RequestParam String files, @RequestParam String data);

    @PostMapping(path = "/v3/pdf", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> pdfScan(@RequestParam String headers, @RequestParam String files, @RequestParam String data);
}
