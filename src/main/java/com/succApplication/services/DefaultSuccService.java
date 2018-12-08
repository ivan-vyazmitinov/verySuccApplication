package com.succApplication.services;

import com.succApplication.entities.Sucker;
import com.succApplication.repositories.SuccRepository;

import java.util.List;
import java.util.Random;

public class DefaultSuccService implements SuccService {

    private SuccRepository succRepository;
    final private Random random = new Random();

    public DefaultSuccService(SuccRepository succRepository) {
        this.succRepository = succRepository;
    }

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

    @Override
    public List<Sucker> getSuckers (Boolean isSucc){
        return succRepository.fetchBySucc(isSucc);
    }


}
