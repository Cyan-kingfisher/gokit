package org.example.reip.model.vo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author cyan
 * @since 2022/4/16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StringRequestVo {

    /**
     * args:list, type:string
     */
    List<String> args;

}
