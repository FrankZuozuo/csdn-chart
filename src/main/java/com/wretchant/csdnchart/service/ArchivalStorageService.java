package com.wretchant.csdnchart.service;

import com.wretchant.csdnchart.annotation.InfoLog;
import com.wretchant.csdnchart.entity.ArchivalStorage;

import java.util.List;

public interface ArchivalStorageService {

  @InfoLog("创建文章数据归档统计")
  ArchivalStorage create(ArchivalStorage archivalStorage);

  @InfoLog("查询全部的文章归档数据")
  List<ArchivalStorage> list();
}
