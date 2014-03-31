package designPattern.aop;

public class Calculator {

    public void add(int a, int b) {
        if (a < 0) {
            throw new IllegalArgumentException("value should not be negative, a : " + a);
        }

        if (b < 0) {
            throw new IllegalArgumentException("value should not be negative, b : " + b);
        }

        System.out.println("Sum of two numbers : " + (a + b));
    }
}
