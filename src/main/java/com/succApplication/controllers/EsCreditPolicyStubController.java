package com.succApplication.controllers;

import com.succApplication.entities.*;
import com.succApplication.services.ContextService;
import com.succApplication.services.ServiceLocator;
import org.springframework.web.bind.annotation.*;

@RestController
public class EsCreditPolicyStubController {

    private ContextService contextService = ServiceLocator.getService(ContextService.class);

    @RequestMapping(value = "/stubPolicyRequest", method = RequestMethod.POST)
    public EsCreditPolicyStubbedResponse update(@RequestBody EsCreditPolicyRequest request) {
        return new EsCreditPolicyStubbedResponse(
                request.getKind(),
                request.getParams(),
                contextService.getContexts());
    }
}
