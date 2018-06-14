package camadabanco;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Venda;

public class VendaDAO {
	public void salvar(Venda venda) {
		try {
			Connection conexao = BancoDados.getConexao();
			PreparedStatement ps;
			if(venda.getId() == null){
				ps= conexao.prepareStatement("INSERT INTO `venda` (`cliente`, `produto`,`quantidade`, `preco`, `pagamento`, `informacao`, `datavenda`) VALUES(?,?,?,?,?,?,?);");
			} else{
				ps = conexao.prepareStatement("update venda set cliente=?, produto=?, quantidade=?, preco=?, pagamento=?, informacao=?, datavenda=? where id=?");
				ps.setInt(8, venda.getId());
			}
			ps.setString(1, venda.getCliente());
			ps.setString(2, venda.getProduto());
			ps.setInt(3, venda.getQuantidade());
			ps.setFloat(4, venda.getValor());
			ps.setString(5, venda.getPagamento());
			ps.setString(6, venda.getDescricao());
			ps.setString(7, venda.getData());
			ps.execute();
			BancoDados.fecharConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Venda> buscar() {
		try {
			Connection conexao = BancoDados.getConexao();
			PreparedStatement ps = conexao.prepareStatement("select * from venda");
			ResultSet resultSet = ps.executeQuery();
			List<Venda> vendas = new ArrayList<>();
			while(resultSet.next()) {
				Venda venda = new Venda();
				venda.setId(resultSet.getInt("id"));
				venda.setCliente(resultSet.getString("cliente"));
				venda.setProduto(resultSet.getString("produto"));
				venda.setQuantidade(resultSet.getInt("quantidade"));
				venda.setValor(resultSet.getFloat("preco"));
				venda.setPagamento(resultSet.getString("pagamento"));
				venda.setDescricao(resultSet.getString("informacao"));
				venda.setData(resultSet.getString("datavenda"));
				vendas.add(venda);
			}
			return vendas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
		public void deletar(Venda venda) {
		try {
			Connection conexao = BancoDados.getConexao();
			PreparedStatement ps;
			ps = conexao.prepareStatement("delete from venda where id=?");
			ps.setInt(1, venda.getId());
			ps.execute();
			BancoDados.fecharConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
