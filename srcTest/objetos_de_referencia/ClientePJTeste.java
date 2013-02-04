package objetos_de_referencia;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import objetos_de_valor.Cnpj;

import org.junit.Test;

public class ClientePJTeste {

	@Test
	public void deve_criar_um_cliente_juridico() {
		// TODO pesquisar chamada do metodo 'getCpf' a partir de Cliente;
		ClientePJ cliente = new ClientePJ(1234, "Weslleymberg", "Campos", "99312376", new BigDecimal("0.2"), new Cnpj("12345678901234"));
		
		assertThat(cliente.getCodigo(), is(new Long(1234)));
		assertThat(cliente.getNome(), is("Weslleymberg"));
		assertThat(cliente.getEndereco(), is("Campos"));
		assertThat(cliente.getTelefone(), is("99312376"));
		assertThat(cliente.getPorcentoDesconto(), is(new BigDecimal("0.2")));
		assertThat(cliente.getCnpj(), is("12345678901234"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deve_retornar_uma_excecao_no_cnpj() {
		// TODO pesquisar chamada do metodo 'getCpf' a partir de Cliente;
		ClientePJ cliente = new ClientePJ(1234, "Weslleymberg", "Campos", "99312376", new BigDecimal("0.2"), new Cnpj("1234567890123"));
	}

}
