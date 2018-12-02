package com.succApplication.services;

import com.succApplication.repositories.ContextRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class DefaultContextService implements ContextService {

    @Autowired
    private ContextRepository contextRepository;

    @Override
    public List<Map<String, Object>> getContexts(){
        return contextRepository.getContexts();
    }

}
