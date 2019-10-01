package com.wretchant.csdnchart.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Dream what you want to dream; go where you want to go; be what you want to be; because you have
 * only one life and one chance to do all the things you want to do． - - Online zuozuo / Frank /
 * TANJIAN
 *
 * @author Created by 谭健 on 2019/9/28 星期六 10:51.
 * @link <a href="http://qm.qq.com/cgi-bin/qm/qr?k=FJVK7slBx7qC5tKm_KdFTbwWOFHq1ASt">Join me</a>
 * @link <a href="http://blog.csdn.net/qq_15071263">CSDN Home Page</a>
 *     <p>
 *     <p>© All Rights Reserved.
 */
@Configuration
@Data
@ConfigurationProperties("csdn")
public class CsdnConfig {

  /** csdn 博客主页的链接 */
  private String csdnUrl;

  /** 爬取文章数据时，需要的Restful url 路径 */
  public static final String ARTICLE_LIST = "/article/list/";
}
