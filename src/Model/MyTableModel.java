package Model;

import Model.Pizza;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel{
    private static final int colunmCheckBox = 3;
    String[] columNames2 = {"Nome","Tamanho", "preco","Status"};      
    List<Refeicao> data = new ArrayList<Refeicao>();
    
    @Override
    public int getColumnCount()
    {
        return columNames2.length;
    }

    @Override
    public int getRowCount()
    {
        return data.size();
    }

    @Override
    public String getColumnName(int col)
    {
        return columNames2[col];//cast from object to string.            
    }

    @Override
    public Object getValueAt(int row, int colum) {
      Refeicao refe = (Refeicao) data.get(row);

      switch(colum){
        case 0: return refe.getNome();
        case 1: return refe.getTamanho();
        case 2: return refe.getPreco();
        case 3: return refe.isStatus();
        default : return null;
      }
    }
    
    @Override
    public void setValueAt(Object obj, int row, int colum) {
      Refeicao refe = (Refeicao) data.get(row);
    
      switch(colum){
        case 0:  refe.setNome((String)obj);
        case 1:  refe.setTamanho((String) obj);
        case 2:  refe.setPreco((Double) obj);
        case 3:  refe.setStatus((Boolean) obj);
      }
      
      data.set(row, refe);
      //fireTableDataChanged();
      fireTableCellUpdated(row, colum);
    }

    public void setRow(Refeicao refe)
    {
        data.add(refe);
        fireTableRowsInserted(data.size()-1, data.size()-1);
        //fireTableDataChanged();
    }
    public String gerarPedido(){
        String pedido = "";
        for(Refeicao refeicao : data){
            pedido += data+"\n";
        }
        return pedido;
    }
    /*
    Acrescenta checkbox na coluna de dados booleano
    */
    @Override
    public Class getColumnClass(int column) {
        /*switch (column) {
            case 0:
                return String.class;
            case 1:
                return Double.class;
            case 2:
                return Boolean.class;
            default:
                return null;
        }*/
        return column == colunmCheckBox ? Boolean.class : String.class;
    }//
    //informa a linha para ser editada
    @Override
    public boolean isCellEditable(int row, int col) {
	if (col < 3) {
	    return false;
	} else {
	    return true;
	}
    }//fim iscelleditable
    
}