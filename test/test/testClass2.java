package test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class testClass2 {
	 String message = "Jahanzaib";	
	   MessageUtil messageUtil = new MessageUtil(message);
	 
	   @Ignore("Not ready to run")
	   @Test
	   public void testSalutationMessage() {
	      System.out.println("Inside testSalutationMessage()");
	      message = "Hi!" + "Robert";
	      Assert.assertEquals(message,messageUtil.salutationMessage());
	   }
}
