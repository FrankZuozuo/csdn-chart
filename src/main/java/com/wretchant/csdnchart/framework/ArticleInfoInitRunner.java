package com.wretchant.csdnchart.framework;

import com.wretchant.csdnchart.annotation.InfoLog;
import com.wretchant.csdnchart.entity.ArticleInfo;
import com.wretchant.csdnchart.entity.CsdnConfig;
import com.wretchant.csdnchart.service.ArticleInfoService;
import com.wretchant.csdnchart.service.ConnService;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ArticleInfoInitRunner implements ApplicationRunner {

  /** 在不知道作者有多少篇的文章的时候，设定一个最大值，即20000篇文章 */
  private static final int PAGE_MAX = 1000;

  private final ArticleInfoService articleInfoService;
  private final CsdnConfig csdnConfig;
  private final ConnService connService;

  public ArticleInfoInitRunner(
      CsdnConfig csdnConfig, ArticleInfoService articleInfoService, ConnService connService) {
    this.csdnConfig = csdnConfig;
    this.articleInfoService = articleInfoService;
    this.connService = connService;
  }

  @InfoLog("抓取全部的文章数据")
  @Override
  public void run(ApplicationArguments args) throws Exception {

    // 页数从1开始
    for (int i = 1; i < PAGE_MAX; i++) {

      String s = csdnConfig.getCsdnUrl() + CsdnConfig.ARTICLE_LIST + i;
      Document document = connService.conn(s);
      Elements elements = document.body().select(".article-list");
      Elements select = elements.select(".article-item-box");
      if (select.isEmpty()) {
        // 当最后一页结束时，全循环结束
        break;
      }
      select.forEach(
          element -> {
            Elements h4A = element.select("h4 a");
            String url = h4A.attr("href");
            String articleName = h4A.text();

            Elements numbers = element.select(".num");
            String read = numbers.get(0).html();
            String comment = numbers.get(1).html();

            create(articleName, url, Integer.valueOf(read), Integer.valueOf(comment));
          });
    }
  }

  private void create(String articleName, String url, Integer read, Integer comment) {
    ArticleInfo articleInfo = new ArticleInfo();

    articleInfo.setArticleName(articleName);
    articleInfo.setUrl(url);
    articleInfo.setReadNumber(read);
    articleInfo.setCommentNumber(comment);
    articleInfoService.create(articleInfo);
  }
}
