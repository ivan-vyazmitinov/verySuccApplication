package com.succapplication.repository;

import com.succapplication.model.ModeSettings;

public interface SettingsRepository {
    ModeSettings findByMode(String version);
}
