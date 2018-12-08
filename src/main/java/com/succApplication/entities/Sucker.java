package com.succApplication.entities;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Sucker {

    private Long id;
    private String name;
    private Boolean succ;

    public Sucker(String name, Boolean succ) {
        this.name = name;
        this.succ = succ;
    }

    public Sucker(Long id, String name, Boolean succ) {
        this.id = id;
        this.name = name;
        this.succ = succ;
    }

    public String getName() {
        return name;
    }

    public Boolean getSucc() {
        return succ;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sucker sucker = (Sucker) o;
        return Objects.equals(name, sucker.name) &&
                Objects.equals(succ, sucker.succ);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, succ);
    }
}
