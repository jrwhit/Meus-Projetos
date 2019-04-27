package conexao;

// faz as importações de classes necessárias para o funcionamento do programa 
import java.sql.Connection; 
// conexão SQL para Java 
import java.sql.DriverManager; 
// driver de conexão SQL para Java 
import java.sql.SQLException; 
// classe para tratamento de exceções 
public class ConnectionFactory {
     public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/kieRi4AcZY?useTimezone=true&serverTimezone=UTC","kieRi4AcZY","uPlyttrk5w");
	}         
	catch(SQLException excecao) {
            throw new RuntimeException(excecao);
	}
     }
}