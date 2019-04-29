package Telas;

import DAO.UsuarioDAO;
import Model.Usuario;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class LayoutCadastroFuncionario extends JFrame{
    private JFrame framePrincipal;//tela principal
    JTextField txtNome, txtLogin, txtSenha;
    JLabel lblNome, lblLogin, lblSenha, lblTitulo;
    JButton btnAdd, btnReturn;
    Random rand;
    
    public LayoutCadastroFuncionario(JFrame frame){
        this.framePrincipal = frame;
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                framePrincipal.setVisible(true);
                dispose();
            }
        });
        drawGui();
    }
    public void drawGui(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//fecha apenas essa tela
        
        txtNome = new javax.swing.JTextField();
        txtLogin = new javax.swing.JTextField();
        txtSenha = new javax.swing.JTextField();
        
        lblTitulo = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        
        
        //butões
        btnReturn = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        
        //label
        lblTitulo.setFont(new java.awt.Font("Arial",0,18));
        lblNome.setText("nome:");
        lblSenha.setText("Senha");
        lblLogin.setText("login");
        
        //botoes texto
        btnReturn.setText("Retornar");
        btnAdd.setText("ADD");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(lblLogin))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(lblSenha))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(276, 276, 276)
                        .addComponent(lblNome))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(txtLogin)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnReturn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(lblTitulo)))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(43, 43, 43)
                .addComponent(lblNome)
                .addGap(18, 18, 18)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblLogin)
                .addGap(18, 18, 18)
                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSenha)
                .addGap(18, 18, 18)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnReturn))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        //------------------botoes de ação---------------
        btnAdd.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                // instanciando a classe Usuario do pacote modelo e criando seu objeto usuarios
                rand = new Random();
                int valor = rand.nextInt(10);
                Usuario usuarios = new Usuario();
                usuarios.setNome(txtNome.getText());
                usuarios.setLogin(txtLogin.getText());
                usuarios.setSenha(Integer.parseInt(txtSenha.getText()));
                usuarios.setId(valor);

                // fazendo a validação dos dados
                if ((txtNome.getText().isEmpty()) || (txtLogin.getText().isEmpty()) || (txtSenha.getText().isEmpty())) {
                   JOptionPane.showMessageDialog(null, "Os campos não podem retornar vazios");
                }
                else {

                    // instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
                    UsuarioDAO dao = new UsuarioDAO();
                    dao.Add(usuarios);
                    JOptionPane.showMessageDialog(null, "Usuário "+txtNome.getText()+" inserido com sucesso! ");
                }
                dispose();
                framePrincipal.setVisible(true);
            }
        });//fim metodo de add
        btnReturn.addMouseListener(new MouseAdapter() {//add de evento do clique
        	@Override
		public void mouseClicked(MouseEvent evt) {
			dispose();
                        framePrincipal.setVisible(true);
		}
	});
        pack();
        setLocationRelativeTo(null);
    }
}
