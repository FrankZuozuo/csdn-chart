package com.wretchant.csdnchart.repo;

import com.wretchant.csdnchart.entity.DataTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DataTableRepo extends JpaRepository<DataTable, Long> {

  @Query(nativeQuery = true, value = "select * from data d order by d.gmt_create desc limit ?1")
  List<DataTable> list(Integer limit);

  @Query(
      nativeQuery = true,
      value =
          "SELECT ANY_VALUE(DATE_FORMAT(d.gmt_create,'%Y-%m-%d')) AS `gmt_create`,\n"
              + "ANY_VALUE(d.pk_id) AS `pk_id`,\n"
              + "ANY_VALUE(d.deleted) AS `deleted`,\n"
              + "ANY_VALUE(d.gmt_modified) AS `gmt_modified`,\n"
              + "ANY_VALUE(d.remark) AS `remark`,\n"
              + "ANY_VALUE(d.sort) AS `sort`,\n"
              + "d.time_point,\n"
              + "ANY_VALUE((MAX(d.visit_number) - MIN(d.visit_number))) AS `visit_number`,\n"
              + "ANY_VALUE((MAX(d.level) - MIN(d.level))) AS `level`,\n"
              + "ANY_VALUE((MAX(d.integral) - MIN(d.integral))) AS `integral`,\n"
              + "ANY_VALUE((MAX(d.top) - MIN(d.top))) AS `top`,\n"
              + "ANY_VALUE((MAX(d.article_number) - MIN(d.article_number))) AS `article_number`,\n"
              + "ANY_VALUE((MAX(d.fans) - MIN(d.fans))) AS `fans`,\n"
              + "ANY_VALUE((MAX(d.like_number) - MIN(d.like_number))) AS `like_number`,\n"
              + "ANY_VALUE((MAX(d.comment_number) - MIN(d.comment_number))) AS `comment_number`\n"
              + "FROM `data` d\n"
              + "GROUP BY d.time_point\n"
              + "ORDER BY gmt_create DESC, d.time_point DESC\n"
              + "LIMIT ?1")
  List<DataTable> count(Integer limit);
}
