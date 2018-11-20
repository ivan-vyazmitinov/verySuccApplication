package com.succApplication.services;

import com.succApplication.entities.Sucker;
import com.succApplication.repositories.SuccRepository;

import java.util.Optional;
import java.util.Random;

public class SuccService {

    final private Random random = new Random();
    private SuccRepository succRepository = ServiceLocator.getService(SuccRepository.class);

    public Sucker processSuccName(String name){
        return Optional
                .ofNullable(succRepository.findByName(name))
                .orElseGet(() -> saveNewSucc(name));
    }

    private Sucker saveNewSucc(String name){
        Sucker freshSucker = new Sucker(name, random.nextBoolean());
        succRepository.saveNewSucc(freshSucker);
        return freshSucker;
    }
}
