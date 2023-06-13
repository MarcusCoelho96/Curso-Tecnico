package mercado.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionFactory {
    Connection conn;
    
    public Connection getConexao(){
    
    try{
        conn = DriverManager.getConnection("jdbc:mysql://localhost/" + "mercado","root","");
        if(conn != null){
            System.out.println("Sucesso");
        }
    }catch(SQLException e){
        System.out.println (e);
    }
    return conn;
    }
    
}
