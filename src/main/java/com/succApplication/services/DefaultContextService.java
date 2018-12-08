package com.succApplication.services;

import com.succApplication.entities.CreditPolicyMods;
import com.succApplication.repositories.ContextRepository;
import com.succApplication.repositories.SettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.succApplication.entities.CreditPolicyMods.MAIN_POLICY;
import static com.succApplication.entities.CreditPolicyMods.PRELIMINARY_POLICY;

public class DefaultContextService implements ContextService {

    @Autowired
    private ContextRepository contextRepository;
    @Autowired
    private SettingsRepository settingsRepository;

    private Map<CreditPolicyMods, String> versionModeMap = new HashMap<>();

    {
        versionModeMap.put(MAIN_POLICY,"main-policy");
        versionModeMap.put(PRELIMINARY_POLICY,"preliminary-policy");
    }

    @Override
    public List<Map<String, Object>> getContexts(CreditPolicyMods version){
        return contextRepository.getContexts(
                settingsRepository.getTemplateId(versionModeMap.get(version)),
                versionModeMap.get(version));
    }
}
