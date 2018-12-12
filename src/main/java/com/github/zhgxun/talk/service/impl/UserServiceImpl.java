package com.github.zhgxun.talk.service.impl;

import com.github.zhgxun.talk.common.enums.UserType;
import com.github.zhgxun.talk.common.exception.UserException;
import com.github.zhgxun.talk.common.processor.impl.WeiboLoginProcessor;
import com.github.zhgxun.talk.config.Constant;
import com.github.zhgxun.talk.dao.OauthDao;
import com.github.zhgxun.talk.dao.UserDao;
import com.github.zhgxun.talk.entity.OauthEntity;
import com.github.zhgxun.talk.entity.UserEntity;
import com.github.zhgxun.talk.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private WeiboLoginProcessor weiboLoginProcessor;

    @Autowired
    private UserDao userDao;

    @Autowired
    private OauthDao oauthDao;

    @Override
    public String accessUrl(UserType type) {
        switch (type) {
            case WEIBO:
                log.info("weibo");
                return weiboLoginProcessor.accessUrl(Constant.AUTH_CODE);
            case WEIXIN:
                log.info("weixin");
                return "weixin";
            case QQ:
                log.info("qq");
                return "qq";
        }
        return null;
    }

    @Override
    public String code(UserType type, String code) {
        switch (type) {
            case WEIBO:
                return weiboLoginProcessor.getCode(code);
            case WEIXIN:
                return "";
            case QQ:
                return "";
        }
        return null;
    }

    @Override
    public int add(UserEntity entity) {
        if (findAny(0, entity.getNickName(), entity.getType().getValue()).size() > 0) {
            throw new UserException("用户已经存在, 请直接登录");
        }

        userDao.add(entity);
        int userId = entity.getId();
        OauthEntity oauth = new OauthEntity();
        oauth.setUserId(userId);
        switch (entity.getType()) {
            case QQ:
                oauth.setOauthName("腾讯QQ互联");
                break;
            case WEIBO:
                oauth.setOauthName("新浪微博");
                break;
            case WEIXIN:
                oauth.setOauthName("腾讯微信");
                break;
            default:
                oauth.setOauthName("未知平台");
        }
        oauth.setOauthId("id");
        oauth.setOauthAccessToken("token");
        oauth.setOauthExpires(3600);
        oauthDao.add(oauth);
        return userId;
    }

    @Override
    public UserEntity findOne(int id) {
        return userDao.findOne(id);
    }

    @Override
    public List<UserEntity> findAny(int id, String nickName, int type) {
        return userDao.findAny(id, nickName, type);
    }

    @Override
    public int delete(int id) {
        UserEntity entity = userDao.findOne(id);
        if (entity == null) {
            throw new UserException("用户不存在");
        }
        int userId = entity.getId();
        int rs = userDao.delete(id);
        oauthDao.delete(userId);

        return rs;
    }
}
