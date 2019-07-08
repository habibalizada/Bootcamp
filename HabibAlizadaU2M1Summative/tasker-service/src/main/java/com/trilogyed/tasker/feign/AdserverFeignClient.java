package com.trilogyed.tasker.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "adserver-service", url = "http://localhost:2121")
public interface AdserverFeignClient {

    @RequestMapping(value = "/ad", method = RequestMethod.GET)
    public String getAd();
}
