package com.succApplication.services;

import com.succApplication.entities.CreditPolicyMods;
import com.succApplication.repositories.ContextRepository;
import com.succApplication.repositories.SettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class DefaultContextService implements ContextService {

    @Autowired
    private ContextRepository contextRepository;
    @Autowired
    private SettingsRepository settingsRepository;

    @Override
    public List<Map<String, Object>> getContexts(CreditPolicyMods version){
        return contextRepository.getContexts(
                settingsRepository.getTemplateId(version.getGeg()),
                version.getGeg());
    }
}
