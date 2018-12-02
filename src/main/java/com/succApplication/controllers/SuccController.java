package com.succApplication.controllers;

import com.succApplication.entities.*;
import com.succApplication.services.SuccService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
public class SuccController {

    final private SuccService succService;

    @Autowired
    public SuccController(SuccService succService) {
        this.succService = succService;
    }

    @RequestMapping("/succ")
    public Optional<Sucker> succ(@RequestParam(value="name", defaultValue="Nobody") String name) {
        return Optional
                .ofNullable(name)
                .map(succService::processSuccName);
    }

}
