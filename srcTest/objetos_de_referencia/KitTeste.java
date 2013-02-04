package objetos_de_referencia;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

//TODO Perguntar a Lucas o comportamento de ajestePreco e pesoEmKg;

public class KitTeste {
	private Produto kit;
	private Produto produto1;
	private Produto produto2;
	private ArrayList<Produto> produtos;
	
	@Before
	public void setUp() {
		kit = new Kit(1234, "Eletronicos", "Kit completo", new BigDecimal("0"), new BigDecimal("0.2"));
		produto1 = new ProdutoSimples(1234, "Xperia Neo", "Aparelho", new BigDecimal("2"), new BigDecimal("800.00"));
		produto2 = new ProdutoSimples(1231, "Sony Headset", "Acessórios", new BigDecimal("2"), new BigDecimal("100.00"));
		produtos = new ArrayList<Produto>();
	}

	@Test
	public void deve_instanciar_um_kit_de_produtos() {
		assertThat(kit, instanceOf(Produto.class));
	}
	
	@Test
	public void deve_adicionar_um_produto_no_kit() {
		((Kit) kit).adicionarFilho(produto1);
		Iterator<Produto> iterator = ((Kit) kit).getFilhos();
		while (iterator.hasNext()){
			produtos.add(iterator.next());
		}
		
		assertThat(produtos, contains(produto1));
	}
	
	@Test
	public void deve_remover_um_produto_do_kit() {
		((Kit) kit).adicionarFilho(produto1);
		((Kit) kit).adicionarFilho(produto2);
		((Kit) kit).removerFilho(produto1);
		
		Iterator<Produto> iterator = ((Kit) kit).getFilhos();
		while (iterator.hasNext()){
			produtos.add(iterator.next());
		}
		
		assertThat(produtos.size(), is(1));
		assertThat(produtos, not(contains(produto1)));
	}
	
	@Test
	public void deve_retornar_o_preco_do_kit() {
		((Kit) kit).adicionarFilho(produto1);
		((Kit) kit).adicionarFilho(produto2);
		
		assertThat(kit.getPreco(), is(new BigDecimal("720.00")));
	}
	
	@Test
	public void deve_reajustar_o_preco_do_kit() {
		((Kit) kit).adicionarFilho(produto1);
		((Kit) kit).adicionarFilho(produto2);
		
		assertThat(kit.getPreco(), is(new BigDecimal("720.00")));
		((Kit) kit).setAjustePreco(new BigDecimal("0.10"));
		assertThat(kit.getPreco(), is(new BigDecimal("810.00")));
	}

}
