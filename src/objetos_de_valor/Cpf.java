package objetos_de_valor;

public class Cpf extends DocIdentificador {

	public Cpf(String valor) {
		super(valor);
	}

	@Override
	public boolean validar() {
		if (this.getValor().length() != 11){
			return false;
		}
		return true;
	}

}
