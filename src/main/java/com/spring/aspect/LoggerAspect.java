package main.java.com.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author luying
 * @date 2018/11/12
 */
public class LoggerAspect {

    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("start log:" + joinPoint.getSignature().getName());
        Object object = joinPoint.proceed();
        System.out.println("end log:" + joinPoint.getSignature().getName());
        return object;
    }
}
