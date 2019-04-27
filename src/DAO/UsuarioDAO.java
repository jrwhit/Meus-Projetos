package DAO;

import Model.Usuario;
import java.sql.*;
import conexao.ConexaoDataBase;
import java.sql.PreparedStatement;
import conexao.ConnectionFactory;

public class UsuarioDAO {
    private Connection connection;
    String nome;
    String login;
    int senha;
    int id;
    public UsuarioDAO(){
        
        this.connection = new ConnectionFactory().getConnection();
    }
    public void Add(Usuario user){
        String sql = "INSERT INTO cliente(NOM_CLIENTE,LOGIN_CLIENTE,SENHA_CLIENTE) VALUES(?,?,?)";
        
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getLogin());
            stmt.setString(3, Integer.toString(user.getSenha()));
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
    }
}