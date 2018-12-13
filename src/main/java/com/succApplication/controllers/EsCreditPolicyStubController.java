package com.succApplication.controllers;

import com.succApplication.model.*;
import com.succApplication.services.ContextService;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EsCreditPolicyStubController {

    @Autowired
    private ContextService contextService;

    @PostMapping(value = "/es-credit-policy-2/credit-policy/{version}/decision")
    public ApiResponse stubPolicyRequest(
            @RequestBody PolicyRequest request,
            @PathVariable("version") CreditPolicyMods version) {
        return Try.of(() -> version)
                .map(p -> contextService.getContexts(version))
                .map(p -> new PolicyStubbedResponse(
                        request.getKind(),
                        request.getParams(),
                        p))
                .map(ApiResponse::answer)
                .onFailure(e -> System.out.println("Something went wrong"))
                .get();
    }
}
