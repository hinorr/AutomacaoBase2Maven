package br.com.base2.suiteTest;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import TST_001_Login.TST_001_02_LoginValido;
import TST_003_ConsultarCaso.TST_003_01_ConsultarCasoDeProjetoPorResumo;
import TST_003_ConsultarCaso.TST_003_02_ConsultarCasoPorID;




@RunWith(Suite.class)


@Suite.SuiteClasses({
	
	TST_001_02_LoginValido.class,
	//TST_001_01_LoginInvalido.class,
	//TST_002_01_RelatarCasoCamposObgPreenchidos.class,
	//TST_003_01_ConsultarCasoDeProjetoPorResumo.class,
	//TST_003_02_ConsultarCasoPorID.class,
	

})


public class SuiteTeste {

		
    @BeforeClass
    public static void setUp() {
   
    	System.out.println("Suite - @BeforeClass");
    }

   
} 