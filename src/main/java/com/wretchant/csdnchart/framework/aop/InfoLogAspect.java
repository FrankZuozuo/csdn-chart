package com.wretchant.csdnchart.framework.aop;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import com.wretchant.csdnchart.annotation.InfoLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Component
@Aspect
public class InfoLogAspect {

  @Pointcut("@annotation(com.wretchant.csdnchart.annotation.InfoLog)")
  public void infoLog() {}

  @Around("infoLog()")
  public Object before(ProceedingJoinPoint joinPoint) throws Throwable {

    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    Method method = signature.getMethod();
    InfoLog annotation = method.getAnnotation(InfoLog.class);
    String value = annotation.value();

    TimeInterval timer = DateUtil.timer();
    Object proceed = joinPoint.proceed();

    if (log.isInfoEnabled()) {
      log.info("[{}] : [{}]", timer.interval(), value);
    }
    return proceed;
  }
}
