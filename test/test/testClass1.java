package test;

import org.junit.Assert;

import org.junit.Test;

public class testClass1 {
	 String message = "Robert";	
	   MessageUtil messageUtil = new MessageUtil(message);
	   int i=10;
	   @Test
	   public void testPrintMessage() {	
	      System.out.println("Inside testPrintMessage()");    
	      Assert.assertEquals(message, messageUtil.printMessage());     
	   }

	   @Test(expected = ArithmeticException.class)  
		public void divisionWithException() {  
		i=i/0;
		}  
}
