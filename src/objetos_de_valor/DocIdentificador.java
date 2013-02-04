package objetos_de_valor;

public abstract class DocIdentificador {

	private String valor;
	
	public DocIdentificador(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}
	
	public abstract boolean validar();
	
	public final boolean equals(Object obj){
		if (obj == null || !(obj instanceof DocIdentificador)){
			throw new IllegalArgumentException("O parametro deve ser uma instancia de DocIdentificador");
			}
		DocIdentificador docIdentificador = (DocIdentificador) obj;
		return this.getValor().equals(docIdentificador.getValor());
	}
	
	public final int hashCode(){
		int hash = 9;
		hash = 25 * hash + this.getValor().hashCode();
		return hash;
	}

}