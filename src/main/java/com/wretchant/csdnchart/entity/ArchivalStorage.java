package com.wretchant.csdnchart.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@DynamicUpdate
@DynamicInsert
@Table(name = "archival_storage")
@Entity
@Data
public class ArchivalStorage implements Serializable {

  private static final long serialVersionUID = -5445657205714414658L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long pkId;

  private LocalDateTime gmtCreate;
  private LocalDateTime gmtModified;
  private Integer sort;
  private String remark;
  private Boolean deleted;

  /** 文章数量 */
  private Integer articleNumber;

  private Integer year;
  private Integer month;
}
