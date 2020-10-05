package br.com.base2.TestRunner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import br.com.base2.suiteTest.SuiteTeste;

public class TestRun {
	
	
   public static void main(String[] args) {
	   
      Result result = JUnitCore.runClasses(SuiteTeste.class);
      
      for (Failure failure : result.getFailures()) {
    	  
         System.out.println(failure.toString());
         
      }
      System.out.println(result.wasSuccessful());
   }
} 