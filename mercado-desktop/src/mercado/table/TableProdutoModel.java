package mercado.table;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import mercado.model.Produto;

public class TableProdutoModel extends AbstractTableModel {
    
    public static final int col_id = 0;
    public static final int col_nome = 1;
    public static final int col_descricao = 2;
    public ArrayList<Produto> lista;
    
    
    public TableProdutoModel(ArrayList<Produto> l){
        this.lista = new ArrayList<>(l);
    }
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int linhas, int colunas) {
        Produto produto = lista.get(linhas);
        if(col_id == colunas){
            return produto.getId();
        }
        if(col_nome == colunas){
            return produto.getNome();
        }
        if(col_descricao == colunas){
            return produto.getDescricao();
        }
        return"";
    }
    
}
