package com.wretchant.csdnchart.service;

import com.wretchant.csdnchart.annotation.InfoLog;
import org.jsoup.nodes.Document;

public interface ConnService {

  @InfoLog("开始抓取数据")
  Document conn(String url) throws Exception;
}
