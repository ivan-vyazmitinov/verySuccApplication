package com.succapplication.service;

import com.succapplication.model.CreditPolicyMods;
import com.succapplication.repository.ContextRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DefaultContextService implements ContextService {

    private ContextRepository contextRepository;

    @Autowired
    public DefaultContextService(ContextRepository contextRepository) {
        this.contextRepository = contextRepository;
    }

    @Override
    public List<Map<String, Object>> getContextsForMode(CreditPolicyMods version) {
        return contextRepository.findActiveByMode(version)
                .stream()
                .flatMap(n -> n.getContext().stream())
                .collect(Collectors.toList());
    }
}