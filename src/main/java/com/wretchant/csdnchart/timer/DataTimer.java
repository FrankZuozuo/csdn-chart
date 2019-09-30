package com.wretchant.csdnchart.timer;

import com.wretchant.csdnchart.annotation.InfoLog;
import com.wretchant.csdnchart.entity.CsdnConfig;
import com.wretchant.csdnchart.entity.DataTableDto;
import com.wretchant.csdnchart.service.ConnService;
import com.wretchant.csdnchart.service.DataTableService;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DataTimer {

  private final CsdnConfig csdnConfig;
  private final ConnService connService;
  private final DataTableService dataTableService;

  public DataTimer(
      ConnService connService, CsdnConfig csdnConfig, DataTableService dataTableService) {
    this.connService = connService;
    this.csdnConfig = csdnConfig;
    this.dataTableService = dataTableService;
  }

  @InfoLog("开始爬取数据")
  @Async
  @Scheduled(fixedRate = 1000 * 60 * 5)
  public void execute() throws Exception {
    Document document = connService.conn(csdnConfig.getCsdnUrl());
    Element asideProfile = document.body().getElementById("asideProfile");
    Elements gradeBox = asideProfile.select(".grade-box");
    Elements info = asideProfile.select(".item-tiling");

    Elements gradeColumn = gradeBox.select("dl");
    String level = gradeColumn.get(0).select("dd a").attr("title").substring(0, 1);
    String visitNumber = gradeColumn.get(1).select("dd").attr("title");
    String integral = gradeColumn.get(2).select("dd").attr("title");
    String top = gradeColumn.get(3).attr("title");

    Elements infoColumn = info.select("dl");
    String htmlValue = infoColumn.select("dd span").html();
    String[] values = htmlValue.split("\n");
    String articleNumber = values[0];
    String fans = values[1];
    String likeNumber = values[2];
    String commentNumber = values[3];

    DataTableDto dto = new DataTableDto();
    dto.setLevel(Integer.valueOf(level));
    dto.setVisitNumber(Integer.valueOf(visitNumber));
    dto.setIntegral(Integer.valueOf(integral));
    dto.setTop(Integer.valueOf(top));
    dto.setArticleNumber(Integer.valueOf(articleNumber));
    dto.setFans(Integer.valueOf(fans));
    dto.setLikeNumber(Integer.valueOf(likeNumber));
    dto.setCommentNumber(Integer.valueOf(commentNumber));
    dataTableService.create(dto);
  }
}
