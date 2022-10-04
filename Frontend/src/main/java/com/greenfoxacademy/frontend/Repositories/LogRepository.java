package com.greenfoxacademy.frontend.Repositories;

import com.greenfoxacademy.frontend.Entities.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

}
