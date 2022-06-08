package org.example.usve.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

/**
 * @author cyan
 * @since 2022/4/15
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "usve_user")
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
