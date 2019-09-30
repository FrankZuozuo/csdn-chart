package com.wretchant.csdnchart.ctrl.business;

import cn.hutool.core.bean.BeanUtil;
import com.google.common.collect.Lists;
import com.wretchant.csdnchart.annotation.InfoLog;
import com.wretchant.csdnchart.entity.DataTable;
import com.wretchant.csdnchart.entity.DataTableVo;
import com.wretchant.csdnchart.service.DataTableService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Dream what you want to dream; go where you want to go; be what you want to be; because you have
 * only one life and one chance to do all the things you want to do． - - Online zuozuo / Frank /
 * TANJIAN
 *
 * @author Created by 谭健 on 2019/9/28 星期六 10:39.
 * @link <a href="http://qm.qq.com/cgi-bin/qm/qr?k=FJVK7slBx7qC5tKm_KdFTbwWOFHq1ASt">Join me</a>
 * @link <a href="http://blog.csdn.net/qq_15071263">CSDN Home Page</a>
 *     <p>
 *     <p>© All Rights Reserved.
 */
@RequestMapping("/")
@Controller
public class IndexCtrl {

  private final DataTableService dataTableService;

  public IndexCtrl(DataTableService dataTableService) {
    this.dataTableService = dataTableService;
  }

  @InfoLog("进入首页")
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
    return "index";
  }
}
