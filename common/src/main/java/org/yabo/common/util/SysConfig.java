package org.yabo.common.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SysConfig {

    private Map<String, String> config = new ConcurrentHashMap<>();

    private SysConfig() {
    }

    private static final class ConfigHolder {
        static SysConfig CONFIG = new SysConfig();
    }

    public static SysConfig getSysConfig() {
        return ConfigHolder.CONFIG;
    }

    public void set(String key, String value) {
        config.put(key, value);
    }

    public String getString(String key) {
        return config.get(key);
    }

    public Long getLong(String key) {
        String value = getString(key);
        return value != null ? Long.valueOf(value) : null;
    }

    public Boolean getBoolean(String key) {
        return Boolean.valueOf(getString(key));
    }

    public static void main(String[] args) {
        System.out.println(getSysConfig().getBoolean("a"));
    }
}
