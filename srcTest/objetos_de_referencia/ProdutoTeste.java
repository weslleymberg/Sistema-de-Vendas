package objetos_de_referencia;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.math.BigDecimal;

import org.junit.Test;
import org.mockito.Mockito;

public class ProdutoTeste {

	@Test
	public void deve_calcular_preco() {
		Produto produto = mock(Produto.class, Mockito.CALLS_REAL_METHODS);
		doReturn(new BigDecimal("2.00")).when(produto).getPreco();
		assertThat(produto.calcularPreco(new BigDecimal("10")), equalTo(new BigDecimal("20.00")));
	}
	
	@Test
	public void deve_calcular_frete() {
		Produto produto = mock(Produto.class, Mockito.CALLS_REAL_METHODS);
		assertThat(produto.calcularFrete(new BigDecimal("3.00"), new BigDecimal("10")), equalTo(new BigDecimal("30.00")));
		
	}

}
