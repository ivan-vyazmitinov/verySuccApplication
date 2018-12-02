package com.succApplication.services;

import com.succApplication.repositories.ContextRepository;
import com.succApplication.repositories.SuccRepository;

import java.util.List;

public class ContextService {

    private ContextRepository contextRepository = ServiceLocator.getService(ContextRepository.class);

    public List getContexts(){
        return contextRepository.getContexts();
    }

}
