package com.wretchant.csdnchart.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DataTableVo {

  private LocalDateTime gmtCreate;

  /** 等级 */
  private Integer level;
  /** 访问量 */
  private Integer visitNumber;
  /** 积分 */
  private Integer integral;
  /** 排名 */
  private Integer top;
  /** 原创文章数量 */
  private Integer articleNumber;
  /** 粉丝数量 */
  private Integer fans;
  /** 喜欢数量 */
  private Integer likeNumber;
  /** 评论数量 */
  private Integer commentNumber;

  // ---- 增量
  /** 等级 */
  private Integer levelAdd = 0;
  /** 访问量 */
  private Integer visitNumberAdd = 0;
  /** 积分 */
  private Integer integralAdd = 0;
  /** 排名 */
  private Integer topAdd = 0;
  /** 原创文章数量 */
  private Integer articleNumberAdd = 0;
  /** 粉丝数量 */
  private Integer fansAdd = 0;
  /** 喜欢数量 */
  private Integer likeNumberAdd = 0;
  /** 评论数量 */
  private Integer commentNumberAdd = 0;
}
