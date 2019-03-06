package org.yabo.spring.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yabo.repository.aspect.CacheUtil;

@Service("yabo")
public class Util {
    @Autowired
    CacheUtil cacheUtil;

    public Boolean check() {
        return cacheUtil.canUseCache();
    }
}
