package ru.innopolis.stc12.exceptions;

import java.io.IOException;

public class MathBox {

    public int summa(Integer a, Integer b) {
        return a + b;
    }

    public int diff(Integer a, Integer b) {
        return a - b;
    }

    public long factorial(Integer value) {
        if (value == 1 || value == 0) {
            return 1;
        }
        return factorial(value - 1) * value;
    }

    public double dividerExceptionInside(Integer a, Integer b) {
        try{
            return a/b;
        }catch(ArithmeticException e){
            System.out.println("Catched Exception "+ e);
        }
        return 0;
    }

    public double divider(Integer a, Integer b) throws Exception {
        try {
            return a / b;
        }catch(ArithmeticException e){
            throw new Exception(e.getMessage() +" was catched and thrown");
        }
    }

    public static void main(String[] args) throws MyCustomException {
        MathBox mathBox = new MathBox();

        System.out.println("Method summa: " + mathBox.summa(1, 3));
        System.out.println("\nMethod diff: " + mathBox.diff(1, 3));
        try{
            System.out.println("\nMethod factorial: ");
            System.out.println(mathBox.factorial(Integer.MAX_VALUE));
        }catch (StackOverflowError e){
            System.out.println("Catched Exception " +e);
        }
        System.out.println("\nMethod dividerExceptionInside: ");
        System.out.println(mathBox.dividerExceptionInside(13,0));
        System.out.println("\nMethod divider throwing exception: ");
        try {
            System.out.println(mathBox.divider(26, 0));
        }catch (Exception e){
            throw new MyCustomException("My custom Exception, with info : " + e );
        }
    }

}
