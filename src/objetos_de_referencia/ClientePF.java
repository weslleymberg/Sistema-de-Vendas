package objetos_de_referencia;

import java.math.BigDecimal;

import objetos_de_valor.Cpf;

public class ClientePF extends Cliente {

	private Cpf cpf;
	
	public ClientePF(long codigo, String nome, String endereco, String telefone, BigDecimal porcentoDesconto, Cpf cpf) {
		super(codigo, nome, endereco, telefone, porcentoDesconto);
		this.setCpf(cpf);
	}

	public String getCpf() {
		return cpf.getValor();
	}

	public void setCpf(Cpf cpf) {
		if (cpf.validar()){
			this.cpf = cpf;
		} else {
			throw new IllegalArgumentException("CPF inválido!");
		}
	}
	

}
