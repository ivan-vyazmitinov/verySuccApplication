package com.succApplication.repositories;

import com.succApplication.entities.CreditPolicyMods;

public interface SettingsRepository {
    Integer getTemplateId(String version);
}
