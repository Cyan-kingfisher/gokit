package org.example.usve.util;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;

/**
 * @author cyan
 * @since 2022/4/25
 */
public class SnowIdUtil {

    private static long workerId = 0L;
    private static long datacenterId = 1L;
    private static Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);

    static {
        try {
            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
        } catch (
                Exception e) {
            workerId = NetUtil.getLocalhostStr().hashCode();
        }
    }

    public synchronized long snowflakeId(long workerId, long datacenterId) {
        Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);
        return snowflake.nextId();
    }

    public static synchronized long snowflakeId() {
        return snowflake.nextId();
    }
}
