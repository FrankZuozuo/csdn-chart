package com.wretchant.csdnchart.entity;

import lombok.Getter;

@Getter
public enum DataTableViewEnum {
  LEVEL("level"),
  VISIT_NUMBER("visitNumber"),
  INTEGRAL("integral"),
  TOP("top"),
  ARTICLE_NUMBER("articleNumber"),
  FANS("fans"),
  LIKE_NUMBER("likeNumber"),
  COMMENT_NUMBER("commentNumber");

  private String field;

  DataTableViewEnum(String field) {
    this.field = field;
  }
}
