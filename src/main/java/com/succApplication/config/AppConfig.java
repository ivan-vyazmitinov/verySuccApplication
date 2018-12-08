package com.succApplication.config;

import com.succApplication.repositories.*;
import com.succApplication.services.ContextService;
import com.succApplication.services.DefaultContextService;
import com.succApplication.services.DefaultSuccService;
import com.succApplication.services.SuccService;
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
        return new DefaultContextRepository();
    }

    @Bean
    public SuccService succService() {
        return new DefaultSuccService();
    }

    @Bean
    public SettingsRepository settingsRepository() {
        return new DefaultSettingsRepository();
    }

    @Bean
    public SuccRepository succRepository() {
        return new MySqlSuccRepository();
    }
}
