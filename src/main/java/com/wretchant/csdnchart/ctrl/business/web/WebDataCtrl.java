package com.wretchant.csdnchart.ctrl.business.web;

import cn.hutool.core.bean.BeanUtil;
import com.google.common.collect.Lists;
import com.wretchant.csdnchart.annotation.InfoLog;
import com.wretchant.csdnchart.entity.DataTable;
import com.wretchant.csdnchart.entity.DataTableVo;
import com.wretchant.csdnchart.service.DataTableService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/web/data")
@Slf4j
@RestController
public class WebDataCtrl {

  private final DataTableService dataTableService;

  public WebDataCtrl(DataTableService dataTableService) {
    this.dataTableService = dataTableService;
  }

  @InfoLog("前端查看全部的统计数据")
  @GetMapping
  public String index(Model model) {

    List<DataTableVo> vos = Lists.newArrayList();
    List<DataTable> list = dataTableService.list();

    for (int i = 0; i < list.size(); i++) {
      DataTable dataTable = list.get(i);
      DataTableVo dataTableVo = new DataTableVo();

      BeanUtil.copyProperties(dataTable, dataTableVo);
      if (i != 0) {
        DataTable old = list.get(i - 1);
        dataTableVo.setLevelAdd(dataTable.getLevel() - old.getLevel());
        dataTableVo.setVisitNumberAdd(dataTable.getVisitNumber() - old.getVisitNumber());
        dataTableVo.setIntegralAdd(dataTable.getIntegral() - old.getIntegral());
        dataTableVo.setTopAdd(dataTable.getTop() - old.getTop());

        dataTableVo.setArticleNumberAdd(dataTable.getArticleNumber() - old.getArticleNumber());
        dataTableVo.setFansAdd(dataTable.getFans() - old.getFans());
        dataTableVo.setLikeNumberAdd(dataTable.getLikeNumber() - old.getLikeNumber());
        dataTableVo.setCommentNumberAdd(dataTable.getCommentNumber() - old.getCommentNumber());
      }

      vos.add(dataTableVo);
    }

    model.addAttribute("list", vos);
    return "data";
  }
}
