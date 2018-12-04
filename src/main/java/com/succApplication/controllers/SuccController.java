package com.succApplication.controllers;

import com.succApplication.entities.Sucker;
import com.succApplication.services.SuccService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class SuccController {

    final private SuccService succService;

    @Autowired
    public SuccController(SuccService succService) {
        this.succService = succService;
    }

    @GetMapping("/succ")
    public Optional<Object> succ(@RequestParam(value = "name", defaultValue = "Nobody") String name) {
        return Optional
                .ofNullable(name)
                .map(succService::processSuccName);
    }

    @GetMapping("/getSucc")
    public Optional<Object> getSucc(@RequestParam(value = "succ", defaultValue = "true") Boolean succ) {
        return Optional
                .ofNullable(succ)
                .map(n -> succService.getSuckers(succ));
    }
}
