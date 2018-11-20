package com.succApplication.controllers;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import com.succApplication.entities.Sucker;
import com.succApplication.services.ServiceLocator;
import com.succApplication.services.SuccService;
import com.succApplication.entities.Greeting ;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    final private SuccService succService = ServiceLocator.getService(SuccService.class);

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @RequestMapping("/succ")
    public Sucker succ(@RequestParam(value="name", defaultValue="Nobody") String name) {
        return Optional
                .ofNullable(name)
                .map(succService::processSuccName).get();
    }
}
