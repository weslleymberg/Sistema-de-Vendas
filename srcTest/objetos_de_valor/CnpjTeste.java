package objetos_de_valor;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class CnpjTeste {

	@Test
	public void deve_validar_o_cnpj() {
		DocIdentificador cnpj = new Cnpj("12345678901234");
		
		assertThat(cnpj.validar(), is(true));
	}
	
	@Test
	public void deve_recusar_o_cnpj() {
		DocIdentificador cnpj = new Cnpj("1234567890123");
		
		assertThat(cnpj.validar(), is(false));
	}

}
