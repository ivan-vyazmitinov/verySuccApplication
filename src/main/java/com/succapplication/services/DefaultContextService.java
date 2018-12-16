package com.succapplication.services;

import com.succapplication.model.CreditPolicyMods;
import com.succapplication.repositories.ContextRepository;
import com.succapplication.repositories.SettingsRepository;
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