package mercado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mercado.model.Produto;


public class ProdutoDao {
    public Statement st;
    public PreparedStatement stmn;
    public Connection connection;
    public ResultSet rs;
    private ArrayList<Produto> lista = new ArrayList<>();
    
    public ProdutoDao(){
        connection = new ConnectionFactory().getConexao();
    }
    
    public void inserir(Produto produto){
        String sql = "INSERT INTO produto"
                + "(nome,descricao)"
                + "VALUES(?,?)";
        try{
            stmn = connection.prepareStatement(sql);
            stmn.setString(1, produto.getNome());
            stmn.setString(2,produto.getDescricao());
            stmn.execute();
            stmn.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void alterar(Produto produto){
        String sql = "UPDATE produto SET nome=?,descricao=? WHERE id=?";
        try{
            stmn = connection.prepareStatement(sql);
            stmn.setInt(3,produto.getId());
            stmn.setString(1, produto.getNome());
            stmn.setString(2,produto.getDescricao());
            stmn.execute();
            stmn.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void excluir(int id){
        String sql = "DELETE FROM produto WHERE id=" + id;
        try{
            st = connection.createStatement();
            st.execute(sql);
            st.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public ArrayList<Produto> listarTodos(){
        String sql = "SELECT * FROM produto";
        try{
        st = connection.createStatement();
        rs = st.executeQuery(sql);
        while(rs.next()){
            Produto produto = new Produto();
            produto.setId(rs.getInt("id"));
            produto.setNome(rs.getString("nome"));
            produto.setDescricao(rs.getString("descricao"));
            lista.add(produto);
        }
        
        }catch(SQLException e){
            System.out.println(e);
        }
        return lista;
    }
    
    public ArrayList<Produto> listarTodosDescricao(String descricao){
        String sql = "SELECT * FROM produto"
                + "WHERE descricao LIKE '%"+descricao+"%'";
        try{
        st = connection.createStatement();
        rs = st.executeQuery(sql);
        while(rs.next()){
            Produto produto = new Produto();
            produto.setId(rs.getInt("id"));
            produto.setNome(rs.getString("nome"));
            produto.setDescricao(rs.getString("descricao"));
            lista.add(produto);
        }
        
        }catch(SQLException e){
            System.out.println(e);
        }
        return lista;
    }
}
