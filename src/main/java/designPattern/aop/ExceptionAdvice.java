package designPattern.aop;

import org.springframework.aop.ThrowsAdvice;

public class ExceptionAdvice implements ThrowsAdvice {

    public void afterThrowing(Exception ex) {
        System.out.println("Exception thrown in exception advice : " + ex.getMessage());
    }

}
