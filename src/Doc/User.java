package Doc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * É a classe para vincular o banco de dados, como verificar e validar se o usuario esta registrado.
 */
public class User {
    /**
     * Esse é o metodo para a conexão com o banco de dados.
     * @return conn
     */
    public Connection ConectarBD(){
        Connection conn = null;
        try{
            Class.forName("com.mysql.Driver.Manager");
            String url = "jdbc::mysql://127.0.0.1/test?user=lopes&password=123";
            conn = DriverManager.getConnection(url);
        }catch (Exception e){ }
        return conn;
    }
        public String nome="";
        public boolean result=false;

        /**
         * É o metodo para validar o login e a senha do usuario, verificar o registro.
         * @param login  O login do usuario
         * @param senha senha do usuario 
         * @return resultado do filtro/procura do usuario do sistema.
         */
        public boolean verificiarUsuario(String login, String senha){
            String sql ="";
            Connection conn = ConectarBD();
            //INSTRUÇÃO SQL
            sql += "select nome from usuarios ";
            sql +="where login='"+login+"' ";
            sql += "and senha='"+senha+"'";
            try{
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if(rs.next()){
                    result = true;
                    nome = rs.getString("nome");
                }
            }catch (Exception e){ }
            return result;
        }

}