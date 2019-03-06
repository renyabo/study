package org.yabo.repository.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.expression.AnnotatedElementKey;
import org.springframework.expression.EvaluationContext;
import org.yabo.common.anno.CheckEntity;
import org.yabo.repository.mapper.UserMapper;

import java.lang.reflect.Method;

@Aspect
public class CheckEntityAspect {
    protected final Logger logger = Logger.getLogger(CheckEntityAspect.class);

    private ExpressionEvaluator<Long> evaluator = new ExpressionEvaluator<>();

    UserMapper userMapper;
    CacheManager cacheManager;

    @Autowired
    public void setCacheManager(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        System.out.println("autowired userMapper,class=" + userMapper.getClass());
        this.userMapper = userMapper;
    }

    @Before("execution(* *.*(..)) && @annotation(checkEntity)")
    public void checkEntity(JoinPoint joinPoint, CheckEntity checkEntity) {
        System.out.println("in check entity aspect..");
        Long result = getValue(joinPoint, checkEntity.key());
        logger.info("result: " + result);
        Cache user = cacheManager.getCache("user");
        user.evict(result);
        System.out.println("running entity check: " + joinPoint.getSignature().getName());
    }

    private Long getValue(JoinPoint joinPoint, String condition) {
        return getValue(joinPoint.getTarget(), joinPoint.getArgs(),
                joinPoint.getTarget().getClass(),
                ((MethodSignature) joinPoint.getSignature()).getMethod(), condition);
    }

    private Long getValue(Object object, Object[] args, Class clazz, Method method,
                          String condition) {
        if (args == null) {
            return null;
        }
        EvaluationContext evaluationContext =
                evaluator.createEvaluationContext(object, clazz, method, args);
        AnnotatedElementKey methodKey = new AnnotatedElementKey(method, clazz);
        return evaluator.condition(condition, methodKey, evaluationContext, Long.class);
    }
}
