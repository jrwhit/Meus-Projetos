
package Telas;

import java.awt.Choice;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;

public class LayoutCadastroItens extends JFrame implements ItemListener {
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBusca;
    private javax.swing.JButton btnReturn;
    private java.awt.Choice choiceCategoria;
    private java.awt.Choice choiceTamanho;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblIngrediente;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JList listIngredientes;
    private javax.swing.JScrollPane scrollPaneListIngrediente;
    private javax.swing.JTextField txtBusca;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPreço;
    
    public static void main(String[] args){
        LayoutCadastroItens itens =  new LayoutCadastroItens();

    }
    public Choice getChoiceTamanho(){
        return choiceTamanho;
    }
    public Choice getChoiceCategoria(){
        return choiceCategoria;
    }
    public LayoutCadastroItens(Choice choice){
        this.choiceCategoria = choice;
    }
    public LayoutCadastroItens(){
        drawGui();//metodo para desenhar a tela
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);//nao fechar o app
        pack();//configura para cabir todos os componentes
        setLocationRelativeTo(null);//centraliza a tela
        setVisible(true);//visualizar tela
        
    }
    public void drawGui(){
        jPanel3 = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblPreco = new javax.swing.JLabel();
        txtPreço = new javax.swing.JTextField();
        lblIngrediente = new javax.swing.JLabel();
        scrollPaneListIngrediente = new javax.swing.JScrollPane();
        listIngredientes = new javax.swing.JList();
        lblCategoria = new javax.swing.JLabel();
        choiceCategoria = new java.awt.Choice();
        jLabel1 = new javax.swing.JLabel();
        choiceTamanho = new java.awt.Choice();
        btnBusca = new javax.swing.JButton();
        txtBusca = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        
        //============declaraçao de texto===============
        lblCategoria.setText("categoria");
        jLabel1.setText("Tamanho");
        btnBusca.setText("Busca");
        btnAdd.setText("+");
        btnReturn.setText("<-");
        lblNome.setText("Nome");
        lblPreco.setText("Preço");
        lblIngrediente.setText("Ingredientes");
            //choices
        choiceTamanho.add("Pequena");
	choiceTamanho.add("Média");
	choiceTamanho.add("Grande");
        choiceTamanho.setEnabled(false);
        choiceCategoria.add("Bebida");
        choiceCategoria.add("Pizza");
        choiceCategoria.add("Hambuguer");
        choiceCategoria.addItemListener(this);
        //lista
        listIngredientes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        scrollPaneListIngrediente.setViewportView(listIngredientes);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblIngrediente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBusca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(scrollPaneListIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblPreco)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPreço, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblCategoria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(choiceCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(22, 22, 22)
                                        .addComponent(choiceTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(btnAdd))))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnReturn)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(btnReturn)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNome)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblPreco)
                                    .addComponent(txtPreço, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblIngrediente)
                                    .addComponent(btnBusca)
                                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(scrollPaneListIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(choiceCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCategoria)))
                            .addComponent(choiceTamanho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(getChoiceCategoria().getSelectedItem() == "Pizza"){
            getChoiceTamanho().setEnabled(true);
        }else{
            getChoiceTamanho().setEnabled(false);
        }
    }
}