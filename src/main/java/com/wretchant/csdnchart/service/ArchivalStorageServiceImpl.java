package com.wretchant.csdnchart.service;

import com.wretchant.csdnchart.entity.ArchivalStorage;
import com.wretchant.csdnchart.repo.ArchivalStorageRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Dream what you want to dream; go where you want to go; be what you want to be; because you have
 * only one life and one chance to do all the things you want to do． - - Online zuozuo / Frank /
 * TANJIAN
 *
 * @author Created by 谭健 on 2019/10/1 星期二 20:38.
 * @link <a href="http://qm.qq.com/cgi-bin/qm/qr?k=FJVK7slBx7qC5tKm_KdFTbwWOFHq1ASt">Join me</a>
 * @link <a href="http://blog.csdn.net/qq_15071263">CSDN Home Page</a>
 *     <p>
 *     <p>© All Rights Reserved.
 */
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
}
