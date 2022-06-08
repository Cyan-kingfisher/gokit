package org.example.back.system.service.feign;

import org.example.back.system.model.feign.ManUser;
import org.example.back.system.model.feign.StringRequestVo;
import org.example.back.system.model.feign.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("gokit-api-usve")
public interface UserFeignService {

    @PostMapping("/user/judge")
    boolean judgeUser(@RequestBody ManUser vo) ;

    @PostMapping("/user/query/ids")
    List<UserDto> getUserList(@RequestBody StringRequestVo vo) ;

}