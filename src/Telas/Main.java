package Telas;

import Model.Bebida;
import Model.Hambuguer;
import Model.MyTableModel;
import Model.Pizza;
import Model.Refeicao;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import java.io.FileReader;
import javax.swing.JFileChooser;

public class Main extends JFrame{
    JFrame framePrincipal;
    private int indiceDaLista = 0;
    FileWriter arq;
    //Objetos pizza teste
    Pizza pizza1 = new Pizza("Presunto", 23, true, true);
    Pizza pizza2 = new Pizza("Ovo", 23, true, true);
    Pizza pizza3 = new Pizza("Frango", 23, true, true);
    Pizza pizza4 = new Pizza("Mussarela", 23, true, true);
    
    Hambuguer hb1 = new Hambuguer("X-Tudo", 10, true, false);
    Hambuguer hb2 = new Hambuguer("X-Calabresa", 9.99, true, false);
    Hambuguer hb3 = new Hambuguer("X-Frango", 9.00, true, false);
    Hambuguer hb4 = new Hambuguer("Cachorro Quente", 5.99, true, false);
    
    Bebida bd1 = new Bebida("Suco de Maracujá", 1.70, true, false);
    Bebida bd2 = new Bebida("Suco de Goiaba", 1.50, true, false);
    Bebida bd3 = new Bebida("Refrigenrante Coca-Cola", 5.00, true, false);
    Bebida bd4 = new Bebida("Refrigerante Fanta Laranja", 5.00, true, false);
    
    //Default Model
    DefaultListModel<Refeicao> modeloPizza;
    DefaultListModel<Refeicao> modeloHambuguer;
    DefaultListModel<Refeicao> modeloBebidas;
    
    JTabbedPane guias;
    //paineis para receber as listas
    JPanel panelList;
    JPanel panelHambu;
    JPanel panelTabela;
    JPanel panelBebida;
    //listas para classes
    JList listPizza;
    JList listHambuguer;
    JList listBebida;
    //Scroll para listas
    JScrollPane scrollParaListaPizza;
    JScrollPane scrollParaListaHambuguer;
    JScrollPane scrollParaListaBebidas;
    
    static MyTableModel tableData = new MyTableModel();
    JTable table = new JTable((TableModel) tableData);
    
    public Main(){
        drawGui();
    }
    public Main(JFrame frame){
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
//    public static void main(String[] args){
//         javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                new Main().setVisible(true);
//            }
//        });
//    }
    
    //metodo para ouvir o clique na lista e abrir uma nova tela referente ao indice clicado
    public void cliqueLista(JList list, DefaultListModel model){
        list.addMouseListener(new MouseAdapter() {//add de evento do clique
            @Override
            public void mouseClicked(MouseEvent evt) {
                int linha = list.locationToIndex(evt.getPoint());//determina qual celular o usuario clicou
                if(linha != -1){//Se for diferente de negativo
                    indiceDaLista = linha;;//armazena nosso clique
                }
                
                TelaMostrarRefeicao layoutDeProdutos = new TelaMostrarRefeicao(Main.this, (Refeicao) model.get(linha));//abre o layout da pizza
                layoutDeProdutos.setVisible(true);
                setVisible(false);
            }
        });
    }//fim metodo cliqueLista
    private void drawList(JList list, JPanel panel, GroupLayout layout, JScrollPane scroll){
        DefaultListModel<String> modelo = new DefaultListModel<String>();
        list = new JList(modelo);
        modelo.add(0,"calabresa");
        modelo.add(1,"frango");
        modelo.add(2,"queijo");
        modelo.add(3,"queijo");
        modelo.add(4,"queijo");
        modelo.add(5,"queijo");
        modelo.add(6,"queijo");
        modelo.add(7,"queijo");
        modelo.add(8,"queijo");
        modelo.add(9,"queijo");
        modelo.add(10,"queijo");
        modelo.add(11,"queijo");
        modelo.add(12,"queijo");
        modelo.add(13,"queijo");
        modelo.add(14,"queijo");
        modelo.add(15,"queijo");
        modelo.add(16,"queijo");
        
        scroll = new JScrollPane();
        scroll.setViewportView(list);
        //setando configuração para a list
        layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
        );
    }
    private void drawGui(){
        //Create and set up the content pane.
        setTitle("LaTraviata");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//fecha apenas essa tela
        
        //tabbedPane
        guias = new JTabbedPane(JTabbedPane.TOP);
        guias.setBounds(0, 0, (int) (Math.floor(1024/1.5)-16), (int) (Math.floor(600/1.5))-39);
        guias.setOpaque(true); //content panes must be opaque
        setContentPane(guias);
        
        //Japnel
        panelList = new JPanel(new BorderLayout());
        panelTabela = new JPanel(new BorderLayout());
        panelHambu = new JPanel(new BorderLayout());
        panelBebida = new JPanel(new BorderLayout());
        
        //drawList(listBebida, panelBebida, drinkLayout, scrollForDrink);
        
        //lista para pizzas
        modeloPizza = new DefaultListModel<Refeicao>();
        listPizza = new JList(modeloPizza);
            //Elementos pizza
        modeloPizza.addElement(pizza1);
        modeloPizza.addElement(pizza2);
        modeloPizza.addElement(pizza3);
        modeloPizza.addElement(pizza4);
        
        scrollParaListaPizza = new JScrollPane();
        scrollParaListaPizza.setViewportView(listPizza);
        //setando configuração para a list
        javax.swing.GroupLayout pizzaLayout = new javax.swing.GroupLayout(panelList);
        panelList.setLayout(pizzaLayout);
        pizzaLayout.setHorizontalGroup(
            pizzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollParaListaPizza, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
        );
        pizzaLayout.setVerticalGroup(
            pizzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollParaListaPizza, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
        );
        
        //********************List for hambuguer*********
        modeloHambuguer = new DefaultListModel<Refeicao>();
        listHambuguer = new JList(modeloHambuguer);
            //Elementos hambuguer
        modeloHambuguer.addElement(hb1);
        modeloHambuguer.addElement(hb2);
        modeloHambuguer.addElement(hb3);
        modeloHambuguer.addElement(hb4);
        
        scrollParaListaHambuguer = new JScrollPane();
        scrollParaListaHambuguer.setViewportView(listHambuguer);
        //setando configuração para a list
        javax.swing.GroupLayout hambu = new javax.swing.GroupLayout(panelHambu);
        panelHambu.setLayout(hambu);
        hambu.setHorizontalGroup(
            hambu.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollParaListaHambuguer, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
        );
        hambu.setVerticalGroup(
            hambu.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollParaListaHambuguer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
        );
        
        // Lista para bebidas
        modeloBebidas = new DefaultListModel<Refeicao>();
        listBebida = new JList(modeloBebidas);
            //Elementos Bebidas
        modeloBebidas.addElement(bd1);
        modeloBebidas.addElement(bd2);
        modeloBebidas.addElement(bd3);
        modeloBebidas.addElement(bd4);
        
        scrollParaListaBebidas = new JScrollPane();
        scrollParaListaBebidas.setViewportView(listBebida);
        //setando configuração para a list
        GroupLayout layoutBebida = new GroupLayout(panelBebida);
        panelBebida.setLayout(layoutBebida);
        layoutBebida.setHorizontalGroup(
            layoutBebida.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollParaListaBebidas, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
        );
        layoutBebida.setVerticalGroup(
            layoutBebida.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollParaListaBebidas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
        );
        
        //Table
        table.setPreferredScrollableViewportSize(new Dimension(300, 70));
        table.setFillsViewportHeight(true);
        panelTabela.add(new JScrollPane(table), BorderLayout.CENTER);
        btnTeste.setText("GerarPedido");
        panelTabela.add(btnTeste, BorderLayout.SOUTH);

        //Display the window.
        guias.addTab("Pizza", panelList);
        guias.addTab("Hambuguer", panelHambu);
        guias.addTab("Bebidas", panelBebida);
        guias.addTab("Pedido", panelTabela);
        setBounds(100, 100, (int) (Math.floor(1024/1.5)), (int) (Math.floor(600/1.5)));
        
        //***********clique lista****************
         cliqueLista(listPizza, modeloPizza);//clique na lista de pizza
         cliqueLista(listHambuguer, modeloHambuguer);//clique na lista de hambuguers
         cliqueLista(listBebida, modeloBebidas);//clique na lista de bebidas
         this.setLocationRelativeTo(null);
         
         //*************Gerar Pedido*******************
         btnTeste.addMouseListener(new MouseAdapter() {//add de evento do clique
        	@Override
		public void mouseClicked(MouseEvent evt) {
                    try {
                        arq = new FileWriter("C:\\Users\\Public\\Documents\\arquivo.txt");
                    
                        PrintWriter gravarArq = new PrintWriter(arq);

                        gravarArq.printf("+--Pedido--+%n");

                        gravarArq.printf("| %2S |%n", tableData.gerarPedido());

                        gravarArq.printf("+-------------+%n");
                        arq.close();
                        
                        arquivo = new File("C:\\Users\\Public\\Documents\\arquivo.txt");
                        String linha = "";
                        fr  = new FileReader(arquivo);
                        br = new BufferedReader(fr);
                        while (br.ready()) {
                            linha += br.readLine();
                        }   
                        br.close();
                        fr.close();
                        JOptionPane.showMessageDialog(null, linha, "Pedido", JOptionPane.OK_OPTION);
                    } catch (FileNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, ex, "Erro", JOptionPane.OK_OPTION);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, ex, "Erro", JOptionPane.OK_OPTION);
                    }
		}
	});
    }
    javax.swing.JButton btnTeste = new javax.swing.JButton();
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel painelInferior;
    BufferedReader buff;
    JFileChooser fc;
    File arquivo;
    FileReader fr;
    BufferedReader br;
}