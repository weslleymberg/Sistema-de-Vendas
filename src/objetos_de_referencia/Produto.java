package objetos_de_referencia;

import java.math.BigDecimal;

public abstract class Produto extends ObjetoDominio {

	private String nome;
	private String descricao;
	private BigDecimal pesoEmKg;
	
	public Produto(long codigo, String nome, String descricao, BigDecimal pesoEmKg) {
		super(codigo);
		this.nome = nome;
		this.descricao = descricao;
		this.pesoEmKg = pesoEmKg;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPesoEmKg() {
		return pesoEmKg;
	}

	public void setPesoEmKg(BigDecimal pesoEmKg) {
		this.pesoEmKg = pesoEmKg;
	}

	public abstract BigDecimal getPreco();
	
	final public BigDecimal calcularPreco(BigDecimal qtde){
		return qtde.multiply(this.getPreco()).setScale(2, BigDecimal.ROUND_CEILING);
	}
	
	final public BigDecimal calcularFrete(BigDecimal valorKg, BigDecimal qtde){
		return qtde.multiply(valorKg.multiply(this.getPesoEmKg())).setScale(2, BigDecimal.ROUND_CEILING);
	}

}
