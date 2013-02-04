package objetos_de_valor;

public class Cnpj extends DocIdentificador {

	public Cnpj(String valor) {
		super(valor);
	}

	@Override
	public boolean validar() {
		if (this.getValor().length() != 14){
			return false;
		}
		return true;
	}

}
