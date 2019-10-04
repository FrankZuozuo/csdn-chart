package com.wretchant.csdnchart.entity;

import cn.hutool.core.bean.BeanUtil;
import com.wretchant.csdnchart.core.Converter;

import java.time.LocalDateTime;

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
