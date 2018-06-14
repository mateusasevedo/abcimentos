package camadabanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Produto;

public class ProdutoDAO {
	public void salvar(Produto produto) {
		try {
			Connection conexao = BancoDados.getConexao();
			PreparedStatement ps;
			if(produto.getId() == null) {
				ps = conexao.prepareStatement("INSERT INTO `mercadoria` (`nome`,`marca`,`un`,`peso`) VALUES (?,?,?,?);");
			}	else {
				ps = conexao.prepareStatement("update mercadoria set nome=?, marca=?, un=?, peso=? where id=?");
				ps.setInt(5, produto.getId());
			}
			ps.setString(1, produto.getDescricao());
			ps.setString(2, produto.getMarca());
			ps.setString(3, produto.getUnidade());
			ps.setInt(4, produto.getPeso());
			ps.execute();
			BancoDados.fecharConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Produto> buscar() {
		try {
			Connection conexao = BancoDados.getConexao();
			PreparedStatement ps = conexao.prepareStatement("select * from mercadoria");
			ResultSet resultSet = ps.executeQuery();
			List<Produto> produtos = new ArrayList<>();
			while(resultSet.next()) {
				Produto produto = new Produto();
				produto.setId(resultSet.getInt("id"));
				produto.setDescricao(resultSet.getString("nome"));
				produto.setMarca(resultSet.getString("marca"));
				produto.setUnidade(resultSet.getString("un"));
				produto.setPeso(resultSet.getInt("peso"));
				produtos.add(produto);
			}
			return produtos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public void deletar(Produto produto) {
		try {
			Connection conexao = BancoDados.getConexao();
			PreparedStatement ps;
			ps = conexao.prepareStatement("delete from mercadoria where id=?");
			ps.setInt(1, produto.getId());
			ps.execute();
			BancoDados.fecharConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
