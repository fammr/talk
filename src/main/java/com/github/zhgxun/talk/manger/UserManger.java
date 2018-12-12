package com.github.zhgxun.talk.manger;

import com.github.zhgxun.talk.common.enums.UserType;
import com.github.zhgxun.talk.entity.UserEntity;

import java.util.List;

public interface UserManger {

    String accessUrl(UserType type);

    UserEntity code(UserType type, String code);

    UserEntity findOne(int id);

    List<UserEntity> findAny(int id, String nickName, UserType type);

    int delete(int id);
}
