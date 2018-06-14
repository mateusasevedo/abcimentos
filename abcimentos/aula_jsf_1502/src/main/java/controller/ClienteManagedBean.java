package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import beans.Cliente;
import camadabanco.ClienteDAO;
import camadabanco.ProdutoDAO;

@ManagedBean(name="clientebd")
@SessionScoped
public class ClienteManagedBean {
	private List<Cliente> clientes;
	private Cliente cliente;
	private int indiceEdicao;
	private String mensagem;
	private ClienteDAO clienteDAO = new ClienteDAO();

	public ClienteManagedBean() {
		this.clientes = new ArrayList<Cliente>();
		this.inicializar();
	}
	
	private void inicializar() {
		this.cliente = new Cliente();
		this.mensagem = "";
	}

	public String inserir() {
		clienteDAO.salvar(cliente);
		this.inicializar();
		return("sucesso");
}
	
	public String excluir(Cliente cliente) {
		clienteDAO.deletar(cliente);
		this.mensagem = "Excluido";
		return("sucesso");
	}
	
	public String editar(Cliente cliente) {
		this.indiceEdicao = this.clientes.indexOf(cliente);
		this.cliente = cliente;
		return("editar");
	}
	
	public String editar() {
		this.clientes.set(this.indiceEdicao, this.cliente);
		this.inicializar();
		return("principal");
	}
	public void listar() {
		clientes = clienteDAO.buscar();
	}
	
	public String principal() {
		this.inicializar();
		return "principal";
	}
	
	public List<Cliente> getClientes(){
		return(this.clientes);
	}
	
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
