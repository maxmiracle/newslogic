package org.maxvas.newslogic.rest;

import lombok.AllArgsConstructor;
import org.maxvas.newslogic.repository.ArticleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AnalyticsController {

    final ArticleRepository articleRepository;

    @GetMapping(value = "/test")
    public String test(){
        return "Analytics controller test";
    }

    @GetMapping(value = "/count")
    public String count(){
        return "Articles count: ".concat(String.valueOf(articleRepository.count()));
    }

}
