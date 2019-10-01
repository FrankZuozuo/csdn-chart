package com.wretchant.csdnchart.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Dream what you want to dream; go where you want to go; be what you want to be; because you have
 * only one life and one chance to do all the things you want to do． - - Online zuozuo / Frank /
 * TANJIAN
 *
 * @author Created by 谭健 on 2019/10/1 星期二 20:59.
 * @link <a href="http://qm.qq.com/cgi-bin/qm/qr?k=FJVK7slBx7qC5tKm_KdFTbwWOFHq1ASt">Join me</a>
 * @link <a href="http://blog.csdn.net/qq_15071263">CSDN Home Page</a>
 *     <p>
 *     <p>© All Rights Reserved.
 */
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

  /** 文章地址 */
  private String url;
  /** 阅读数 */
  private Integer readNumber;
  /** 评论数 */
  private Integer commentNumber;
}
