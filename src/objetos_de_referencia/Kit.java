package objetos_de_referencia;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

public class Kit extends Produto {

	private BigDecimal ajustePreco;
	private ArrayList<Produto> filhos = new ArrayList<Produto>();
	
	public Kit(long codigo, String nome, String descricao, BigDecimal pesoEmKg, BigDecimal ajustePreco) {
		super(codigo, nome, descricao, pesoEmKg);
		this.ajustePreco = ajustePreco;
	}

	@Override
	public BigDecimal getPreco() {
		BigDecimal preco = new BigDecimal("0.00");
		for (Produto produto: filhos){
			preco = preco.add(((ProdutoSimples)produto).getPreco());
		}
		return preco.subtract(preco.multiply(this.getAjustePreco())).setScale(2, BigDecimal.ROUND_CEILING);
	}
	
	public void adicionarFilho(Produto filho){
		this.filhos.add(filho);
	}
	
	public void removerFilho(Produto filho) {
		this.filhos.remove(filho);
	}
	
	public Iterator<Produto> getFilhos(){
		return this.filhos.iterator();
	}

	public BigDecimal getAjustePreco() {
		return ajustePreco;
	}

	public void setAjustePreco(BigDecimal ajustePreco) {
		this.ajustePreco = ajustePreco;
	}

}
