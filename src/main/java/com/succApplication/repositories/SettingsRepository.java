package com.succApplication.repositories;

import com.succApplication.entities.ModeSettings;

public interface SettingsRepository {
    ModeSettings findByMode(String version);
}
