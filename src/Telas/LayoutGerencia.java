package Telas;

import Model.Bebida;
import Model.Categoria;
import Model.Hambuguer;
import Model.Pizza;
import Model.Refeicao;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

public class LayoutGerencia extends JFrame implements Categoria {
    //var de layout
    private javax.swing.JTabbedPane myTabbed;
    private javax.swing.JPanel panelCentral, panelList;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JButton btnAdd, btnBuscar;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JScrollPane scrollList;
    private javax.swing.JList listRefeicao;
    
    //listas para armazenamento
    private List<Bebida> listBebida;
    private List<Pizza> listPizza;
    private List<Hambuguer> listHambuger;
    
    public static void main(String[] args){
        LayoutGerencia teste = new LayoutGerencia();
    }
    //construtor
    public LayoutGerencia(){
        drawGui();
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    public void drawGui(){
        //inicializaçao das variaveis
        myTabbed = new javax.swing.JTabbedPane();
        panelCentral = new javax.swing.JPanel();
        labelTitle = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        panelList = new javax.swing.JPanel();
        scrollList = new javax.swing.JScrollPane();
        listRefeicao = new javax.swing.JList();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);//NAO FECHAR O APP  
        setBounds(0, 0, (int) (Math.floor(1024/1.5)-16), (int) (Math.floor(600/1.5))-39);//configuração das dismensões da tela
        
        //titulo para o jpanel
        labelTitle.setText("Bem vindo + \"Nome Funcionário\"");

        btnAdd.setText("Add");

        btnBuscar.setText("Buscar");
        
        //lista para itens
        DefaultListModel<String> modeloPizza = new DefaultListModel<String>();
        listRefeicao = new JList(modeloPizza);
            //Elementos
        modeloPizza.add(0, "1");
        modeloPizza.add(1, "2");
        modeloPizza.add(2, "3");
        modeloPizza.add(3, "4");
        
            //configuração da lista
        scrollList.setViewportView(listRefeicao);
        
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(panelList);
        panelList.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollList, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                )
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollList, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addContainerGap())
        );
        //configuraçao do layou 
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(panelCentral);
        panelCentral.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(labelTitle))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addGap(28, 28, 28)
                                .addComponent(btnBuscar)
                                .addGap(18, 18, 18)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitle)
                .addGap(18, 18, 18)
                .addComponent(panelList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnBuscar)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        //configuraçao do tabbed
        myTabbed.addTab("tab1", panelCentral);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myTabbed, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myTabbed, javax.swing.GroupLayout.Alignment.TRAILING)
        );
    }

    @Override
    public void setCategoriaBebida() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCategoriaPizza() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCategoriaHambuguer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getCategoria() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
