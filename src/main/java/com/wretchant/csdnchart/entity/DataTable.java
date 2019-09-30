package com.wretchant.csdnchart.entity;

import com.google.common.collect.Lists;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;

@DynamicUpdate
@DynamicInsert
@Table(name = "data")
@Entity
@Data
public class DataTable implements Serializable {

  private static final long serialVersionUID = -2669109119732793870L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long pkId;

  private LocalDateTime gmtCreate;
  private LocalDateTime gmtModified;
  private Integer sort;
  private String remark;
  private Boolean deleted;

  /** 时间点 */
  private Integer timePoint;

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

  public static void main(String[] args) {
    Field[] fields = DataTableViewEnum.class.getDeclaredFields();
    List<Field> fs = Lists.newArrayList(fields);
    fs.stream()
        .filter(field -> !"$VALUES".equals(field.getName()) && !"field".equals(field.getName()))
        .forEach(
            field -> {
              try {
                DataTableViewEnum dataTableViewEnum =
                    (DataTableViewEnum) field.get(field.getName());
                System.out.println(dataTableViewEnum.getField());
              } catch (IllegalAccessException e) {
                e.printStackTrace();
              }
              System.out.println(field.getName());
            });
  }
}
