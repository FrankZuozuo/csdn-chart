package com.wretchant.csdnchart.service;

import com.wretchant.csdnchart.annotation.InfoLog;
import com.wretchant.csdnchart.entity.UserInfo;

public interface UserInfoService {

  @InfoLog("创建用户信息")
  UserInfo create(UserInfo userInfo);

  @InfoLog("查询最新的用户信息")
  UserInfo findTop();
}
