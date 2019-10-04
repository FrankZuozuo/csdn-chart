package com.wretchant.csdnchart.service;

import com.wretchant.csdnchart.annotation.InfoLog;
import com.wretchant.csdnchart.entity.ArticleInfo;
import com.wretchant.csdnchart.entity.ConduitEnum;

import java.util.List;

public interface ArticleInfoService {

  @InfoLog("创建文章信息")
  ArticleInfo create(ArticleInfo articleInfo);

  @InfoLog("查询全部的文章")
  List<ArticleInfo> list();

  @InfoLog("统计文章一共有多少篇")
  long count();

  @InfoLog("service：查看Conduit 文章列表")
  List<ArticleInfo> list(ConduitEnum conduit);
}
