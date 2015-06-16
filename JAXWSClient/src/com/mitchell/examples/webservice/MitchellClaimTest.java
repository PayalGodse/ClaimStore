package com.mitchell.examples.webservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Test;

public class MitchellClaimTest {

	  
	/*
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		try{
		}catch(Throwable t){
			t.printStackTrace();
		}finally{
			
		}
	}

	@Test
	public void testClaim() {
		try{
			HelloWorldImplService helloWorldService = new HelloWorldImplService();  
		      HelloWorld helloWorld = helloWorldService.getHelloWorldImplPort();  	
		     // System.out.println(helloWorld.helloWorld("Payal"));  
		      assertEquals("Hello " + "Payal" + "\nQueries executed",helloWorld.helloWorld("Payal"));
			//fail("Not yet implemented");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
