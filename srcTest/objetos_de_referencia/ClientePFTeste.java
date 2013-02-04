package objetos_de_referencia;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import objetos_de_valor.Cpf;

import org.junit.Test;

public class ClientePFTeste {

	@Test
	public void deve_criar_um_cliente_fisico() {
		// TODO pesquisar chamada do metodo 'getCpf' a partir de Cliente;
		ClientePF cliente = new ClientePF(1234, "Weslleymberg", "Campos", "99312376", new BigDecimal("0.2"), new Cpf("12345678901"));
		
		assertThat(cliente.getCodigo(), is(new Long(1234)));
		assertThat(cliente.getNome(), is("Weslleymberg"));
		assertThat(cliente.getEndereco(), is("Campos"));
		assertThat(cliente.getTelefone(), is("99312376"));
		assertThat(cliente.getPorcentoDesconto(), is(new BigDecimal("0.2")));
		assertThat(cliente.getCpf(), is("12345678901"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deve_retornar_uma_excecao_no_cnpj() {
		ClientePF cliente = new ClientePF(1234, "Weslleymberg", "Campos", "99312376", new BigDecimal("0.2"), new Cpf("1234567890123"));
	}

}
