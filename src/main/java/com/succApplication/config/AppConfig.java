package com.succApplication.config;

import com.succApplication.repositories.*;
import com.succApplication.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ContextService contextService() {
        return new DefaultContextService();
    }

    @Bean
    public SuccService succService() {
        return new DefaultSuccService(succRepository());
    }

    @Bean
    public ConfigurationService configService() {
        return new DefaultConfigService();
    }

    @Bean
    public SuccRepository succRepository() {
        return new MySqlSuccRepository();
    }

    @Bean
    public ContextRepository contextRepository(){
        return new DefaultContextRepository();
    }
}
