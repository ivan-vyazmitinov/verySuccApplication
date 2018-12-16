package com.succapplication.service;

import com.succapplication.model.PolicyTemplate;
import com.succapplication.repository.ContextRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DefaultTemplateService implements TemplateService {                          // TODO: синхронайдз?
    private ContextRepository contextRepository;

    @Autowired
    public DefaultTemplateService(ContextRepository contextRepository) {
        this.contextRepository = contextRepository;
    }

    @Override
    public PolicyTemplate getTemplateByName(String name) {
        return contextRepository.findByName(name);
    }

    @Override
    public List<PolicyTemplate> getTemplates() {
        return contextRepository.findAll();
    }

    @Override
    public String createNewTemplate(PolicyTemplate policyTemplate) {
        if (Optional.ofNullable(getTemplateByName(policyTemplate.getName())).isPresent()){
            return "Template " + policyTemplate.getName() + " already exists";
        } else {
            contextRepository.createNewTemplate(policyTemplate);
            return "Template " + policyTemplate.getName() + " created";
        }
    }

    @Override
    public String removeTemplate(String name) {
        if (Optional.ofNullable(getTemplateByName(name)).isPresent()){
            contextRepository.removeTemplate(name);
            return "Template " + name + " removed";
        } else {
            return "Template " + name + " doesn't exist";
        }
    }

    @Override
    public String updateTemplate(PolicyTemplate policyTemplate) {
        if (Optional.ofNullable(contextRepository.updateTemplate(policyTemplate)).isPresent()){
            return "Updated " + policyTemplate.getName();
        } else {
            return "Didn't find " + policyTemplate.getName();
        }
    }
}
