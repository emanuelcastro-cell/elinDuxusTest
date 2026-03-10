
package com.teamanalytics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamanalytics.entity.Time;

import java.time.LocalDate;
import java.util.*;

public interface TimeRepository extends JpaRepository<Time, Long> {

    Optional<Time> findByData(LocalDate data);

    List<Time> findByDataBetween(LocalDate inicio, LocalDate fim);
}
