package com.succapplication.service;

import com.succapplication.model.CreditPolicyMods;

import java.util.List;
import java.util.Map;

public interface ContextService {
    List<Map<String, Object>> getContextsForMode(CreditPolicyMods version);
}
