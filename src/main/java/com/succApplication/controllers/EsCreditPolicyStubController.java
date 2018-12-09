package com.succApplication.controllers;

import com.succApplication.entities.*;
import com.succApplication.services.ContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EsCreditPolicyStubController {

    @Autowired
    private ContextService contextService;

    @PostMapping(value = "/es-credit-policy-2/credit-policy/{version}/decision")
    public PolicyStubbedResponse stubPolicyRequest(
            @RequestBody PolicyRequest request,
            @PathVariable("version") CreditPolicyMods version) {
        return new PolicyStubbedResponse(
                request.getKind(),
                request.getParams(),
                contextService.getContexts(version));
    }
}
