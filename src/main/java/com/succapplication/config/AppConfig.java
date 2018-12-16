package com.succapplication.config;

import com.succapplication.repository.*;
import com.succapplication.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class AppConfig {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Bean
    public ContextService contextService() {
        return new DefaultContextService(contextRepository());
    }

    @Bean
    public ContextRepository contextRepository() {
        return new DefaultContextRepository(mongoTemplate);
    }

    @Bean
    public SettingsRepository settingsRepository() {
        return new DefaultSettingsRepository();
    }

    @Bean
    public TemplateService templateService() {
        return new DefaultTemplateService(contextRepository());
    }
}
