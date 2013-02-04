package objetos_de_referencia;

import java.math.BigDecimal;

public class ProdutoSimples extends Produto{

	private BigDecimal preco;
	
	public ProdutoSimples(long codigo, String nome, String descricao, BigDecimal pesoEmKg, BigDecimal preco) {
		super(codigo, nome, descricao, pesoEmKg);
		this.preco = preco;
	}

	public BigDecimal getPreco() {
		return preco;
	}

}
