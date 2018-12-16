package com.succapplication.controller;

import com.succapplication.model.*;
import com.succapplication.service.TemplateService;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DefaultTemplateController {
    private TemplateService templateService;

    @Autowired
    public DefaultTemplateController(TemplateService templateService) {
        this.templateService = templateService;
    }

    @GetMapping(value = "/context/{name}")
    public ApiResponse getTemplateByNameRequest(@PathVariable(value = "name") String name) {
        return Try.of(() -> templateService.getTemplateByName(name))
                .map(ApiResponse::ok)
                .onFailure(e -> System.out.println("Problem while fetching contexts by name: " + e))
                .get();
    }

    @GetMapping(value = "/context")
    public ApiResponse getTemplatesRequest() {
        return Try.of(() -> templateService.getTemplates())
                .map(ApiResponse::ok)
                .onFailure(e -> System.out.println("Problem while fetching contexts: " + e))
                .get();
    }

    @PostMapping(value = "/context")
    public ApiResponse createTemplateRequest(@RequestBody PolicyTemplate template) {
        return Try.of(() -> templateService.createNewTemplate(template))
                .map(ApiResponse::ok)
                .onFailure(e -> System.out.println("Problem while creating new template"))
                .get();
    }

    @DeleteMapping(value = "/context/{name}")
    public ApiResponse deleteTemplateRequest(@PathVariable(value = "name") String name) {
        return Try.of(() -> templateService.removeTemplate(name))
                .map(ApiResponse::ok)
                .onFailure(e -> System.out.println("Problem while removing template: " + e))
                .get();
    }

    @PutMapping
    public ApiResponse updateTemplateRequest(@RequestBody PolicyTemplate template) {
        return Try.of(() -> templateService.updateTemplate(template))
                .map(ApiResponse::ok)
                .onFailure(e -> System.out.println("Problem while updating template: " + e))
                .get();
    }
}
