package com.succApplication.repositories;

import com.succApplication.model.ModeSettings;

public interface SettingsRepository {
    ModeSettings findByMode(String version);
}
