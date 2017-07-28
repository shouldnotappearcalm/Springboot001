package com.gzr.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * ${description}
 * Created by GZR
 * 2017-07-04
 */
@Aspect
@Component
public class WebLogAspect {

    private Logger logger= LoggerFactory.getLogger(WebLogAspect.class);

    /**
     * execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?
     * name-pattern(param-pattern) throws-pattern?)
     * public 修饰的 *为任意返回值 com.gzr.controller..*.*为controller下的包括子包的任意类
     * (..)任意参数类型和个数
     */
    @Pointcut("execution(public * com.gzr.controller..*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }
    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret);
    }

    @Around("webLog()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.error("around begin");
        long start=System.currentTimeMillis();
        Object o=proceedingJoinPoint.proceed();
        long end=System.currentTimeMillis();
        logger.error("runtime:"+(end-start));
        return o;
    }

}
