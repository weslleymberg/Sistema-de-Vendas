package objetos_de_referencia;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.math.BigDecimal;

import org.junit.Test;
import org.mockito.Mockito;

public class ClienteTeste {
	
	@Test
	public void deve_calcular_desconto() {
		Cliente cliente = mock(Cliente.class, Mockito.CALLS_REAL_METHODS);
		doReturn(new BigDecimal("0.10")).when(cliente).getPorcentoDesconto();
		assertThat(cliente.aplicarDesconto(new BigDecimal("500.00")), equalTo(new BigDecimal("450.00")));
		//assertEquals(new BigDecimal("450.0"), cliente.aplicarDesconto(new BigDecimal("500.0")));
	}

}
