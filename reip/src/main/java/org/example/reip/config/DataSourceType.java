package org.example.reip.config;

import org.example.reip.exception.GraduException;

/**
 * @author cyan
 * @since 2022/4/17
 */
public class DataSourceType {

    public enum Type {
        MASTER("masterdb", "use master database"),
        SLAVE("slavedb", "use slave database")
        ;
        private String type;
        private String msg;

        Type(String type, String msg) {
            this.type = type;
            this.msg = msg;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public static Type getMasterData(String type) {
            Type[] arrays = values();
            for (Type val: arrays) {
                if (val.getType().equals(type)) {
                    return val;
                }
            }
            return Type.MASTER;
        }
    }

    private static final ThreadLocal<String> THREAD_DB = new ThreadLocal<String>();

    public static void setDataBaseType(Type type) {
        if (type == null) {
            throw new GraduException("20715|datebase exception");
        }
        THREAD_DB.set(type.getType());
    }

    public static Type getDataBaseType() {
        return THREAD_DB.get() == null ? Type.MASTER : Type.getMasterData(THREAD_DB.get());
    }

    public static void clearDataBaseType() {
        THREAD_DB.remove();
    }

}
