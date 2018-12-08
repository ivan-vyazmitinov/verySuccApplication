package com.succApplication.repositories;

import com.succApplication.entities.CreditPolicyMods;
import org.bson.types.ObjectId;

public interface SettingsRepository {
    ObjectId getTemplateId(String version);
}
