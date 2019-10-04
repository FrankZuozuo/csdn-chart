package com.wretchant.csdnchart.service;

import com.wretchant.csdnchart.entity.UserInfo;
import com.wretchant.csdnchart.repo.UserInfoRepo;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

  private final UserInfoRepo userInfoRepo;

  public UserInfoServiceImpl(UserInfoRepo userInfoRepo) {
    this.userInfoRepo = userInfoRepo;
  }

  @Override
  public UserInfo create(UserInfo userInfo) {
    userInfo.setVersion(userInfoRepo.count());
    return userInfoRepo.saveAndFlush(userInfo);
  }

  @Override
  public UserInfo findTop() {
    return userInfoRepo.findTop();
  }
}
