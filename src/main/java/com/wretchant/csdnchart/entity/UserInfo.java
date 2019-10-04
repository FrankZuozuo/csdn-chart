package com.wretchant.csdnchart.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@DynamicUpdate
@DynamicInsert
@Table(name = "user_info")
@Entity
@Data
public class UserInfo implements Serializable {

  private static final long serialVersionUID = 1118676562861971250L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long pkId;

  private LocalDateTime gmtCreate;
  private LocalDateTime gmtModified;
  private Integer sort;
  private String remark;
  private Boolean deleted;

  private String nickname;
  private String headImgUrl;
  private String motto;
  private Long version;
}
