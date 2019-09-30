package com.wretchant.csdnchart.entity;

import cn.hutool.core.bean.BeanUtil;
import com.wretchant.csdnchart.core.Converter;

import java.time.LocalDateTime;

/**
 * Dream what you want to dream; go where you want to go; be what you want to be; because you have
 * only one life and one chance to do all the things you want to do． - - Online zuozuo / Frank /
 * TANJIAN
 *
 * @author Created by 谭健 on 2019/9/28 星期六 11:55.
 * @link <a href="http://qm.qq.com/cgi-bin/qm/qr?k=FJVK7slBx7qC5tKm_KdFTbwWOFHq1ASt">Join me</a>
 * @link <a href="http://blog.csdn.net/qq_15071263">CSDN Home Page</a>
 *     <p>
 *     <p>© All Rights Reserved.
 */
public class DataTableDto2DataTableConverter implements Converter<DataTableDto, DataTable> {
  @Override
  public DataTable converter(DataTableDto dataTableDto) {
    DataTable dataTable = new DataTable();
    BeanUtil.copyProperties(dataTableDto, dataTable);

    LocalDateTime now = LocalDateTime.now();
    int hour = now.getHour();
    dataTable.setTimePoint(hour);

    return dataTable;
  }
}
