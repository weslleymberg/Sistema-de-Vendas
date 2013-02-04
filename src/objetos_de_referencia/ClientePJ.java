package objetos_de_referencia;

import java.math.BigDecimal;

import objetos_de_valor.Cnpj;

public class ClientePJ extends Cliente {

	private Cnpj cnpj;
	
	public ClientePJ(long codigo, String nome, String endereco, String telefone, BigDecimal porcentoDesconto, Cnpj cnpj) {
		super(codigo, nome, endereco, telefone, porcentoDesconto);
		this.setCnpj(cnpj);
		
	}

	public String getCnpj() {
		return cnpj.getValor();
	}

	public void setCnpj(Cnpj cnpj) {
		if (cnpj.validar()){
			this.cnpj = cnpj;
		} else {
			throw new IllegalArgumentException("CNPJ Invalido");
		}
	}
	

}
