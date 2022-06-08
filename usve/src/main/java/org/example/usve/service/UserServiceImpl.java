package org.example.usve.service;

import lombok.extern.slf4j.Slf4j;
import org.example.usve.annotation.SelectDataSource;
import org.example.usve.config.DataSourceType;
import org.example.usve.constant.error.HttpCodeEnum;
import org.example.usve.dao.mapper.FollowPoMapper;
import org.example.usve.dao.mapper.UserPoMapper;
import org.example.usve.exception.GraduException;
import org.example.usve.model.dto.UserDto;
import org.example.usve.model.po.FollowPo;
import org.example.usve.model.po.UserPo;
import org.example.usve.model.vo.UserVo;
import org.example.usve.util.AssertUtil;
import org.example.usve.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author cyan
 * @since 2022/4/14
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserPoMapper userMapper;

    @Autowired
    private FollowPoMapper followPoMapper;

    @Autowired
    private AddressService addressService;

    private static final String followSuccess = "关注成功";

    private static final String followCancel = "取消关注";

    @Override
    @SelectDataSource
    public UserPo getUserInfo(String token) {
        String userId = JwtUtil.getCurrentUser(token);
        AssertUtil.isTure(userId != null && userId.length() > 10, HttpCodeEnum.PHONE_VALIDATOR);
        UserPo userPo = userMapper.selectByPrimaryKey(userId);
        if (userPo != null) {
            userPo.setUserFollow(followPoMapper.selectFollowBack(userId, null));
            userPo.setUserFans(followPoMapper.selectFollowBack(null, userId));
            return userPo;
        } else {
            userPo = UserPo.builder().userPhone(userId).build();
            userMapper.insertSelective(userPo);
            UserPo res = userMapper.selectByPrimaryKey(userId);
            log.info("用户插入：{}", res);
            res.setUserFollow(0);
            res.setUserFans(0);
            addressService.resetDefaultReceiveAddress(userId, null);
            return res;
        }
    }

    @Override
    public UserPo updateUserInfo(UserVo vo, String token) {
        String phone = JwtUtil.getCurrentUser(token);
        AssertUtil.isTure(phone != null && phone.length() > 10, HttpCodeEnum.PHONE_VALIDATOR);
        if (vo.isEmpty()) {
            return null;
        }
        UserPo userPo = userMapper.selectByPrimaryKey(phone);
        if (userPo == null) {
            userPo = UserPo.builder().userPhone(phone).build();
            userMapper.insertSelective(userPo);
            addressService.resetDefaultReceiveAddress(phone, null);
            log.info("用户插入：{}", userPo);
        } else {
            vo.setPhone(phone);
            userMapper.updateOne(vo);
            log.info("用户修改：{}", vo);
        }
        return userMapper.selectByPrimaryKey(phone);
    }

    @Override
    @SelectDataSource(DataSourceType.Type.SLAVE)
    public List<UserDto> query(List<String> args) {
        if (CollectionUtils.isEmpty(args))
            return null;
        else
            return userMapper.selectAllByIds(args);
    }

    @Override
    public List<UserDto> selectFollowInfo(String token) {
        String phone = JwtUtil.getCurrentUser(token);
        return userMapper.selectFollowUserInfo(phone);
    }

    @Override
    public List<UserDto> selectFansInfo(String token) {
        String phone = JwtUtil.getCurrentUser(token);
        return userMapper.selectFansUserInfo(phone);
    }

    @Override
    @SelectDataSource
    public String userFollowOther(String token, String userId) {
        String phone = JwtUtil.getCurrentUser(token);
        AssertUtil.isTure(!StringUtils.isEmpty(userId), HttpCodeEnum.PARAM_NULL);
        userId = userId.replaceAll(" ", "+");
        boolean FollowUserStatus = userMapper.existsWithPrimaryKey(userId);
        if (!FollowUserStatus) {
            throw new GraduException("20721|"+userId+"用户数据为空");
        }
        FollowPo followPo = FollowPo.builder().followForward(phone).followBack(userId).build();
        FollowPo result = followPoMapper.selectOne(followPo);
        if (result == null) {
            followPoMapper.insertSelective(followPo);
            return followSuccess;
        } else {
            followPoMapper.delete(followPo);
            return followCancel;
        }
    }
}
