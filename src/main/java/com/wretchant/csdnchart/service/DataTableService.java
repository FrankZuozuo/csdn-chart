package com.wretchant.csdnchart.service;

import com.wretchant.csdnchart.annotation.InfoLog;
import com.wretchant.csdnchart.entity.DataTable;
import com.wretchant.csdnchart.entity.DataTableDto;

import java.util.List;

/**
 * Dream what you want to dream; go where you want to go; be what you want to be; because you have
 * only one life and one chance to do all the things you want to do． - - Online zuozuo / Frank /
 * TANJIAN
 *
 * @author Created by 谭健 on 2019/9/28 星期六 11:25.
 * @link <a href="http://qm.qq.com/cgi-bin/qm/qr?k=FJVK7slBx7qC5tKm_KdFTbwWOFHq1ASt">Join me</a>
 * @link <a href="http://blog.csdn.net/qq_15071263">CSDN Home Page</a>
 *     <p>
 *     <p>© All Rights Reserved.
 */
public interface DataTableService {

  @InfoLog("爬取数据入库")
  DataTable create(DataTableDto dataTableDto);

  @InfoLog("查询所有的统计数据")
  List<DataTable> list();

  @InfoLog("查询指定数量的统计数据")
  List<DataTable> list(Integer limit);

  @InfoLog("查询指标数据增量")
  List<DataTable> count(Integer limit);
}
