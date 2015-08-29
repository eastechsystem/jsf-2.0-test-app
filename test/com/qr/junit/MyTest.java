package com.qr.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyTest {

	public MyTest() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void testMethod() {
		String str="Junit Working fine";
		assertEquals("Junit working fine", str);
	}
}
