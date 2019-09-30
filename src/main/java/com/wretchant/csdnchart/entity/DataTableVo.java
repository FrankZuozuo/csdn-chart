package com.wretchant.csdnchart.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Dream what you want to dream; go where you want to go; be what you want to be; because you have
 * only one life and one chance to do all the things you want to do． - - Online zuozuo / Frank /
 * TANJIAN
 *
 * @author Created by 谭健 on 2019/9/28 星期六 12:51.
 * @link <a href="http://qm.qq.com/cgi-bin/qm/qr?k=FJVK7slBx7qC5tKm_KdFTbwWOFHq1ASt">Join me</a>
 * @link <a href="http://blog.csdn.net/qq_15071263">CSDN Home Page</a>
 *     <p>
 *     <p>© All Rights Reserved.
 */
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
