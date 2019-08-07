package org.yabo.dubbo.filters;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;

@Activate(group = Constants.CONSUMER, order = -10000000)
public class YaboFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.err.println("yabo filter ok...");

        return invoker.invoke(invocation);
    }
}
