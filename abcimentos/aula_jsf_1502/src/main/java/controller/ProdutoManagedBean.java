package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import beans.Produto;
import camadabanco.ProdutoDAO;

@ManagedBean(name="produtobd")
@SessionScoped
public class ProdutoManagedBean {
	private List<Produto> produtos;
	private Produto produto;
	private int indiceEdicao;
	private String mensagem;
	private ProdutoDAO produtoDAO = new ProdutoDAO();

	public ProdutoManagedBean() {
		this.produtos = new ArrayList<Produto>();
		this.inicializar();
	}
	
	private void inicializar() {
		this.produto = new Produto();
		this.mensagem = "";
	}	
	public String inserir() {
			produtoDAO.salvar(produto);
			this.inicializar();
			return("sucesso");
	}
	public void listar() {
		produtos = produtoDAO.buscar();
	}
	
	public String excluir(Produto produto) {
		produtoDAO.deletar(produto);
		this.mensagem = "Excluido";
		return("sucesso");
	}
	
	public String editar(Produto produto) {
		this.indiceEdicao = this.produtos.indexOf(produto);
		this.produto = produto;
		return("editar");
	}
	
	public String editar() {
		produtoDAO.salvar(produto);
		this.inicializar();
		return("sucesso");
	}
	public String cadastrarprod() {
		return ("cadastro");
	}	
	public String principal() {
		this.inicializar();
		return "principal";
	}
	
	public List<Produto> getProdutos(){
		return(this.produtos);
	}
	
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
