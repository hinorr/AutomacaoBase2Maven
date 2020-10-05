package br.com.base2.suiteTest;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import TST_001_Login.TST_001_02_LoginValido;




@RunWith(Suite.class)


@Suite.SuiteClasses({
	
	TST_001_02_LoginValido.class,
	//TST_001_01_LoginInvalido.class,
	//TST_002_01_RelatarCasoCamposObgPreenchidos.class,

})


public class SuiteTeste {

		
    @BeforeClass
    public static void setUp() {
   
    	System.out.println("Suite - @BeforeClass");
    }

   
} 