package com.greenfoxacademy.frontend.Services;

import com.greenfoxacademy.frontend.DTOs.DTO;
import com.greenfoxacademy.frontend.DTOs.LogDTO;
import com.greenfoxacademy.frontend.Entities.Log;
import com.greenfoxacademy.frontend.Repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogService {

    LogRepository logRepository;

    @Autowired
    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }


    public void saveLogEntry(String endpoint, String data) {
        Log log = new Log(endpoint, data);

        logRepository.save(log);
    }

    public LogDTO returnLogEntry() {
        List<Log> logList = logRepository.findAll().stream().collect(Collectors.toList());

        LogDTO logDTO = new LogDTO();

        logDTO.setEntries(logList);
        logDTO.setEntryCount(logList.size());

        return logDTO;
    }
}
