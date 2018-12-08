package com.succApplication.repositories;

import com.succApplication.config.AppConfig;
import com.succApplication.services.ConfigurationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class GetContextsTest {

    @Autowired
    DefaultContextRepository repo;

    @Test
    public void testGettingSuck() {
        System.out.println(repo.getContexts(1, "main-policy"));
    }
}
