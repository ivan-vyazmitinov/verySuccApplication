package com.succApplication.controllers;

import com.succApplication.entities.*;
import com.succApplication.services.ContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EsCreditPolicyStubController {

    @Autowired
    private ContextService contextService;

    @PostMapping(value = "/stubPolicyRequest")
    public EsCreditPolicyStubbedResponse update(@RequestBody EsCreditPolicyRequest request) {
        return new EsCreditPolicyStubbedResponse(
                request.getKind(),
                request.getParams(),
                contextService.getContexts());
    }
}
