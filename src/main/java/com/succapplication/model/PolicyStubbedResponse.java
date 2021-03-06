package com.succapplication.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PolicyStubbedResponse {
    private String kind;
    private PolicyRequestParams params;
    private List<Map<String, Object>> context;


    // TODO: Данный конструктор не будет использоваться jacksonом. Посмотри в сторону аннотации @JsonCreator и @JsonProperty
    public PolicyStubbedResponse(String kind, PolicyRequestParams params, List<Map<String, Object>> context) {
        this.kind = kind;
        this.params = params;
        this.context = context;
    }

    public String getKind() {
        return kind;
    }

    public PolicyRequestParams getParams() {
        return params;
    }

    public List getContext() {
        return context;
    }
}
