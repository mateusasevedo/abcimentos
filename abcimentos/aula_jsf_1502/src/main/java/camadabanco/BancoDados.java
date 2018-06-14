package camadabanco;



import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;
import com.mysql.jdbc.Statement;

public class BancoDados {
	private static Connection conexao;
	private static final String URL_CONEXAO = "jdbc:mysql://localhost/abcimentos";
	private static final String USUARIO = "root";
	private static final String SENHA = "root";
	
	public static Connection getConexao() {
		if(conexao==null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conexao = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conexao;
	}
	
	public static void fecharConexao() {
		if(conexao !=null) {
			try {
				conexao.close();
				conexao=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}	
}
