package com.succApplication.repositories;

import com.succApplication.model.ModeSettings;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SettingsRepository {
    ModeSettings findByMode(String version);
}
