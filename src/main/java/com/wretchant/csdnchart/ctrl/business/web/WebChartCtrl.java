package com.wretchant.csdnchart.ctrl.business.web;

import com.wretchant.csdnchart.annotation.InfoLog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/web/chart")
@Controller
public class WebChartCtrl {

  @GetMapping("/{size}")
  @InfoLog("进入报表页面")
  public String chart(Model model, @PathVariable(name = "size") Integer size) {
    model.addAttribute("size", size);
    return "chart";
  }
}
