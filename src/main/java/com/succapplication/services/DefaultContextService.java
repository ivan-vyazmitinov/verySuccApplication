package com.succApplication.services;

import com.succApplication.model.CreditPolicyMods;
import com.succApplication.repositories.ContextRepository;
import com.succApplication.repositories.SettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DefaultContextService implements ContextService {

    @Autowired
    private ContextRepository contextRepository;
    @Autowired
    private SettingsRepository settingsRepository;

    @Override
    public List<Map<String, Object>> getContexts(CreditPolicyMods version)
    {
        return contextRepository.findByMode(version.getPolicyName())
                .stream()
                .flatMap(n -> n.getContext().stream())
                .collect(Collectors.toList());
    }
}