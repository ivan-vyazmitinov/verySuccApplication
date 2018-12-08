package com.succApplication.config;

import com.succApplication.repositories.*;
import com.succApplication.services.*;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class AppConfig {

    @Bean
    public ContextService contextService() {
        return new DefaultContextService();
    }

    @Bean
    public ContextRepository contextRepository() {
        return new DefaultContextRepository(configService());
    }

    @Bean
    public SuccService succService() {
        return new DefaultSuccService(succRepository());
    }

    @Bean
    public SettingsRepository settingsRepository() {
        return new DefaultSettingsRepository();
    }

    @Bean
    public ConfigurationService configService() {
        return new DefaultConfigService();
    }

    @Bean
    public SuccRepository succRepository() {
        return new MySqlSuccRepository();
    }
}
