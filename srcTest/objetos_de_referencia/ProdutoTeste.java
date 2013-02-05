package objetos_de_referencia;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ProdutoTeste {
	
	private Produto produto;
	
	@Before
	public void setUp() {
		produto = mock(Produto.class, Mockito.CALLS_REAL_METHODS);
	}

	@Test
	public void deve_calcular_preco() {
		doReturn(new BigDecimal("2.00")).when(produto).getPreco();
		assertThat(produto.calcularPreco(new BigDecimal("10")), equalTo(new BigDecimal("20.00")));
	}
	
	@Test
	public void deve_calcular_frete() {
		doReturn(new BigDecimal("0.2")).when(produto).getPesoEmKg();
		assertThat(produto.calcularFrete(new BigDecimal("3.00"), new BigDecimal("10")), equalTo(new BigDecimal("6.00")));
		
	}

}
