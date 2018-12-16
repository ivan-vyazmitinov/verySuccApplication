package com.succapplication.controller;   // имена пакетов называют в единственном числе

import com.succapplication.model.*;
import com.succapplication.service.ContextService;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EsCreditPolicyStubController {

    private ContextService contextService;

    @Autowired
    public EsCreditPolicyStubController(ContextService contextService) {
        this.contextService = contextService;
    }

    @PostMapping(value = "/es-credit-policy-2/credit-policy/{version}/decision")
    public PolicyStubbedResponse stubPolicyRequest(
            @RequestBody PolicyRequest request,
            @PathVariable("version") CreditPolicyMods version) {
        return Try.of(() -> contextService.getContextsForMode(version))
                .map(p -> new PolicyStubbedResponse(
                        request.getKind(),
                        request.getParams(),
                        p))
                .onFailure(e -> System.out.println("Problem while stubbing request"))
                .get();
    }
}
