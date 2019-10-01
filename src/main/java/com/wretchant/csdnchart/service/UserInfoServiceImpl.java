package com.wretchant.csdnchart.service;

import com.wretchant.csdnchart.entity.UserInfo;
import com.wretchant.csdnchart.repo.UserInfoRepo;
import org.springframework.stereotype.Service;

/**
 * Dream what you want to dream; go where you want to go; be what you want to be; because you have
 * only one life and one chance to do all the things you want to do． - - Online zuozuo / Frank /
 * TANJIAN
 *
 * @author Created by 谭健 on 2019/10/1 星期二 21:37.
 * @link <a href="http://qm.qq.com/cgi-bin/qm/qr?k=FJVK7slBx7qC5tKm_KdFTbwWOFHq1ASt">Join me</a>
 * @link <a href="http://blog.csdn.net/qq_15071263">CSDN Home Page</a>
 *     <p>
 *     <p>© All Rights Reserved.
 */
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
}
