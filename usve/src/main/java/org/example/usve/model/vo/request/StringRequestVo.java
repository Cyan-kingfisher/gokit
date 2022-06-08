package org.example.usve.model.vo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * StringRequestVo
 *
 * @author cyan
 * @since 2022/4/15
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
