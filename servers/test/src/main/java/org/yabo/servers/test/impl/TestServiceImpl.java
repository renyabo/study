package org.yabo.servers.test.impl;

import org.springframework.stereotype.Service;
import org.yabo.common.Code;
import org.yabo.common.Result;
import org.yabo.common.Util.LocalIpAddressUtil;
import org.yabo.service.test.TestService;

@Service("testService")
public class TestServiceImpl implements TestService {
    @Override
    public Result<String> test(String in) {
        Result<String> result = new Result<>();
        result.setCode(Code.SUCCESS);
        result.setData(Thread.currentThread().getName());
//        result.setData(String.format("in=%s,thread=%s,host=%s", in, Thread.currentThread(), LocalIpAddressUtil.resolveLocalAddresses()));
        return result;
    }
}
