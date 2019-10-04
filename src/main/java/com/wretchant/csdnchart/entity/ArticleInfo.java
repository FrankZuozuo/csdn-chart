package com.wretchant.csdnchart.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@DynamicUpdate
@DynamicInsert
@Table(name = "article_info")
@Entity
@Data
public class ArticleInfo implements Serializable {

  private static final long serialVersionUID = -8837487575308630301L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long pkId;

  private LocalDateTime gmtCreate;
  private LocalDateTime gmtModified;
  private Integer sort;
  private String remark;
  private Boolean deleted;

  /** 文章名称 */
  private String articleName;
  /** 文章地址 */
  private String url;
  /** 阅读数 */
  private Integer readNumber;
  /** 评论数 */
  private Integer commentNumber;
}
