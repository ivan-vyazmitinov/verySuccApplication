package com.succApplication.repositories;

import com.succApplication.entities.Sucker;

public interface SuccRepository {
    Sucker findByName(String name);
    void saveNewSucc(Sucker sucker);
}
