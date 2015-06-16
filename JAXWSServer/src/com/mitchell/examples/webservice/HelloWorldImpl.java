package com.mitchell.examples.webservice;

import javax.jws.WebService;

import com.mitchell.examples.jdbc.InsertClaim;
import com.mitchell.examples.jdbc.ReadClaim;

@WebService(endpointInterface = "com.mitchell.examples.webservice.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	public String helloWorld(String name) {

		// new InsertClaim().insertClaim();
		 new ReadClaim().readClaim();
		System.out.println("******");
		new ReadClaim().readClaim("2014-07-09", "2014-08-08");
		System.out.println("******");
		new ReadClaim().readClaim("2014-07-10", "2014-08-09");
		// new DeleteClaim().deleteClaim("33c9c23bac1428560186b6c299");
		return "Hello " + name + "\nQueries executed";
	}

}
