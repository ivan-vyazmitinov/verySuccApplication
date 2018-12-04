package com.succApplication.repositories;

import com.succApplication.entities.Sucker;

import java.util.List;
import java.util.Optional;

public interface SuccRepository {
    Optional<Sucker> findByName(String name);
    void saveNewSucc(Sucker sucker);
    List<Sucker> fetchBySucc(boolean isSucc);
}
