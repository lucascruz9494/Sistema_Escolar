package dao;
import java.sql.Connection;
import java.sql.DriverManager;
public class Conexao {	
		public static Connection conector() {
			java.sql.Connection conexao = null;
			String driver = "org.postgresql.Driver";			
			//armazenando informações referente ao banco
			String url = "jdbc:postgresql://localhost:5433/posjava";
			String user = "postgres";
			String password = "admin";			
			//Estabelecendo a conexão com o banco de dados
			try {
				Class.forName(driver);
				conexao = DriverManager.getConnection(url, user, password);
				return conexao;				
			} catch (Exception e) {
				// TODO: handle exception
				return null;
			}
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		conector();
	}
}
