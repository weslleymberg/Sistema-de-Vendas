package objetos_de_referencia;

import java.math.BigDecimal;

public abstract class Cliente extends ObjetoDominio {
	private String nome;
	private String endereco;
	private String telefone;
	private BigDecimal porcentoDesconto;
	
	Cliente(long codigo, String nome, String endereco, String telefone, BigDecimal porcentoDesconto){
		super(codigo);
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.porcentoDesconto = porcentoDesconto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public BigDecimal getPorcentoDesconto() {
		return porcentoDesconto;
	}

	public void setPorcentoDesconto(BigDecimal porcentoDesconto) {
		this.porcentoDesconto = porcentoDesconto;
	}
	
	public BigDecimal aplicarDesconto(BigDecimal valor){
		return valor.subtract(valor.multiply(this.getPorcentoDesconto())).setScale(2, BigDecimal.ROUND_CEILING);
	}
	
}
