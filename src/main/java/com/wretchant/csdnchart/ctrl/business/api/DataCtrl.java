package com.wretchant.csdnchart.ctrl.business.api;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wretchant.csdnchart.annotation.InfoLog;
import com.wretchant.csdnchart.core.R;
import com.wretchant.csdnchart.entity.DataTable;
import com.wretchant.csdnchart.entity.DataTableEnum;
import com.wretchant.csdnchart.service.DataTableService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Dream what you want to dream; go where you want to go; be what you want to be; because you have
 * only one life and one chance to do all the things you want to do． - - Online zuozuo / Frank /
 * TANJIAN
 *
 * @author Created by 谭健 on 2019/9/29 星期日 21:06.
 * @link <a href="http://qm.qq.com/cgi-bin/qm/qr?k=FJVK7slBx7qC5tKm_KdFTbwWOFHq1ASt">Join me</a>
 * @link <a href="http://blog.csdn.net/qq_15071263">CSDN Home Page</a>
 *     <p>
 *     <p>© All Rights Reserved.
 */
@RestController
@RequestMapping("/api/data")
public class DataCtrl {

  private final DataTableService dataTableService;

  public DataCtrl(DataTableService dataTableService) {
    this.dataTableService = dataTableService;
  }

  @InfoLog("前端获取统计数据")
  @GetMapping("/t/{size}")
  public R t(DataTableEnum dataTableEnum, @PathVariable(name = "size") Integer size) {

    List<DataTable> list = dataTableService.list(size);
    Map<String, Object> map = Maps.newHashMapWithExpectedSize(2);
    List<String> datetime = Lists.newArrayListWithExpectedSize(size);
    List<Integer> data = Lists.newArrayListWithExpectedSize(size);

    list.forEach(
        dataTable -> {
          String pattern = "yyyy-MM-dd HH:mm:ss";
          String format = DateTimeFormatter.ofPattern(pattern).format(dataTable.getGmtCreate());
          datetime.add(format);

          switch (dataTableEnum) {
            case TOP:
              data.add(dataTable.getTop());
              break;
            case FANS:
              data.add(dataTable.getFans());
              break;
            case LEVEL:
              data.add(dataTable.getLevel());
              break;
            case INTEGRAL:
              data.add(dataTable.getIntegral());
              break;
            case LIKE_NUMBER:
              data.add(dataTable.getLikeNumber());
              break;
            case VISIT_NUMBER:
              data.add(dataTable.getVisitNumber());
              break;
            case ARTICLE_NUMBER:
              data.add(dataTable.getArticleNumber());
              break;
            case COMMENT_NUMBER:
              data.add(dataTable.getCommentNumber());
              break;
            default:
          }
        });

    Integer max = Collections.max(data);
    Integer min = Collections.min(data);
    map.put("max", max);
    map.put("min", min);
    map.put("datetime", Lists.reverse(datetime));
    map.put("data", Lists.reverse(data));
    return R.success(map);
  }
}
