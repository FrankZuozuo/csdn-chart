package com.wretchant.csdnchart.core;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Dream what you want to dream; go where you want to go; be what you want to be; because you have
 * only one life and one chance to do all the things you want to do． - - Online zuozuo / Frank /
 * TANJIAN
 *
 * @author Created by 谭健 on 2019/9/29 星期日 21:09.
 * @link <a href="http://qm.qq.com/cgi-bin/qm/qr?k=FJVK7slBx7qC5tKm_KdFTbwWOFHq1ASt">Join me</a>
 * @link <a href="http://blog.csdn.net/qq_15071263">CSDN Home Page</a>
 *     <p>
 *     <p>© All Rights Reserved.
 */
@AllArgsConstructor
@Data
public class R<T> {

  private T t;
  private String msg;
  private int code;

  public static <T> R<T> success(T t) {
    return new R<T>(t, "success", 200);
  }

  public static R<String> success() {
    return new R<String>("", "success", 200);
  }

  public static R<String> fail() {
    return new R<String>("", "fail", 500);
  }

  public static R<String> fail(String msg) {
    return new R<String>("", msg, 500);
  }
}
