package Telas;

import Model.Refeicao;
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TelaMostrarRefeicao extends JFrame{
    private JPanel panel;
    private JFrame framePrincipal;
    private Choice tamanho;
    Refeicao refe;
    
    public TelaMostrarRefeicao(JFrame f, Refeicao refe) {
        this.refe = refe;
        this.framePrincipal = f;
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                framePrincipal.setVisible(true);
                dispose();
            }
        });
	drawGuiSecundario();
    }
    public void setarChoice(Boolean boo, Choice choice){
        if(boo){
            choice.setEnabled(true);
            choice.setVisible(true);
        }else{
            choice.setEnabled(false);
            choice.setVisible(false);
        }
    }
    public void drawGuiSecundario(){
	setBounds(100, 100, (int) (Math.floor(1024/1.5)), (int) (Math.floor(600/1.5)));//aspect ratio 1.5
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//fecha apenas essa tela
	setLocationRelativeTo(null);//centraliza a tela secundária;
	toFront();//tras a nova tela para frente(empilha)
        panel = new JPanel(new BorderLayout());
	setContentPane(panel);//layout livre
        
        //--------------painel inferior com botões de ação---------
	//criação do novo painel
	JPanel painelDeBotões = new JPanel();
	painelDeBotões.setBounds(0, 323, 666, 38);
	getContentPane().add(painelDeBotões);
	//escolha de tamanho da pizza
	tamanho = new Choice();
	tamanho.add("Pequena");
	tamanho.add("Média");
	tamanho.add("Grande");
        tamanho.getSelectedItem();
	painelDeBotões.add(tamanho);
        setarChoice(refe.isChoiceStatus(),tamanho);
	//botão para fechar e voltar a tela iniciar
	JButton botaoVoltar = new JButton("Voltar");
	painelDeBotões.add(botaoVoltar);
	
	//add pedido 
	JButton botaoADDPedido = new JButton("Adicionar");
	painelDeBotões.add(botaoADDPedido);
		
	//Jpanel para receber o editorpane
	JPanel panelParaEditorPane = new JPanel();
	panelParaEditorPane.setBounds(0, 0, 666, 326);
	getContentPane().add(panelParaEditorPane);
		
	//		EditorPane
	JEditorPane editorPane = new JEditorPane();//editor pane para codigos html
	editorPane.setContentType("text/html");//tipo de texto que vai conter no editor
        
	editorPane.setText("<html>\n" +
"	<head>\n" +
"		<title>Opacity</title>\n" +
"		<style type=\"text/css\">\n" +
"                    p.one{\n" +
"                        text-align: center;\n" +
"                    }\n" +
"                    p.two {\n" +
"                        width: 100%;\n" +
"                        height: 400px;\n" +
"                        margin: 5px;\n" +
"                        background-color: #FF3300;\n" +
"                        display: inline-block;\n" +
"                        text-align: center;\n" +
"                    }\n" +
"                    h2.ingredientes-title{" +
"                        width: 100%;\n" +
"                        height: 400px;\n" +
"                        margin:3px;\n" +
"                        display: inline-block;\n" +
"                        background-color: #FFFFFF;\n" +
"                        text-align: center;\n" +
"                    }\n" +
"                    table#01{"+
"                        width: 100%;\n" +
"                        background-color: #f1f1c1;"+
"                        }"+
"		</style>\n" +
"	</head>\n" +
"\n" +
"	<body bgcolor= #000000>\n" +
"            <h2 class = ingredientes-title>Ingredientes</h2>\n" +
"            <h3 class=\"titulo_tabela1\">2 Camadas</h3>\n" +
"            <p class=\"two\">\n" +
"            <strong><em>"+refe.getNome()+"</em></strong><BR/>\n" +
"            <strong><em>"+refe.getIngredientes()+"</em></strong><BR/>\n" +
"            <strong><em>Frango</em></strong><BR/>\n" +
"            <strong><em>Queijo</em></strong><BR/>\n" +
"            <strong><em>Cebola</em></strong></p><BR/>    \n" +
"            <table id=\"01\">\n" +
"                <thead id=\"cabeçalho\">\n" +
"                    <tr>\n" +
"                        <td></td>\n" +
"                        <td>Pequena</td>\n" +
"                        <td>Media</td>\n" +
"                        <td>Grande</td>\n" +
"                    </tr>\n" +
"                </thead>\n" +
"                <tbody id=\"corpo\">\n" +
"                    <td>\n" +
"                        <h3>"+refe.getNome()+"</h3>\n" +
"                    </td>\n" +
"                    <td>R$29,00</td>\n" +
"                    <td>R$33,00</td>\n" +
"                    <td>R$37,00</td>\n" +
"                </tbody>\n" +
"            </table>\n" +
"	</body>\n" +
"</html>");
	//----------configurações nos componentes------------------------------------
	editorPane.setEditable(false);//desativação da permisao para editar
	JScrollPane editorScrollPane = new JScrollPane(editorPane);//scroll pane para o editor
	editorScrollPane.setVerticalScrollBarPolicy(
	               JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);//orientação do scrol pane
	editorScrollPane.setPreferredSize(new Dimension(666, 320));//dimensionamento do scrol pane
	panelParaEditorPane.add(editorScrollPane);//adicionamento do scroll ao jpanel
        setVisible(true);
        
        //botões ações
        botaoVoltar.addMouseListener(new MouseAdapter() {//add de evento do clique
        	@Override
		public void mouseClicked(MouseEvent evt) {
			dispose();
                        framePrincipal.setVisible(true);
		}
	});
        botaoADDPedido.addMouseListener(new MouseAdapter() {//add de evento do clique
        	@Override
		public void mouseClicked(MouseEvent evt) {
                    if(tamanho.isEnabled()){
                        refe.setTamanho(tamanho.getSelectedItem());
                    }                    
                    Main.tableData.setRow(refe);
                    dispose();
                    framePrincipal.setVisible(true);
		}
	});
    }
}