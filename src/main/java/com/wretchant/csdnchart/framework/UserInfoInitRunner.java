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
    String headImgUrl = src.replace("3_", "1_");

    create(nickname, motto, headImgUrl);
  }

  private void create(String nickname, String motto, String headImgUrl) {

    UserInfo userInfo = new UserInfo();

    userInfo.setHeadImgUrl(headImgUrl);
    userInfo.setNickname(nickname);
    userInfo.setMotto(motto);

    userInfoService.create(userInfo);
  }
}
