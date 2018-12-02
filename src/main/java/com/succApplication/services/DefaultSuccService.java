package com.succApplication.services;

import com.succApplication.entities.Sucker;
import com.succApplication.repositories.SuccRepository;

import java.util.Random;

public class DefaultSuccService implements SuccService {

    final private Random random = new Random();
    private SuccRepository succRepository = ServiceLocator.getService(SuccRepository.class);

    @Override
    public Sucker processSuccName(String name){
        return succRepository.findByName(name)
                .orElseGet(() -> saveNewSucc(name));
    }

    private Sucker saveNewSucc(String name){
        Sucker freshSucker = new Sucker(name, random.nextBoolean());
        succRepository.saveNewSucc(freshSucker);
        return freshSucker;
    }
}
