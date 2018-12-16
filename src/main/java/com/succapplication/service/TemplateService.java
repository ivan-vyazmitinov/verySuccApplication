package com.succapplication.service;

import com.succapplication.model.PolicyTemplate;

import java.util.List;

public interface TemplateService {
    PolicyTemplate getTemplateByName(String name);
    List<PolicyTemplate> getTemplates();
    String createNewTemplate(PolicyTemplate policyTemplate);
    String removeTemplate(String name);
    String updateTemplate(PolicyTemplate policyTemplate);
}
