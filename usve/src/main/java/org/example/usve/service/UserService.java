package org.example.usve.service;

import org.example.usve.model.dto.UserDto;
import org.example.usve.model.po.UserPo;
import org.example.usve.model.vo.UserVo;

import java.util.List;

/**
 * @author cyan
 * @since 2022/4/14
 */
public interface UserService {

    UserPo getUserInfo(String token);
    UserPo updateUserInfo(UserVo vo, String token);
    List<UserDto> query(List<String> args);
    List<UserDto> selectFollowInfo(String token);
    List<UserDto> selectFansInfo(String token);
    String userFollowOther(String token, String userId);

}
