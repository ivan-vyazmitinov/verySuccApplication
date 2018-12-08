package com.succApplication.repositories;

import com.succApplication.repositories.DefaultContextRepository;
import org.junit.Test;

public class GetContextsTest {

    @Test
    public void testGettingSuck() {
        DefaultContextRepository repo = new DefaultContextRepository();
        repo.getContexts(1, "main-policy");
    }
}
