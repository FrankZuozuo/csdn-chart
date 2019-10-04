package com.wretchant.csdnchart.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties("csdn")
public class CsdnConfig {

  /** csdn 博客主页的链接 */
  private String csdnUrl;

  /** 爬取文章数据时，需要的Restful url 路径 */
  public static final String ARTICLE_LIST = "/article/list/";
}
