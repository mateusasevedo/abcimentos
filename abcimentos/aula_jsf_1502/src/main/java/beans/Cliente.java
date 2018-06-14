package beans;

public class Cliente {
	private Integer id;
	private String nome;
	private int cpf;
	private int cnpj;
	private String endereco;
	private String cidade;
	private String bairro;
	private String estado;
	private int cep;
	private int telefone1;
	private int telefone2;
	private String email;
	private String mensagem;
	
	
	public Cliente() {
		this.nome = "";
		this.cpf = 0;
		this.cnpj = 0;
		this.endereco = "";
		this.cidade = "";
		this.bairro = "";
		this.estado = "";
		this.cep = 0;
		this.telefone1 = 0;
		this.telefone2 = 0;
		this.email = "";
		this.mensagem = "";
	}

	public Cliente(String nome, int cpf, int cnpj, String endereco, String cidade, String bairro, String estado, int cep, int telefone1, int telefone2, String email, String mensagem) {
		this.nome = nome;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.cidade = cidade;
		this.bairro = bairro;
		this.estado = estado;
		this.cep = cep;
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
		this.email = email;
		this.mensagem = mensagem;	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public int getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(int telefone1) {
		this.telefone1 = telefone1;
	}

	public int getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(int telefone2) {
		this.telefone2 = telefone2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	
}
