package com.succApplication.services;

import com.succApplication.entities.Sucker;

import java.util.List;

public interface SuccService {
    Sucker processSuccName(String name);
    List<Sucker> getSuckers (Boolean isSucc);
}
