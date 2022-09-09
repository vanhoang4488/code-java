package paltform.ctv.client.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import paltform.ctv.service.impl.ImageService;

@RestController
@RequestMapping("/subject")
public class ImageScanByMathpixAPI {

    @Autowired
    private ImageService service;

    @PostMapping(value = "/imageScan", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> imageScan(@RequestParam String path){

        return service.process(path);
    }
}
