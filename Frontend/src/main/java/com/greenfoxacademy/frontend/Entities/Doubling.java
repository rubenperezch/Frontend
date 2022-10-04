package com.greenfoxacademy.frontend.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Doubling {
    private Long id;

    private Integer input;

    private Integer result;

    public Doubling() {
    }

    public Doubling(Integer input) {
        this.input = input;
        this.result = input*2;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public Integer getInput() {
        return input;
    }

    public void setInput(Integer input) {
        this.input = input;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
