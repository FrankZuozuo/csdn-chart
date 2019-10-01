package com.wretchant.csdnchart.service;

import com.wretchant.csdnchart.core.Converter;
import com.wretchant.csdnchart.entity.DataTable;
import com.wretchant.csdnchart.entity.DataTableDto;
import com.wretchant.csdnchart.entity.DataTableDto2DataTableConverter;
import com.wretchant.csdnchart.repo.DataTableRepo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Dream what you want to dream; go where you want to go; be what you want to be; because you have
 * only one life and one chance to do all the things you want to do． - - Online zuozuo / Frank /
 * TANJIAN
 *
 * @author Created by 谭健 on 2019/9/28 星期六 11:23.
 * @link <a href="http://qm.qq.com/cgi-bin/qm/qr?k=FJVK7slBx7qC5tKm_KdFTbwWOFHq1ASt">Join me</a>
 * @link <a href="http://blog.csdn.net/qq_15071263">CSDN Home Page</a>
 *     <p>
 *     <p>© All Rights Reserved.
 */
@Service
public class DataTableServiceImpl implements DataTableService {

  private final DataTableRepo dataTableRepo;

  public DataTableServiceImpl(DataTableRepo dataTableRepo) {
    this.dataTableRepo = dataTableRepo;
  }

  @Override
  public DataTable create(DataTableDto dataTableDto) {
    Converter<DataTableDto, DataTable> converter = new DataTableDto2DataTableConverter();
    return dataTableRepo.saveAndFlush(converter.converter(dataTableDto));
  }

  @Override
  public List<DataTable> list() {
    return dataTableRepo.findAll();
  }

  @Override
  public List<DataTable> list(Integer limit) {
    return dataTableRepo.list(limit);
  }

  @Override
  public List<DataTable> count(Integer limit) {
    return dataTableRepo.count(limit);
  }
}
