package com.wretchant.csdnchart.ctrl.business.web;

import com.wretchant.csdnchart.annotation.InfoLog;
import com.wretchant.csdnchart.service.DataTableService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/web/add")
@Controller
public class WebAddCtrl {

  private final DataTableService dataTableService;

  public WebAddCtrl(DataTableService dataTableService) {
    this.dataTableService = dataTableService;
  }

  @InfoLog("查看数据增量")
  @GetMapping("/{size}")
  public String add(Model model, @PathVariable(name = "size") Integer size) {
    model.addAttribute("list", dataTableService.count(size));
    return "add";
  }
}
