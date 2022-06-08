package org.example.reip.dao.mapper.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author cyan
 * @since 2022/4/11
 */
public interface BaseTkMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
