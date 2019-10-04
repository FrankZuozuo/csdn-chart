package com.wretchant.csdnchart.ctrl.business.web;

import com.wretchant.csdnchart.annotation.InfoLog;
import com.wretchant.csdnchart.service.ArticleInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/web/article")
@Controller
public class WebArticleCtrl {

  private final ArticleInfoService articleInfoService;

  public WebArticleCtrl(ArticleInfoService articleInfoService) {
    this.articleInfoService = articleInfoService;
  }

  @GetMapping
  @InfoLog("进入报表页面")
  public String chart(Model model) {
    model.addAttribute("list", articleInfoService.list());
    return "article";
  }
}
