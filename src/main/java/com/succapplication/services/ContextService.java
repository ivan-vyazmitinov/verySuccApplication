package com.succApplication.services;

import com.succApplication.model.CreditPolicyMods;

import java.util.List;
import java.util.Map;

public interface ContextService {
    List<Map<String, Object>> getContexts(CreditPolicyMods version);
}
