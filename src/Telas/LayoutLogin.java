package Telas;

import conexao.ConexaoDataBase;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LayoutLogin extends JFrame{
    javax.swing.JTextField txtLogin, txtSenha;
    javax.swing.JLabel lblLogin, lblSenha, lblIcon;
    javax.swing.JButton btnConfirmar,btnAdd;
    ConexaoDataBase objCon;
    public static void main(String[] args){
        LayoutLogin login = new LayoutLogin();
    }
    public LayoutLogin(){
        drawWindow();
        setLocationRelativeTo(null);
        setVisible(true);
        
        objCon = new ConexaoDataBase();
    }
    private void drawWindow(){
        //txt
        txtLogin = new javax.swing.JTextField();
        txtSenha = new javax.swing.JTextField();
        //lbl
        lblLogin = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        lblIcon =  new javax.swing.JLabel();
        //button
        btnConfirmar = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        
        //anexando imagem ao label
        ImageIcon icon = criarImageIcon("/image/latraviata.jpeg","icon");
        lblIcon.setIcon(icon);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblLogin.setText("Login:");

        lblSenha.setText("Senha:");

        btnConfirmar.setText("Entrar");
        btnAdd.setText("ADD");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtSenha)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(181, 181, 181))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(223, 223, 223))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblLogin)
                        .addGap(284, 284, 284))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblSenha)
                        .addGap(281, 281, 281))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(lblLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(lblSenha)
                .addGap(3, 3, 3)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar)
                    .addComponent(btnAdd))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        
        btnConfirmar.addMouseListener(new MouseAdapter() {//add de evento do clique
            @Override
            public void mouseClicked(MouseEvent evt) {
                try{
                    String loginDig = txtLogin.getText().trim();
                    String senhaDig = txtSenha.getText().trim();
                    objCon.openConnectionMySQL();
                    objCon.start = objCon.con.createStatement();
                    String SQL = "SELECT * FROM cliente where LOGIN_CLIENTE='" + loginDig + "'" + "and SENHA_CLIENTE='" + senhaDig + "'";
                    objCon.result = objCon.start.executeQuery(SQL);
                    objCon.result.first();
                    
                    String loginBanco = objCon.result.getString("LOGIN_CLIENTE").trim();
                    String senhaBanco = objCon.result.getString("SENHA_CLIENTE").trim();
                                      
                    if(loginDig.equals(loginBanco)
                        && senhaDig.equals(senhaBanco))
                    {
                        JOptionPane.showMessageDialog(null, "Usuario correto");
                        LayoutCliente tela = new LayoutCliente(LayoutLogin.this);
                        tela.setVisible(true);
                        setVisible(false);
                    }else{
                        JOptionPane.showMessageDialog(null, "Usuario incorreto");
                    } 
                    
                    
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, e);
                }
                
            }
	});
        btnAdd.addMouseListener(new MouseAdapter() {//add de evento do clique
            @Override
            public void mouseClicked(MouseEvent evt) {
                LayoutCadastroFuncionario func = new LayoutCadastroFuncionario(LayoutLogin.this);
                func.setVisible(true);
                setVisible(false);
            }
	});
        
        pack();
    }
    public ImageIcon criarImageIcon(String caminho, String descricao) {
        java.net.URL imgURL = getClass().getResource(caminho);
	if (imgURL != null) {
            return new ImageIcon(imgURL, descricao);
	} else {
            JOptionPane.showMessageDialog(null,"Não foi possível carregar o arquivo de imagem: " + caminho);
            return null;
	}
    }
}