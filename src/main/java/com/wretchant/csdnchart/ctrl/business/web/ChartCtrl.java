package com.wretchant.csdnchart.ctrl.business.web;

import com.wretchant.csdnchart.annotation.InfoLog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Dream what you want to dream; go where you want to go; be what you want to be; because you have
 * only one life and one chance to do all the things you want to do． - - Online zuozuo / Frank /
 * TANJIAN
 *
 * @author Created by 谭健 on 2019/9/29 星期日 20:42.
 * @link <a href="http://qm.qq.com/cgi-bin/qm/qr?k=FJVK7slBx7qC5tKm_KdFTbwWOFHq1ASt">Join me</a>
 * @link <a href="http://blog.csdn.net/qq_15071263">CSDN Home Page</a>
 *     <p>
 *     <p>© All Rights Reserved.
 */
@RequestMapping("/web/chart")
@Controller
public class ChartCtrl {

  @GetMapping("/{size}")
  @InfoLog("进入报表页面")
  public String chart(Model model, @PathVariable(name = "size") Integer size) {
    model.addAttribute("size", size);
    return "chart";
  }
}
