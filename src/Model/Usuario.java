
package Model;

public class Usuario {
    private String nome, login;
    private int senha, id;
    
    public Usuario(){
    }
    public Usuario(String nome, String login, int senha){
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    
}