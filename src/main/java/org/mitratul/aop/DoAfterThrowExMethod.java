package org.mitratul.aop;

import org.springframework.aop.ThrowsAdvice;

public class DoAfterThrowExMethod implements ThrowsAdvice {

    public void afterThrowing(IllegalArgumentException e) throws Throwable {
        System.out.println("****SPRING AOP**** DoAfterThrowExMethod : Executing when method throws exception!");
    }
}
