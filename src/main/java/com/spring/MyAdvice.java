package main.java.com.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author luying
 * @date 2018/11/13
 */
//public class MyAdvice {
//
//    //前置通知，方法名是自己定义的
//    public void before(){
//        System.out.println("这是前置通知");
//    }
//
//
//    //后置通知
//    public void afterReturning(){
//        System.out.println("这是后置通知(如果出现异常不会调用)");
//    }
//
//
//    //环绕通知
//    public Object around(ProceedingJoinPoint pjp) throws Throwable {
//        System.out.println("这是环绕通知之前的部分！");
//        Object proceed = pjp.proceed();//调用目标方法
//        System.out.println("这是环绕通知之后的部分！");
//        return proceed;
//    }
//
//
//    //异常通知
//    public void afterException(){
//        System.out.println("异常出现了！");
//    }
//    //后置通知
//    public void  after(){
//        System.out.println("这是后置通知(出现异常也会调用)");
//    }
//}




 //注解方式aop
//表示是一个通知类
@Aspect
public class MyAdvice {

    @Pointcut("execution(* main.java.com.spring.service..*ServiceImpl.*(..))")
    public void pointCut(){}


    //前置通知，方法名是自己定义的
    //指定方法是前置通知，并制定切入点
    @Before("MyAdvice.pointCut()")
    public void before(){
        System.out.println("这是前置通知");
    }


    //后置通知
    @AfterReturning("execution(* main.java.com.spring.service..*ServiceImpl.*(..))")
    public void afterReturning(){
        System.out.println("这是后置通知(如果出现异常不会调用)");
    }


    //环绕通知
    @Around("execution(* main.java.com.spring.service..*ServiceImpl.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("这是环绕通知之前的部分！");
        Object proceed = pjp.proceed();//调用目标方法
        System.out.println("这是环绕通知之后的部分！");
        return proceed;
    }


    //异常通知
    @AfterThrowing("execution(* main.java.com.spring.service..*ServiceImpl.*(..))")
    public void afterException(){
        System.out.println("异常出现了！");
    }


    //后置通知
    @After("execution(* main.java.com.spring.service..*ServiceImpl.*(..))")
    public void  after(){
        System.out.println("这是后置通知(出现异常也会调用)");
    }
}
