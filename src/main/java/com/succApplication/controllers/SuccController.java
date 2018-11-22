package com.succApplication.controllers;

import com.succApplication.entities.*;
import com.succApplication.services.ServiceLocator;
import com.succApplication.services.SuccService;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
public class SuccController {

    final private SuccService succService = ServiceLocator.getService(SuccService.class);

    @RequestMapping("/succ")
    public Sucker succ(@RequestParam(value="name", defaultValue="Nobody") String name) {
        return Optional
                .ofNullable(name)
                .map(succService::processSuccName).get();
    }
}
