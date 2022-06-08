package org.example.reip.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cyan
 * @since 2022/4/11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    /**
     * 用户头像
     */
    private String userAvatar;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户id
     */
    private String userPhone;
}
