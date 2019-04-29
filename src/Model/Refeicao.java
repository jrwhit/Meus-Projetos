package Model;

import java.util.ArrayList;
import java.util.List;

public class Refeicao {
    private String nome;
    private String tamanho;
    private String categoria;
    private double preco;
    private boolean status;
    private boolean choiceStatus;
    private Refeicao refe;
    private List<String> ingredientes = new ArrayList<String>();
    
    //construtor
    public Refeicao(String nome, double preco, boolean status, boolean choiceStatus){
        this.nome =  nome;
        this.preco = preco;
        this.status = status;
        this.choiceStatus = choiceStatus;
    }
    public Refeicao(Refeicao refe){
        this.refe = refe;
    }
    public void setIngrediente(String ingredientes){
        this.ingredientes.add(ingredientes);
    }
    public String getIngredientes(){
        String text="";
        for(String refe : ingredientes){
            text += refe+"<BR/>";
        }
        return text;
    }
     //get e set status choice
    public boolean isChoiceStatus() {
        return choiceStatus;
    }
    public void setChoiceStatus(boolean choiceStatus) {
        this.choiceStatus = choiceStatus;
    }
    
    //Get e set tamanho
    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    } 
    
    //get e set Nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //get e set Preco
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    //get e set Status
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    //serve para mostrar o nome na jlist
    @Override
    public String toString(){
        return getNome();
    }//fim metodo toString
}//fim classe refeicao