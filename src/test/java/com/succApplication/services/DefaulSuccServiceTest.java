package com.succApplication.services;

import com.succApplication.config.AppConfig;
import com.succApplication.entities.Sucker;
import com.succApplication.repositories.MySqlSuccRepository;
import com.succApplication.repositories.SuccRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class DefaulSuccServiceTest {

    @InjectMocks
    SuccService succService  = new DefaultSuccService(new MySqlSuccRepository());

    @Mock
    SuccRepository succRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGettingExistingSuck() {
        Sucker suckerDummy = new Sucker("Antonekn", false);
        when(succRepository.findByName(anyString())).thenReturn(Optional.of(suckerDummy));

        Sucker result = succService.processSuccName("Antonekn");

        Assert.assertEquals(suckerDummy, result);
    }

    @Test
    public void testProcessingNewSucc() {
        Sucker suckerDummy = new Sucker("Antonekn", false);
        when(succRepository.findByName(anyString())).thenReturn(Optional.empty());

        Sucker result = succService.processSuccName("Antonekn");

        Assert.assertEquals(suckerDummy, result);
    }

}
