package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import beans.Venda;
import camadabanco.ProdutoDAO;
import camadabanco.VendaDAO;

@ManagedBean(name="vendabd")
@SessionScoped
public class VendaManagedBean {
	private List<Venda> vendas;
	private Venda venda;
	private int indiceEdicao;
	private String mensagem;
	private VendaDAO vendaDAO = new VendaDAO();

	public VendaManagedBean() {
		this.vendas = new ArrayList<Venda>();
		this.inicializar();
	}
	
	private void inicializar() {
		this.venda = new Venda();
		this.mensagem = "";
	}
	public String inserir() {
		vendaDAO.salvar(venda);
		this.inicializar();
		return("sucesso");
	}
	public void listar() {
		vendas = vendaDAO.buscar();
	}

	public String excluir(Venda venda) {
		vendaDAO.deletar(venda);
		this.mensagem = "Excluido";
		return("sucesso");
	}
	
	public String editar(Venda venda) {
		this.indiceEdicao = this.vendas.indexOf(venda);
		this.venda = venda;
		return("editar");
	}
	
	public String editar() {
		this.vendas.set(this.indiceEdicao, this.venda);
		this.inicializar();
		return("principal");
	}
	
	public String principal() {
		this.inicializar();
		return "principal";
	}
	
	public List<Venda> getVendas(){
		return(this.vendas);
	}
	
	public void setVenda(List<Venda> vendas) {
		this.vendas = vendas;
	}
	
	public Venda getVenda() {
		return venda;
	}

	public void setProduto(Venda venda) {
		this.venda = venda;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}