package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ConexaoDataBase {
    //Variaveis de conexao com o banco de dados
    public Connection con;
    public Statement start;
    public ResultSet result;
    
    //argumentos de driver para conexao
    //&useSSL=false
    String url = "jdbc:mysql://remotemysql.com:3306/kieRi4AcZY?useTimezone=true&serverTimezone=UTC";
    String user = "kieRi4AcZY";
    String senha = "uPlyttrk5w";
    String driver = "com.mysql.cj.jdbc.Driver";
    
    public void openConnectionMySQL(){
        try{
            //Class.forName(driver).newInstance();
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,senha);
            start = con.createStatement();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao tentar conectar","ERRO",JOptionPane.ERROR_MESSAGE,null);               
            
            e.printStackTrace();
        }
    }
}
