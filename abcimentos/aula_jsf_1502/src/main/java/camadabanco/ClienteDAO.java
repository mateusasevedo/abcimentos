package camadabanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Cliente;
import beans.Produto;

public class ClienteDAO {

	public void salvar(Cliente cliente) {
		try {
			Connection conexao = BancoDados.getConexao();
			PreparedStatement ps;
			if(cliente.getId()== null) {
				ps = conexao.prepareStatement("INSERT INTO `pessoa` (`nome`, `cpf`, `cnpj`,`endereco`, `bairro`, `cidade`, `estado`, `telefone`, `telefone1`, `email`, `informacao`) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
			} else{
				ps = conexao.prepareStatement("update pessoa set nome=?, cpf=?, cnpj=?,endereco=?, bairro=?, cidade=?, estado=?, telefone=?, telefone1=?, email=?, informacao=? where id=?");
				ps.setInt(12, cliente.getId());
			}
			ps.setString(1, cliente.getNome());
			ps.setInt(2, cliente.getCpf());
			ps.setInt(3, cliente.getCnpj());
            ps.setString(4, cliente.getEndereco());
            ps.setString(5, cliente.getBairro());
            ps.setString(6, cliente.getCidade());
            ps.setString(7, cliente.getEstado());
            ps.setInt(8, cliente.getTelefone1());
            ps.setInt(9, cliente.getTelefone2());
            ps.setString(10, cliente.getEmail());
            ps.setString(11,cliente.getMensagem());
			ps.execute();
			BancoDados.fecharConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Cliente> buscar() {
		try {
			Connection conexao = BancoDados.getConexao();
			PreparedStatement ps = conexao.prepareStatement("select * from pessoa");
			ResultSet resultSet = ps.executeQuery();
			List<Cliente> clientes = new ArrayList<>();
			while(resultSet.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(resultSet.getInt("id"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setCpf(resultSet.getInt("cpf"));
				cliente.setCnpj(resultSet.getInt("cnpj"));
				cliente.setEndereco(resultSet.getString("endereco"));
				cliente.setBairro(resultSet.getString("bairro"));
				cliente.setCidade(resultSet.getString("cidade"));
				cliente.setEstado(resultSet.getString("estado"));
				cliente.setTelefone1(resultSet.getInt("telefone"));
				cliente.setTelefone2(resultSet.getInt("telefone1"));
				cliente.setEmail(resultSet.getString("email"));
				cliente.setMensagem(resultSet.getString("informacao"));
				clientes.add(cliente);
			}
			return clientes;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public void deletar(Cliente cliente) {
		try {
			Connection conexao = BancoDados.getConexao();
			PreparedStatement ps;
			ps = conexao.prepareStatement("delete from pessoa where id=?");
			ps.setInt(1, cliente.getId());
			ps.execute();
			BancoDados.fecharConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
