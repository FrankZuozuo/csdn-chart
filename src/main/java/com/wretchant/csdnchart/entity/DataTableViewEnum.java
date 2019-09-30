package com.wretchant.csdnchart.entity;

import lombok.Getter;

/**
 * Dream what you want to dream;
 * go where you want to go;
 * be what you want to be;
 * because you have only one life and one chance to do all the things you want to do．
 * - - Online zuozuo / Frank / TANJIAN
 *
 * @author Created by 谭健 on 2019/9/29 星期日 22:31.
 * @link <a href="http://qm.qq.com/cgi-bin/qm/qr?k=FJVK7slBx7qC5tKm_KdFTbwWOFHq1ASt">Join me</a>
 * @link <a href="http://blog.csdn.net/qq_15071263">CSDN Home Page</a>
 * <p>
 * <p>
 * © All Rights Reserved.
 */

@Getter
public enum  DataTableViewEnum {

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
