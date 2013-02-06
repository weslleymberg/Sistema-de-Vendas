package objetos_de_referencia;

import java.math.BigDecimal;
import java.util.HashMap;

public class Pedido extends ObjetoDominio {
	
	private Cliente cliente;
	private String enderecoEntrega;
	private BigDecimal valorFreteKg;
	HashMap<Produto, Item> itens = new HashMap<Produto, Item>();

	public Pedido(long codigo, Cliente cliente, String enderecoEntrega, BigDecimal valorFreteKg) {
		super(codigo);
		this.cliente = cliente;
		this.enderecoEntrega = enderecoEntrega;
		this.valorFreteKg = valorFreteKg;
		
	}

	public String getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(String enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	public BigDecimal getValorFreteKg() {
		return valorFreteKg;
	}

	public void setValorFreteKg(BigDecimal valorFreteKg) {
		this.valorFreteKg = valorFreteKg;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public Item getItem(Produto produto) {
		return itens.get(produto);
	}
	
	public void atualizarItem(Produto produto, BigDecimal qtde) {
		if (qtde.compareTo(new BigDecimal("0")) <= 0){
			itens.remove(produto);
		} else {
			Item item = new Item(1234, produto, qtde);
			itens.put(produto, item);
		}
	}
	
	public BigDecimal calcularTotalItens() {
		BigDecimal totalItens = new BigDecimal("0");
		for (Item item: itens.values()) {
			totalItens = totalItens.add(item.calcularTotal());
		}
		return totalItens;
	}
	
	public BigDecimal calcularFrete() {
		BigDecimal totalFrete = new BigDecimal("0");
		for (Item item: itens.values()) {
			totalFrete = totalFrete.add(item.calcularFrete(this.getValorFreteKg()));
		}
		return totalFrete;
	}
	
	public BigDecimal calcularTotalGeral() {
		return this.calcularTotalItens().add(this.calcularFrete());
	}

}
