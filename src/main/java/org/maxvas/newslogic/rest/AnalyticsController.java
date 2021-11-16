package org.maxvas.newslogic.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnalyticsController {

    @GetMapping(value = "/test")
    public String test(){
        return "Analytics controller test";
    }

}
