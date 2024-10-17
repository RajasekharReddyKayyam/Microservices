package com.example.beans;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
	@Test
	public  void addTest() {
		Calculator c=new Calculator ();
		int actualresult=c.add(10, 20);
		int expectedresult=30;
		assertEquals(actualresult,expectedresult);
	}
	@Test
	public void MulTest() {
		Calculator c=new Calculator();
		
		int actualresult=c.mul(10, 20);
		int expectedresult=200;
		assertEquals(actualresult,expectedresult);
	}

}
