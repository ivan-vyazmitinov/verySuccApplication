package com.succapplication.config;

import com.succapplication.repositories.*;
import com.succapplication.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ContextService contextService() {
        return new DefaultContextService();
    }

    @Bean
    public ConfigurationService configService() {
        return new DefaultConfigService();
    }

    @Bean
    public ContextRepository contextRepository(){
        return new DefaultContextRepository();
    }

    @Bean
    public SettingsRepository settingsRepository(){
        return new DefaultSettingsRepository();
    }
}
