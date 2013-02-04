package objetos_de_referencia;

public abstract class ObjetoDominio {
	private long codigo;
	
	ObjetoDominio(long codigo){
		this.codigo = codigo;
	}

	public long getCodigo() {
		return codigo;
	}
	
	public final boolean equals(Object obj){
		return super.equals(obj);
	}
	
	public final int hashCode(){
		return super.hashCode();
	}
}
