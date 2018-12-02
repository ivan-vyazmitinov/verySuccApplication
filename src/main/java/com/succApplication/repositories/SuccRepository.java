package com.succApplication.repositories;

import com.succApplication.entities.Sucker;

import java.util.Optional;

public interface SuccRepository {
    Optional<Sucker> findByName(String name);
    void saveNewSucc(Sucker sucker);
}
