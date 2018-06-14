/*
0 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mateus Asevedo
 */
@ManagedBean(name = "usuario")
@SessionScoped
public class Usuario {
	private String login;
	private String senha;
	private String mensagem;
	
	public Usuario() {
		this.inicializar();
	}

	private void inicializar() {
		this.login = "";
		this.senha = "";
		this.mensagem = "";
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String autenticar() {
		if (this.login.equals("mateus") && this.senha.equals("123")) {
			FacesContext.getCurrentInstance().getExternalContext().
            	getSessionMap().put("Usuario", this);
			return ("sucesso");
		}
		this.mensagem = "Login e/ou senha invalidos!";
		return ("falha");
	}

	public String logout() {
		FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession sessao = (HttpSession)fc.getExternalContext().
                getSession(false);
        sessao.invalidate();
		this.inicializar();
		return("logout");
	}

	public String principal() {
		return("principal");
	}
	public String cadcliente() {
		return("cadcliente");
	}
	public String cadproduto() {
		return("cadproduto");
	}
	public String listproduto() {
		return("listproduto");
	}
	public String listcliente() {
		return("listcliente");
	}
	public String listvenda() {
		return("listvenda");
	}
	public String cadvenda() {
		return("cadvenda");
	}
	
	public String conv_val() {
		return("conv_val");
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha
	 *            the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

}