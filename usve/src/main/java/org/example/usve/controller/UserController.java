package org.example.usve.controller;

import org.example.usve.constant.error.HttpCodeEnum;
import org.example.usve.model.dto.UserDto;
import org.example.usve.model.po.UserPo;
import org.example.usve.model.res.Result;
import org.example.usve.model.vo.UserVo;
import org.example.usve.model.vo.request.StringRequestVo;
import org.example.usve.service.UserService;
import org.example.usve.util.AssertUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * usve 用户
 *
 * @author cyan
 * @since 2022/3/23
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户基本信息
     *
     * @param vo
     * @return
     */
    @PostMapping("/query/ids")
    public List<UserDto> getUserList(@RequestBody StringRequestVo vo) {
        return userService.query(vo.getArgs());
    }

    /**
     * 修改用户信息
     *
     * @param vo vo
     * @param token token
     * @return Result<UserPo>
     */
    @PostMapping("/simple")
    public Result<UserPo> rprUser(@RequestBody UserVo vo, @RequestHeader("Authorization") String token) {
        UserPo po = userService.updateUserInfo(vo, getToken(token));
        return Result.success(po);
    }

    /**
     * 查询用户信息
     *
     * @param token token
     * @return Result<UserPo>
     */
    @GetMapping("/simple")
    public Result<UserPo> getUserInfo(@RequestHeader("Authorization") String token) {
        UserPo po = userService.getUserInfo(getToken(token));
        return Result.success(po);
    }

    /**
     * 查看关注用户信息
     *
     * @param token token
     * @return Result<List<UserDto>>
     */
    @GetMapping("/follow")
    public Result<List<UserDto>> getFollowUserInfo(@RequestHeader("Authorization") String token) {
        List<UserDto> result = userService.selectFollowInfo(getToken(token));
        return Result.success(result);
    }

    /**
     * 查看粉丝用户信息
     *
     * @param token token
     * @return Result<List<UserDto>>
     */
    @GetMapping("/fans")
    public Result<List<UserDto>> getFansUserInfo(@RequestHeader("Authorization") String token) {
        List<UserDto> result = userService.selectFansInfo(getToken(token));
        return Result.success(result);
    }

    /**
     * 关注其他用户
     *
     * @param token token
     * @param userId 用户+86手机号
     * @return Result<Object>
     */
    @PostMapping("/follow/act")
    public Result<Object> userFollowOther(@RequestHeader("Authorization") String token, String userId) {
        return Result.builder().code("00000").msg(userService.userFollowOther(getToken(token), userId)).build();
    }



    @Autowired
    RedisTemplate<String, String> redisTemplate;

    /**
     * redis测试
     *
     * @param key key
     * @param value value
     * @return Result<Object>
     */
    @GetMapping("/redis/test")
    public Result<Object> testR(String key, String value) {

        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        opsForValue.set("HELLO", "WORld", 10000, TimeUnit.SECONDS);
        opsForValue.set("i", " live you", 10000, TimeUnit.SECONDS);
        Map<String, Object> map = new HashMap<>();
        map.put(opsForValue.get("HELLO"), opsForValue.get("i"));
        return Result.success(map);
    }

    private String getToken(String token) {
        AssertUtil.isTure(token.length()>6&&token.contains("Bearer"), HttpCodeEnum.PREFIX_TOKEN);
        return token.substring(6).trim();
    }

}
