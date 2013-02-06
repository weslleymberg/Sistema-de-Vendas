package objetos_de_referencia;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import objetos_de_valor.Cpf;
import objetos_de_valor.DocIdentificador;

import org.junit.Before;
import org.junit.Test;

public class PedidoTeste {
	
	private Pedido pedido;
	private Cliente cliente;
	private DocIdentificador cpf;
	private Produto produto;
	private Produto produto2;
	private Produto produto3;
	private Produto kit;

	@Before
	public void setUp() throws Exception {
		cpf = new Cpf("12345678901");
		cliente = new ClientePF(1231, "Weslleymberg", "Campos dos Goytacazes - RJ", "(22)9931-2376", new BigDecimal("0.1"), (Cpf) cpf);
		pedido = new Pedido(1232, cliente, "Campos dos Goytacazes - RJ", new BigDecimal("3.00"));
		produto = new ProdutoSimples(1235, "Xperia Neo", "Eletrônicos", new BigDecimal("0.30"), new BigDecimal("800.00"));
		kit = new Kit(1235, "Acessórios", "Acessórios Sony", new BigDecimal("0"), new BigDecimal("0.2"));
		produto2 = new ProdutoSimples(1235, "Sony Smart Headset", "Acessórios", new BigDecimal("0.10"), new BigDecimal("150.00"));
		produto3 = new ProdutoSimples(1235, "Sony Smart Watch", "Acessórios", new BigDecimal("0.10"), new BigDecimal("150.00"));
	}

	@Test
	public void deve_instanciar_um_pedido() {
		assertThat(pedido, instanceOf(Pedido.class));
	}
	
	@Test
	public void deve_fazer_a_inclusao_de_itens() {
		pedido.atualizarItem(produto, new BigDecimal("2"));
		assertThat(produto, is(pedido.getItem(produto).getProduto()));
	}
	
	@Test
	public void deve_atualizar_um_item_especifico() {
		pedido.atualizarItem(produto, new BigDecimal("2"));
		assertThat(pedido.getItem(produto).getQtde(), is(new BigDecimal("2")));
		pedido.atualizarItem(produto, new BigDecimal("3"));
		assertThat(pedido.getItem(produto).getQtde(), is(new BigDecimal("3")));
	}
	
	@Test
	public void deve_remover_um_item_especifico() {
		pedido.atualizarItem(produto, new BigDecimal("2"));
		assertThat(pedido.getItem(produto).getQtde(), is(new BigDecimal("2")));
		pedido.atualizarItem(produto, new BigDecimal("0"));
		assertThat(pedido.getItem(produto), is((Item) null));
	}
	
	@Test
	public void deve_calcular_preco_total_dos_itens() {
		pedido.atualizarItem(produto, new BigDecimal("1"));
		pedido.atualizarItem(kit, new BigDecimal("1"));
		((Kit) kit).adicionarFilho(produto2);
		((Kit) kit).adicionarFilho(produto3);
		assertThat(pedido.calcularTotalItens(), is(new BigDecimal("1040.00")));
	}
	
	@Test
	public void deve_calcular_o_frete() {
		pedido.atualizarItem(produto, new BigDecimal("1"));
		pedido.atualizarItem(kit, new BigDecimal("1"));
		((Kit) kit).adicionarFilho(produto2);
		((Kit) kit).adicionarFilho(produto3);
		assertThat(pedido.calcularFrete(), is(new BigDecimal("1.50")));
	}
	
	public void deve_calcular_o_valor_total() {
		pedido.atualizarItem(produto, new BigDecimal("1"));
		pedido.atualizarItem(kit, new BigDecimal("1"));
		((Kit) kit).adicionarFilho(produto2);
		((Kit) kit).adicionarFilho(produto3);
		assertThat(pedido.calcularTotalGeral(), is(new BigDecimal("1041.50")));
	}

}
