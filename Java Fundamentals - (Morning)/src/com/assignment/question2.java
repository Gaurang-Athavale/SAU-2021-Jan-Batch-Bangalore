package com.assignment;

import java.util.Scanner;

public class question2 {
    public static int divide(int x, int y) throws ArithmeticException
    {
        if(y == 0) {
            throw new ArithmeticException("Error: Division by 0 is invalid");
        }
        return x/y;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two numbers : x and y");
        int x = sc.nextInt();
        int y = sc.nextInt();
        try {
            int answer = divide(x, y);
            System.out.println(answer);
        }
        catch(ArithmeticException e) {
            System.out.println("Arithmetic Exception: Cannot Divide by Zero");
            try {
                System.out.println("Enter two numbers again: x and y");
                x = sc.nextInt();
                y = sc.nextInt();
                int result = divide(x, y);
                System.out.println(result);
            } catch (ArithmeticException err) {
                System.out.println(err);
            }
        }
        sc.close();
        }


}

