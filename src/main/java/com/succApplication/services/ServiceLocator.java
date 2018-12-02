package com.succApplication.services;

import com.succApplication.repositories.*;

import java.util.HashMap;
import java.util.Map;

public class ServiceLocator {
    private static Map<Class, Object> map = new HashMap<>();
    static {
        map.put(ContextRepository.class,  new DefaultContextRepository());
        map.put(SuccRepository.class, new MySqlSuccRepository());
        map.put(SuccService.class,  new SuccService());
    }

    public static <T> T getService (Class c){
        return (T) map.get(c);
    }
}
