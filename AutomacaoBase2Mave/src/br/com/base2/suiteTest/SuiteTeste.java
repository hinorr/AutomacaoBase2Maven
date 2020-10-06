package br.com.base2.suiteTest;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import TST_001_Login.TST_001_01_LoginInvalido;
import TST_001_Login.TST_001_02_LoginValido;
import TST_002_RelatarCasos.TST_002_01_RelatarCasoCamposObgPreenchidos;
import TST_002_RelatarCasos.TST_002_02_RelatarCasoCamposObgNaoPreenchidos;
import TST_003_ConsultarCaso.TST_003_01_ConsultarCasosPorProjeto;
import TST_003_ConsultarCaso.TST_003_02_ConsultarCasoPorID;
import TST_004_AplicarMarcador.TST_004_01_AplicarMarcador;




@RunWith(Suite.class)


@Suite.SuiteClasses({
	
	TST_001_01_LoginInvalido.class,
	TST_001_02_LoginValido.class,	
	TST_002_01_RelatarCasoCamposObgPreenchidos.class,
	TST_002_02_RelatarCasoCamposObgNaoPreenchidos.class,
	TST_003_01_ConsultarCasosPorProjeto.class,
	TST_003_02_ConsultarCasoPorID.class,
	TST_004_01_AplicarMarcador.class,
	

})


public class SuiteTeste {

		
    @BeforeClass
    public static void setUp() {
   
    	System.out.println("Suite - @BeforeClass");
    }

   
} 