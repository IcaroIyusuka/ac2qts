package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class User {
	public Connection conectarBD() {//1/
		
		Connection conn = null;//2/
		
		try {//3/
			
			Class.forName("com.mysql.Driver.Manager").newInstance();
			String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
			conn = DriverManager.getConnection(url);
			
		     }catch (Exception e) { }//4 e 5/
		
		return conn;}//6
	
		public String nome="";//7/
		public boolean result = false; //7/
	
		public boolean verificarUsuario(String login, String senha) {//8/
			//9/
			String sql="";
			Connection conn = conectarBD();
			
			//instruçõres SQL
			sql += "select nome from usuario";
			sql += "where login =" + "'" + login + "'"; 
			sql += "and senha =" + "'" + senha + "';";
			//9/
			
			try {//10/
				
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				
				if(rs.next()) {//15/
					result = true;//16/
					nome = rs.getString("nome");//17/
					
				}
				
			}catch (Exception e) {}//11 e 12/
			
			return result;}//13 e 14/
	}//fim classe
