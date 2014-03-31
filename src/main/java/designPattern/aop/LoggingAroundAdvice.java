package designPattern.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.Arrays;

public class LoggingAroundAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("Before Invoking Method in around advice : " + methodInvocation.getMethod().getName());
        System.out.println("Method arguments : " + Arrays.toString(methodInvocation.getArguments()));
        try {
            // invoking actual method
            Object result = methodInvocation.proceed();
            System.out.println("After Invoking Method in around advice : " + methodInvocation.getMethod().getName());
            return result;
        } catch (Exception ex) {
            System.out.println("Exception in Around Advice : " + ex.getMessage());
            throw ex;
        }
    }
}
