package com.wretchant.csdnchart.ctrl.business.web;

import com.wretchant.csdnchart.annotation.InfoLog;
import com.wretchant.csdnchart.entity.ConduitEnum;
import com.wretchant.csdnchart.service.ArticleInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/web/conduit")
@Controller
public class WebConduitCtrl {

  private final ArticleInfoService articleInfoService;

  public WebConduitCtrl(ArticleInfoService articleInfoService) {
    this.articleInfoService = articleInfoService;
  }

  @InfoLog("查看Conduit 文章列表")
  @GetMapping("/{conduit}")
  public String add(Model model, @PathVariable(name = "conduit") ConduitEnum conduit) {
    model.addAttribute("list", articleInfoService.list(conduit));
    return "article";
  }
}
