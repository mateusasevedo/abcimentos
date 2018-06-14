package beans;

import java.util.Date;

public class Venda {
	private Integer id;
	private String cliente;
	private String produto;
	private int quantidade;
	private float valor;
	private String descricao;
	private String pagamento;
	private String data;
	
	public Venda() {
		this.cliente = "";
		this.produto = "";
		this.quantidade = 0;
		this.valor = 0;
		this.descricao = "";
	}

	public Venda(String cliente, String produto, int quantidade, float valor, String descricao) {
		this.cliente = cliente;
		this.produto = produto;
		this.quantidade = quantidade;
		this.valor = valor;
		this.descricao = descricao;
		}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPagamento() {
		return pagamento;
	}

	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}

	public String getData() {
		return data;
	}

	public void setData(String string) {
		this.data = string;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		if (id != other.id)
			return false;
		return true;
	}	
}
