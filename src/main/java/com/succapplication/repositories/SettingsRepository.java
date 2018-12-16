package com.succapplication.repositories;

import com.succapplication.model.ModeSettings;

public interface SettingsRepository {
    ModeSettings findByMode(String version);
}
