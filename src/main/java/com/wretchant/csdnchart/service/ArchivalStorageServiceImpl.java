package com.wretchant.csdnchart.service;

import com.wretchant.csdnchart.entity.ArchivalStorage;
import com.wretchant.csdnchart.repo.ArchivalStorageRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArchivalStorageServiceImpl implements ArchivalStorageService {

  private final ArchivalStorageRepo archivalStorageRepo;

  public ArchivalStorageServiceImpl(ArchivalStorageRepo archivalStorageRepo) {
    this.archivalStorageRepo = archivalStorageRepo;
  }

  @Override
  public ArchivalStorage create(ArchivalStorage archivalStorage) {

    Integer year = archivalStorage.getYear();
    Integer month = archivalStorage.getMonth();
    Optional<ArchivalStorage> dbOne = archivalStorageRepo.findByYearAndMonth(year, month);

    // 有则更新，无则创建
    if (dbOne.isPresent()) {
      ArchivalStorage storage = dbOne.get();
      if (archivalStorage.getArticleNumber().equals(storage.getArticleNumber())) {
        return storage;
      }
      storage.setArticleNumber(archivalStorage.getArticleNumber());
      return archivalStorageRepo.saveAndFlush(storage);
    }
    return archivalStorageRepo.saveAndFlush(archivalStorage);
  }

  @Override
  public List<ArchivalStorage> list() {
    return archivalStorageRepo.findAll();
  }
}
