package com.greenfoxacademy.frontend.DTOs;

import com.greenfoxacademy.frontend.Entities.Log;

import java.util.List;

public class LogDTO {

    List<Log> entries;

    Integer entryCount;

    public List<Log> getEntries() {
        return entries;
    }

    public void setEntries(List<Log> entries) {
        this.entries = entries;
    }

    public Integer getEntryCount() {
        return entryCount;
    }

    public void setEntryCount(Integer entryCount) {
        this.entryCount = entryCount;
    }
}
