package com.succApplication.services;

import com.succApplication.repositories.ContextRepository;

import java.util.List;

public class DefaultContextService implements ContextService {

    private ContextRepository contextRepository = ServiceLocator.getService(ContextRepository.class);

    @Override
    public List getContexts(){
        return contextRepository.getContexts();
    }

}
