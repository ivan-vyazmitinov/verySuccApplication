package com.succApplication.repositories;

import com.succApplication.entities.ModeSettings;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SettingsRepository  extends MongoRepository<ModeSettings, String> {
    ModeSettings findByMode(String version);
}
