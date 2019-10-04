package com.wretchant.csdnchart.ctrl.business;

import com.google.common.collect.Lists;
import com.wretchant.csdnchart.annotation.InfoLog;
import com.wretchant.csdnchart.entity.ArchivalStorage;
import com.wretchant.csdnchart.service.ArchivalStorageService;
import com.wretchant.csdnchart.service.ArticleInfoService;
import com.wretchant.csdnchart.service.DataTableService;
import com.wretchant.csdnchart.service.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.List;

@RequestMapping("/")
@Controller
public class IndexCtrl {

  private final ArchivalStorageService archivalStorageService;
  private final ArticleInfoService articleInfoService;
  private final DataTableService dataTableService;
  private final UserInfoService userInfoService;

  public IndexCtrl(
      UserInfoService userInfoService,
      ArchivalStorageService archivalStorageService,
      ArticleInfoService articleInfoService,
      DataTableService dataTableService) {
    this.userInfoService = userInfoService;
    this.archivalStorageService = archivalStorageService;
    this.articleInfoService = articleInfoService;
    this.dataTableService = dataTableService;
  }

  @InfoLog("进入首页")
  @GetMapping
  public String index(Model model) {

    model.addAttribute("userInfo", userInfoService.findTop());

    List<ArchivalStorage> list = archivalStorageService.list();
    List<String> dates = Lists.newArrayListWithExpectedSize(list.size());
    List<Integer> datas = Lists.newArrayListWithExpectedSize(list.size());
    list = Lists.reverse(list);
    list.forEach(
        archivalStorage -> {
          datas.add(archivalStorage.getArticleNumber());
          dates.add(archivalStorage.getYear() + "." + archivalStorage.getMonth());
        });

    model.addAttribute("userInfo", userInfoService.findTop());
    model.addAttribute("dates", dates);
    model.addAttribute("datas", datas);
    model.addAttribute("max", Collections.max(datas));
    model.addAttribute("min", Collections.min(datas));

    model.addAttribute("last", dataTableService.last());
    model.addAttribute("count", articleInfoService.count());
    return "index";
  }
}
