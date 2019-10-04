package com.wretchant.csdnchart.repo;

import com.wretchant.csdnchart.entity.ArchivalStorage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArchivalStorageRepo extends JpaRepository<ArchivalStorage, Long> {

  Optional<ArchivalStorage> findByYearAndMonth(Integer year, Integer month);
}
