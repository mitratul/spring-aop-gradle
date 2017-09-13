package org.mitratul.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class DoAfterReturnMethod implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method,
            Object[] args, Object target) throws Throwable {
        System.out.println("****SPRING AOP**** DoAfterReturningMethod : Executing after method return " + method);
    }

}
