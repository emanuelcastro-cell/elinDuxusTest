
package com.teamanalytics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamanalytics.entity.ComposicaoTime;

import java.util.List;

public interface ComposicaoTimeRepository extends JpaRepository<ComposicaoTime, Long> {

    List<ComposicaoTime> findByTimeId(Long timeId);

}
