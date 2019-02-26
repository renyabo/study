package org.yabo.spring.test.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.expression.AnnotatedElementKey;
import org.springframework.expression.EvaluationContext;
import org.springframework.stereotype.Component;
import org.yabo.common.anno.CheckEntity;

import java.lang.reflect.Method;

@Component
@Aspect
public class CheckEntityAspect {
    protected final Logger logger = Logger.getLogger(CheckEntityAspect.class);

    private ExpressionEvaluator<Long> evaluator = new ExpressionEvaluator<>();

    @Before("execution(* *.*(..)) && @annotation(checkEntity)")
    public void checkEntity(JoinPoint joinPoint, CheckEntity checkEntity) {
        Long result = getValue(joinPoint, checkEntity.key());
        logger.info("result: " + result);
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
