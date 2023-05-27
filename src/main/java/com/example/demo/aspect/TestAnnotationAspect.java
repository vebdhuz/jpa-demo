package com.example.demo.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.example.demo.annotation.MyTestAnnotation;

@Aspect
@Component
public class TestAnnotationAspect {
  
  @Pointcut("@annotation(com.example.demo.annotation.MyTestAnnotation)")
  public void myAnnotationPointCut(){
  }

  @Before("myAnnotationPointCut()")
  public void before(JoinPoint joinpoint) throws Throwable {
    MethodSignature sign = (MethodSignature)joinpoint.getSignature();
    Method method = sign.getMethod();
    MyTestAnnotation annotation = method.getAnnotation(MyTestAnnotation.class);
    System.out.println("annotation value:"+annotation.value());
  }
}
