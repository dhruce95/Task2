package com.example.demo.Logger;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Configuration
public class Logger {
	ObjectMapper mapper = new ObjectMapper();
	@Around("execution(* com.example.demo.controller.AlienController.*(..)) && @annotation(com.example.demo.Annotations.LogMethodParam)")
    public Object logMethods(ProceedingJoinPoint jp) throws Throwable {
        String methodName = jp.getSignature().getName();
        logMethodInvocationAndParameters(jp);

        long startTime = new Date().getTime();
        Object result = jp.proceed(jp.getArgs());
        long endTime = new Date().getTime();
        System.out.println("\nExecution time: " + (endTime - startTime) + "ms");
        System.out.println("==Method Name::" + methodName + "() is returning== \n" + mapper.writeValueAsString(result) + "\n");
        return result;
    }

    private void logMethodInvocationAndParameters(ProceedingJoinPoint jp) {
        String[] argNames = ((MethodSignature) jp.getSignature()).getParameterNames();
        Object[] values = jp.getArgs();
        Map<String, Object> params = new HashMap<>();
        if (argNames.length != 0) {
            for (int i = 0; i < argNames.length; i++) {
                params.put(argNames[i], values[i]);
            }
        }
        System.out.println("==Method Name::" + jp.getSignature().getName() + "()==");
        if (!params.isEmpty()) System.out.println(params.toString());
    }

}
