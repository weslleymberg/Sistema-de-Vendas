package objetos_de_referencia;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class ItemTeste {
	
	private Item item;
	private Produto produto;

	@Before
	public void setUp() throws Exception {
		produto = new ProdutoSimples(1234, "Caneta", "Caneta esferográfica colorida", new BigDecimal("0.2"), new BigDecimal("1.00"));
		item = new Item(123, produto, new BigDecimal("3"));
	}

	@Test
	public void deve_criar_um_item() {
		assertThat(item, instanceOf(Item.class));
	}
	
	@Test
	public void deve_calcular_o_preco_total() {
		assertThat(item.calcularTotal(), is(new BigDecimal("3.00")));
	}
	
	@Test
	public void deve_calcular_o_frete() {
		assertThat(item.calcularFrete(new BigDecimal("3.00")), is(new BigDecimal("1.80")));
	}
	
	@Test
	public void deve_confirmar_o_item() {
		item.confirmar();
		assertThat(item.confirmado(), is(true));
	}
	
	@Test
	public void deve_dizer_se_a_entrega_foi_concluida_ou_nao() {
		item.setQtdeEntregue(new BigDecimal("2"));
		assertThat(item.concluido(), is(false));
		item.setQtdeEntregue(new BigDecimal("1"));
		assertThat(item.concluido(), is(true));
	}

}
