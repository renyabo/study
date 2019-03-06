package org.yabo.repository.aspect;

import org.yabo.common.util.SysConfig;

public class CacheUtil {
    public Boolean canUseCache() {
        Boolean canUser = SysConfig.getSysConfig().getBoolean("cache.open");
        System.out.println("can user cache.." + canUser);
        return canUser;
    }
}
