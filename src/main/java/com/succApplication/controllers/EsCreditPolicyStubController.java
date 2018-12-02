package com.succApplication.controllers;

import com.succApplication.entities.*;
import com.succApplication.services.ContextService;
import org.springframework.web.bind.annotation.*;

@RestController
public class EsCreditPolicyStubController {

    @RequestMapping(value = "/stubPolicyRequest", method = RequestMethod.POST)
    public EsCreditPolicyStubbedResponse update(@RequestBody EsCreditPolicyRequest request) {

        ContextService contextService = new ContextService();

        return new EsCreditPolicyStubbedResponse(
                request.getKind(),
                request.getParams(),
                contextService.getContexts());
    }
}
