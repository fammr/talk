package com.github.zhgxun.talk.service;

import com.github.zhgxun.talk.common.enums.UserType;
import com.github.zhgxun.talk.entity.UserEntity;

import java.util.List;

public interface UserService {

    String accessUrl(UserType type);

    String code(UserType type, String code);

    int add(UserEntity entity);

    UserEntity findOne(int id);

    List<UserEntity> findAny(int id, String nickName, int type);

    int delete(int id);
}
