package com.succApplication.services;

import com.succApplication.repositories.ContextRepository;
import com.succApplication.repositories.SettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultContextService implements ContextService {

    @Autowired
    private ContextRepository contextRepository;
    @Autowired
    private SettingsRepository settingsRepository;

    private Map<String, String> versionModeMap = new HashMap<>();

    {
        versionModeMap.put("MAIN_POLICY","main-policy");
        versionModeMap.put("PRELIMINARY_POLICY","preliminary-policy");
    }

    @Override
    public List<Map<String, Object>> getContexts(String version){
        List<Map<String, Object>> contexts = contextRepository.getContexts(
                settingsRepository.getTemplateId(version),
                versionModeMap.get(version));
        return contexts;
    }
}
