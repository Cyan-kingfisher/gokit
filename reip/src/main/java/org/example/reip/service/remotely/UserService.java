package org.example.reip.service.remotely;

import org.example.reip.model.dto.UserDto;
import org.example.reip.model.vo.request.StringRequestVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author cyan
 * @since 2022/4/16
 */
@FeignClient("gokit-api-usve")
public interface UserService {
    @PostMapping("/user/query/ids")
    List<UserDto> getUserList(@RequestBody StringRequestVo vo) ;
}
