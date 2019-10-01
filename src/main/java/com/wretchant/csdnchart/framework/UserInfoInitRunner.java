package com.wretchant.csdnchart.framework;

import com.wretchant.csdnchart.annotation.InfoLog;
import com.wretchant.csdnchart.entity.CsdnConfig;
import com.wretchant.csdnchart.entity.UserInfo;
import com.wretchant.csdnchart.service.ConnService;
import com.wretchant.csdnchart.service.UserInfoService;
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
 * @author Created by 谭健 on 2019/10/1 星期二 21:40.
 * @link <a href="http://qm.qq.com/cgi-bin/qm/qr?k=FJVK7slBx7qC5tKm_KdFTbwWOFHq1ASt">Join me</a>
 * @link <a href="http://blog.csdn.net/qq_15071263">CSDN Home Page</a>
 *     <p>
 *     <p>© All Rights Reserved.
 */
@Component
public class UserInfoInitRunner implements ApplicationRunner {

  private final CsdnConfig csdnConfig;
  private final UserInfoService userInfoService;
  private final ConnService connService;

  public UserInfoInitRunner(
      CsdnConfig csdnConfig, UserInfoService userInfoService, ConnService connService) {
    this.csdnConfig = csdnConfig;
    this.userInfoService = userInfoService;
    this.connService = connService;
  }

  @InfoLog("抓取用户的个人信息")
  @Override
  public void run(ApplicationArguments args) throws Exception {

    Document document = connService.conn(csdnConfig.getCsdnUrl());
    Elements elements = document.body().select(".title-box");
    String nickname = elements.select("a").get(0).html();
    String motto = elements.select("p").get(0).html();

    Elements select = document.body().select(".avatar_pic");
    String src = select.get(0).attr("src");

    // 因为这里抓的头像图片太小 - 只有三分之一大小，不好看，我们把它变成大的
    String headImgUrl = src.replace("1_", "3_");

    create(nickname, motto, src);
  }

  private void create(String nickname, String motto, String headImgUrl) {

    UserInfo userInfo = new UserInfo();

    userInfo.setHeadImgUrl(headImgUrl);
    userInfo.setNickname(nickname);
    userInfo.setMotto(motto);

    userInfoService.create(userInfo);
  }
}
