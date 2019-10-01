package com.wretchant.csdnchart.framework;

import com.wretchant.csdnchart.annotation.InfoLog;
import com.wretchant.csdnchart.entity.ArchivalStorage;
import com.wretchant.csdnchart.entity.CsdnConfig;
import com.wretchant.csdnchart.service.ArchivalStorageService;
import com.wretchant.csdnchart.service.ConnService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Dream what you want to dream; go where you want to go; be what you want to be; because you have
 * only one life and one chance to do all the things you want to do． - - Online zuozuo / Frank /
 * TANJIAN
 *
 * @author Created by 谭健 on 2019/10/1 星期二 20:16.
 * @link <a href="http://qm.qq.com/cgi-bin/qm/qr?k=FJVK7slBx7qC5tKm_KdFTbwWOFHq1ASt">Join me</a>
 * @link <a href="http://blog.csdn.net/qq_15071263">CSDN Home Page</a>
 *     <p>
 *     <p>© All Rights Reserved.
 */
@Slf4j
@Component
public class ArchivalStorageInitRunner implements ApplicationRunner {

  private final ArchivalStorageService archivalStorageService;
  private final CsdnConfig csdnConfig;
  private final ConnService connService;

  public ArchivalStorageInitRunner(
      CsdnConfig csdnConfig,
      ConnService connService,
      ArchivalStorageService archivalStorageService) {
    this.csdnConfig = csdnConfig;
    this.connService = connService;
    this.archivalStorageService = archivalStorageService;
  }

  @InfoLog("抓取文章在每月的归档存储数据")
  @Override
  public void run(ApplicationArguments args) throws Exception {

    Document document = connService.conn(csdnConfig.getCsdnUrl());
    Elements elements = document.body().select(".archive-list");
    Elements select = elements.select("ul a");
    select.forEach(
        element -> {
          String href = element.attr("href");
          if (StringUtils.isNotBlank(href)) {
            String datetime = href.substring(href.length() - 7);

            String[] split = datetime.split("/");
            Integer year = Integer.valueOf(split[0]);
            Integer month = Integer.valueOf(split[1]);

            String span = element.select("span").get(0).html();
            if (StringUtils.isNotBlank(span)) {
              String articleNumber = span.substring(0, span.length() - 1);
              create(Integer.valueOf(articleNumber), year, month);
            }
          }
        });
  }

  private void create(Integer articleNumber, Integer year, Integer month) {

    ArchivalStorage archivalStorage = new ArchivalStorage();
    archivalStorage.setArticleNumber(articleNumber);
    archivalStorage.setYear(year);
    archivalStorage.setMonth(month);

    archivalStorageService.create(archivalStorage);
  }
}
