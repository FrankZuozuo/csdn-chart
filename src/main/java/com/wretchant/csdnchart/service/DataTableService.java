package com.wretchant.csdnchart.service;

import com.wretchant.csdnchart.annotation.InfoLog;
import com.wretchant.csdnchart.entity.DataTable;
import com.wretchant.csdnchart.entity.DataTableDto;

import java.util.List;

public interface DataTableService {

  @InfoLog("爬取数据入库")
  DataTable create(DataTableDto dataTableDto);

  @InfoLog("查询所有的统计数据")
  List<DataTable> list();

  @InfoLog("查询指定数量的统计数据")
  List<DataTable> list(Integer limit);

  @InfoLog("查询指标数据增量")
  List<DataTable> count(Integer limit);

  @InfoLog("查询最近的一条数据")
  DataTable last();
}
