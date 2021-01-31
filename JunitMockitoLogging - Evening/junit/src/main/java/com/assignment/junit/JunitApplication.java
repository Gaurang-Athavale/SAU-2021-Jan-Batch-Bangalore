package com.assignment.junit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class JunitApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LeapYear obj = new LeapYear();
		int year = sc.nextInt();
		if (obj.isLeapYear(year)) {
			System.out.println("Year is a Leap Year");
		} else {
			System.out.println("Year is not a Leap Year");
		}
	}

}
