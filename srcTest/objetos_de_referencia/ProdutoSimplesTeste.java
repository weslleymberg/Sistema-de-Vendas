package objetos_de_referencia;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import org.junit.Test;
import objetos_de_referencia.Produto;

public class ProdutoSimplesTeste {

	@Test
	public void deve_instanciar_um_produto() {
		Produto produto = new ProdutoSimples(1234, "Xperia Neo", "Celular", new BigDecimal("2"), new BigDecimal("800.00"));
		assertThat(produto, instanceOf(Produto.class));
	}
	
	@Test
	public void deve_possuir_codigo_e_preco() {
		Produto produto = new ProdutoSimples(1234, "Xperia Neo", "Celular", new BigDecimal("2"), new BigDecimal("800.00"));
		assertThat(produto.getPreco(), is(new BigDecimal("800.00")));
		assertThat(produto.getCodigo(), is(new Long(1234)));
	}

}
