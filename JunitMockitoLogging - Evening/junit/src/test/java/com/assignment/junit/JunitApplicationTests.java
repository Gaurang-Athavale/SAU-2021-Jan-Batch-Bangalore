package com.assignment.junit;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class JunitApplicationTests {
	@Test
	public void test1() {
		LeapYear object = new LeapYear();
		boolean answer = object.isLeapYear(2012);
		assertEquals(true, answer);
	}

	@Test
	public void test2() {
		LeapYear object = new LeapYear();
		boolean answer = object.isLeapYear(2021);
		assertEquals(false, answer);
	}

	@Test
	public void test3() {
		LeapYear object = new LeapYear();
		boolean answer = object.isLeapYear(4);
		assertEquals(true, answer);
	}

	@Test
	public void test4() {
		LeapYear object = new LeapYear();
		boolean answer = object.isLeapYear(-2016);
		assertEquals(false, answer);
	}

	@Test
	public void test5() {
		LeapYear object = new LeapYear();
		boolean answer = object.isLeapYear(1600);
		assertEquals(true, answer);
	}

	@Test
	public void test6() {
		LeapYear object = new LeapYear();
		boolean answer = object.isLeapYear(0);
		assertEquals(false, answer);
	}


}
