package com.linkedinlearning.calculator;

public class Main {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Need to provide 3 arguments: [operation] [value 1] [value 2]");
        }

        String operation = arg[0];
        Integer a = Integer.valueOf(arg[1]);
        Integer b =  Integer.valueOf(arg[2]);

        Calculator calculator = new Calculator();

        if ("add".equals(operation)) {
            System.out.println(calculator.add(a, b));
        } else if ("subtract".equals(operation)) {
            System.out.println(calculator.subtract(a, b));
        } else if ("multiply".equals(operation)) {
            System.out.println(calculator.multiply(a, b));
        } else if ("divide".equals(operation)) {
            System.out.println(calculator.divide(a, b));
        } else {
            throw new IllegalArgumentException("Unsupported operation: " + operation);
        }
    }
}