package org.maxvas.newslogic.rest;

import lombok.AllArgsConstructor;
import org.maxvas.newslogic.entity.Factor;
import org.maxvas.newslogic.repository.FactorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/factor")
@AllArgsConstructor
public class FactorController {
    final FactorRepository factorRepository;

    @GetMapping(value = "/")
    public List<Factor> findAll() {
        return factorRepository.findAll();
    }
}
