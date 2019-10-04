package com.wretchant.csdnchart.entity;

import lombok.Data;

@Data
public class DataTableDto {
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
}
