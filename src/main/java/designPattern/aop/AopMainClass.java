package designPattern.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMainClass {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring-context.xml");
        Calculator calculator = context.getBean("calculatorProxy", Calculator.class);
        calculator.add(3, 10);
    }
}
