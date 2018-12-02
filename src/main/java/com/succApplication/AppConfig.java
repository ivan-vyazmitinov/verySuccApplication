package com.succApplication;

import com.succApplication.repositories.ContextRepository;
import com.succApplication.repositories.DefaultContextRepository;
import com.succApplication.repositories.MySqlSuccRepository;
import com.succApplication.repositories.SuccRepository;
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
    @Lazy
    public ContextService contextService() {
        return new DefaultContextService();
    }

    @Bean
    @Lazy
    public ContextRepository contextRepository() {
        return new DefaultContextRepository();
    }

    @Bean
    @Lazy
    public SuccService succService() {
        return new DefaultSuccService();
    }

    @Bean
    @Lazy
    public SuccRepository succRepository() {
        return new MySqlSuccRepository();
    }
}
