package objetos_de_valor;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class CpfTeste {

	@Test
	public void deve_validar_o_cpf() {
		DocIdentificador cpf = new Cpf("12345678901");
		
		assertThat(cpf.validar(), is(true));
	}
	
	@Test
	public void deve_recusar_o_cpf() {
		DocIdentificador cpf = new Cpf("1234567890");
		
		assertThat(cpf.validar(), is(false));
	}
	
	//Já que os testes não puderam ser feitos na classe super,
	//estes serão feitos através de uma instância;
	@Test
	public void deve_comparar_cpf_e_retornar_true() {
		DocIdentificador cpf1 = new Cpf("1234567890");
		DocIdentificador cpf2 = new Cpf("1234567890");
		
		assertThat(cpf1.equals(cpf2), is(true));
	}
	
	@Test
	public void deve_comparar_cpf_e_retornar_false() {
		DocIdentificador cpf1 = new Cpf("1234567890");
		DocIdentificador cpf2 = new Cpf("1234567891");
		
		assertThat(cpf1.equals(cpf2), is(false));
	}

}
