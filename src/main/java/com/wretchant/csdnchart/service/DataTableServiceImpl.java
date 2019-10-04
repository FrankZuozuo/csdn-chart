package com.wretchant.csdnchart.service;

import com.wretchant.csdnchart.core.Converter;
import com.wretchant.csdnchart.entity.DataTable;
import com.wretchant.csdnchart.entity.DataTableDto;
import com.wretchant.csdnchart.entity.DataTableDto2DataTableConverter;
import com.wretchant.csdnchart.repo.DataTableRepo;
import org.springframework.stereotype.Service;

import java.util.List;

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

  @Override
  public DataTable last() {
    return dataTableRepo.list(1).get(0);
  }
}
