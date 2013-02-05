package objetos_de_referencia;

import java.math.BigDecimal;

public class Item extends ObjetoDominio {
	
	private BigDecimal qtde;
	private Produto produto;
	private BigDecimal preco;
	private BigDecimal qtdeEntregue;

	Item(long codigo, Produto produto, BigDecimal qtde) {
		super(codigo);
		this.produto = produto;
		this.qtde = qtde;
	}
	
	
	public BigDecimal getQtde() {
		return qtde;
	}


	public void setQtde(BigDecimal qtde) {
		this.qtde = qtde;
	}


	public Produto getProduto() {
		return produto;
	}

	public BigDecimal getPreco() {
		return preco;
	}
	
	public boolean concluido() {
		if (this.getQtdeEntregue().equals(this.getQtde()))
			return true;
		return false;
	}
	
	public BigDecimal getQtdeEntregue() {
		return qtdeEntregue;
	}


	public void setQtdeEntregue(BigDecimal qtdeEntregue) {
		this.qtdeEntregue = qtdeEntregue;
	}


	public boolean confirmado() {
		if (this.getPreco() != null)
			return true;
		return false;
	}
	
	void confirmar() {
		if (this.getPreco() == null)
			this.preco = this.getProduto().getPreco();
	}

	public BigDecimal calcularTotal() {
		return this.getProduto().calcularPreco(this.getQtde());
	}
	
	public BigDecimal calcularFrete(BigDecimal valorKg) {
		return this.getProduto().calcularFrete(valorKg, this.getQtde());
	}

}