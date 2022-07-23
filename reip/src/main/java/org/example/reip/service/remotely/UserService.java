package org.example.reip.service.remotely;

import org.example.reip.model.dto.UserDto;
import org.example.reip.model.vo.request.StringRequestVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author cyan
 * @since 2022/4/16
 */
@FeignClient("gokit-api-usve")
@Async
public interface UserService {
    @PostMapping("/user/query/ids")
    CompletableFuture<List<UserDto>> getUserList(@RequestBody StringRequestVo vo) ;
}
