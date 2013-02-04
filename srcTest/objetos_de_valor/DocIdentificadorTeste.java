package objetos_de_valor;

//TODO Validar 'equals' e 'hashCode';

/*
 * 
 * POWERMOCK E MOCKITO CONFLITANDO! NÃO DÁ PRA TESTAR OS MÉTODOS 'FINAL'.
 * 
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
*/
//@RunWith(PowerMockRunner.class)
//@PrepareForTest(DocIdentificador.class)
public class DocIdentificadorTeste {

	/*
	 * NOTA:
	 * "==" compara valores de tipos primitivos, caso contrário, compara as referências;
	 * 
	 * "equals", por padrão, quando não é sobrescrito, compara referências (mesmo que "==") e, 
	 *  para tratar de valores, é ideal sobrescrever o método "hashCode", pois objetos iguais
	 *  possuem o mesmo hash;
	 *  
	 *  
	 *  EXEMPLO:
	 *  str1 = new String("1234");
	 *  str2 = new String("1234");
	 *  
	 *  str1 == str2 --RETORNA FALSE (objetos diferentes)
	 *  str1.equals(str2) --RETORNA TRUE (valores iguais)
	 *  
	 *  ===========================================================
	 *  
	 *  str1 = "1234";
	 *  str2 = "1234";
	 *  
	 *  str1 == str2 --RETORNA TRUE (mesmo objeto [Pool de Strings])
	 *  str1.equals(str2) --RETORNA TRUE (valores iguais)
	 *  
	 */
	/*
	@Test
	public void deve_se_comportar_como_objeto_de_valor() {
		final DocIdentificador docIdentificador1 = mock(DocIdentificador.class);
		final DocIdentificador docIdentificador2 = mock(DocIdentificador.class);
		
		String documento = "12345678901";
		
		when(docIdentificador1.getValor()).thenReturn(documento);
		when(docIdentificador2.getValor()).thenReturn(documento);
		
		assertThat(docIdentificador1.equals(docIdentificador2), is(true));
	}
	*/

}
