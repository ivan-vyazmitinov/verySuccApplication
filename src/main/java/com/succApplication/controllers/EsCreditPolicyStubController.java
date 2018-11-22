package com.succApplication.controllers;

import com.succApplication.entities.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class EsCreditPolicyStubController {

    @RequestMapping(value = "/stubPolicyRequest", method = RequestMethod.POST)
    public EsCreditPolicyStubbedResponse update(@RequestBody EsCreditPolicyRequest request) {

        EsCreditPolicyContext context = new EsCreditPolicyContext("score50_PDL_noInstantor", "SKIP");
        return new EsCreditPolicyStubbedResponse(
                request.getKind(),
                request.getParams(),
                context);
    }
}
