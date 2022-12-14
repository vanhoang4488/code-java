package com.os;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value="manage", path = "/manage")
public interface ManageClient {

    @RequestMapping("/service")
    public String getService();
}
