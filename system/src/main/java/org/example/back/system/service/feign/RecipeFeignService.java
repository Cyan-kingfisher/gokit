package org.example.back.system.service.feign;

import org.example.back.system.model.feign.RecipeReqAudit;
import org.example.back.system.model.feign.StringRequestVo;
import org.example.back.system.model.feign.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author cyan
 * @since 2022/5/28
 */
@FeignClient("gokit-api-reip")
public interface RecipeFeignService {

    @PostMapping("/recipe/audit")
    RecipeReqAudit audit(@RequestBody RecipeReqAudit vo);



}
