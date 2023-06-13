package mercado.main;

import mercado.dao.ConnectionFactory;
import mercado.view.FormProduto;

public class Mercado {
    public static void main(String [] args){
        //ConnectionFactory c = new ConnectionFactory();
        //c.getConexao();
        FormProduto fp = new FormProduto();
        fp.setVisible(true);
    }
}
