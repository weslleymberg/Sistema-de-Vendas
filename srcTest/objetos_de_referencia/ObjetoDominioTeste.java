package objetos_de_referencia;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Mockito;

public class ObjetoDominioTeste {

	@Test
	public void deve_agrir_como_objeto_de_referencia() {
		ObjetoDominio objetoDominio = mock(ObjetoDominio.class, Mockito.CALLS_REAL_METHODS);
		ObjetoDominio objetoDominio2 = mock(ObjetoDominio.class, Mockito.CALLS_REAL_METHODS);
		
		assertThat(objetoDominio.equals(objetoDominio2), is(false));
	}

}
