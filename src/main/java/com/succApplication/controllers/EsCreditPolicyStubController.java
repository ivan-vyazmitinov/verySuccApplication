package com.succApplication.controllers;   // имена пакетов называют в единственном числе

import com.succApplication.model.*;
import com.succApplication.services.ContextService;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EsCreditPolicyStubController {

    @Autowired     // автовайринг нужно делать через конструктор
    private ContextService contextService;


    @PostMapping(value = "/es-credit-policy-2/credit-policy/{version}/decision")
    public ApiResponse stubPolicyRequest(
            @RequestBody PolicyRequest request,
            @PathVariable("version") CreditPolicyMods version) {
        return Try.of(() -> version)   // какой смысл в данной строчке? :)
                .map(p -> contextService.getContexts(version))
                .map(p -> new PolicyStubbedResponse(
                        request.getKind(),
                        request.getParams(),
                        p))
                .map(ApiResponse::answer)  // название метода отстой
                .onFailure(e -> System.out.println("Something went wrong"))
                .get();
    }
}
