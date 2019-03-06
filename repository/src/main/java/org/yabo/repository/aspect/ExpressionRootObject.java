package org.yabo.repository.aspect;

import java.lang.reflect.Method;

public class ExpressionRootObject {

    private final Method method;
    private final Object[] args;
    private final Object target;
    private final Class<?> targetClass;

    public ExpressionRootObject(Method method, Object[] args, Object target, Class<?> targetClass) {
        this.method = method;
        this.target = target;
        this.targetClass = targetClass;
        this.args = args;
    }

    public Method getMethod() {
        return this.method;
    }

    public String getMethodName() {
        return this.method.getName();
    }

    public Object[] getArgs() {
        return this.args;
    }

    public Object getTarget() {
        return this.target;
    }

    public Class<?> getTargetClass() {
        return this.targetClass;
    }
}
