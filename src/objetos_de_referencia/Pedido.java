package objetos_de_referencia;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Pedido extends ObjetoDominio {
	
	public static int STATUS_EMITIDO = 0;
	public static int STATUS_CONFIRMADO = 1;
	public static int STATUS_ENTREGANDO = 2;
	public static int STATUS_CONCLUIDO = 3;
	public static int STATUS_CANCELADO = 4;
	
	private Cliente cliente;
	private String enderecoEntrega;
	private BigDecimal valorFreteKg;
	private Date dataCancelamento;
	private Date dataConclusao;
	private Date dataCriacao = new Date();
	private Date dataConfirmacao;
	private int status = 0;
	private long codigoProximoItem = 0;
	Map<Produto, Item> itens = new HashMap<Produto, Item>();

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

	public Date getDataCancelamento() {
		return (Date) dataCancelamento.clone();
	}

	public Date getDataConclusao() {
		return (Date) dataConclusao.clone();
	}

	public Date getDataCriacao() {
		return (Date) dataCriacao.clone();
	}

	public Date getDataConfirmacao() {
		return (Date) dataConfirmacao.clone();
	}

	public int getStatus() {
		return status;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public Iterator<Item> getTodosItens() {
		return this.itens.values().iterator();
	}
	
	public Item getItem(Produto produto) {
		return this.itens.get(produto);
	}
	
	public void atualizarItem(Produto produto, BigDecimal qtde) {
		if (qtde.compareTo(new BigDecimal("0")) <= 0){
			this.itens.remove(produto);
		} else {
			Item item = new Item(this.codigoProximoItem, produto, qtde);
			this.itens.put(produto, item);
			this.codigoProximoItem += 1;
		}
	}
	
	public void confirmar() {
		Iterator<Item> iterator = this.getTodosItens();
		while (iterator.hasNext()) {
			iterator.next().confirmar();
		}
		this.dataConfirmacao = new Date();
		this.status = Pedido.STATUS_CONFIRMADO;
	}
	
	public void cancelar() {
		if (this.getStatus() == Pedido.STATUS_CONCLUIDO) {
			throw new IllegalStateException("Impossível cancelar! Pedido já foi entregue.");
		} else {
			if (this.getStatus() == Pedido.STATUS_ENTREGANDO) {
				throw new IllegalStateException("Impossivel cancelar! Produto já está sendo entregue.");
			} else {
				this.status = Pedido.STATUS_CANCELADO;
				this.dataCancelamento = new Date();
			}
		}
	}
	
	public void entregar(Produto produto, BigDecimal qtde){
		if (this.getStatus() == Pedido.STATUS_CONCLUIDO){
			throw new IllegalArgumentException("Este pedido já foi entregue");
		} else {
			this.itens.get(produto).setQtdeEntregue(qtde);
			for (Item item: itens.values()){
				if (!(item.concluido())) {
					this.status = Pedido.STATUS_ENTREGANDO;
					break;
				} else {
					this.status = Pedido.STATUS_CONCLUIDO;
				}
			}
		}
	}
	
	public BigDecimal calcularTotalItens() {
		BigDecimal totalItens = new BigDecimal("0");
		for (Item item: this.itens.values()) {
			totalItens = totalItens.add(item.calcularTotal());
		}
		return totalItens;
	}	
	
	public BigDecimal calcularFrete() {
		BigDecimal totalFrete = new BigDecimal("0");
		for (Item item: this.itens.values()) {
			totalFrete = totalFrete.add(item.calcularFrete(this.getValorFreteKg()));
		}
		return totalFrete;
	}
	
	public BigDecimal calcularTotalGeral() {
		BigDecimal totalGeral = new BigDecimal("0");
		totalGeral = this.calcularTotalItens().add(this.calcularFrete());
		return totalGeral.subtract(totalGeral.multiply(this.getCliente().getPorcentoDesconto())).setScale(2);
	}

}
