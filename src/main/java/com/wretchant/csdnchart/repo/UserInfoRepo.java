package com.wretchant.csdnchart.repo;

import com.wretchant.csdnchart.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserInfoRepo extends JpaRepository<UserInfo, Long> {

  @Query(nativeQuery = true, value = "select * from user_info u order by u.version desc limit 1")
  UserInfo findTop();
}
