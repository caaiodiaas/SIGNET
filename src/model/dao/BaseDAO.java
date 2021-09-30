package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseDAO<VO> implements BaseInterDAO<VO>{
   private static Connection conn = null;
   private static final String url = "jdbc:postgresql://localhost:5432/SIGNET";
   private static final String user = "postgres";
   private static final String senha = "";

    public static Connection getConnection(){
        if (conn == null){         
            try {
                conn= DriverManager.getConnection(url, user, senha);
            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }  
            return conn;
        }
        else return conn;
    }
    
    public static void closeConnection(){
        if (conn != null){         
            try {
                conn.close();
            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }  
        }
    }
    
    public abstract void inserir(VO entity) throws SQLException;
	public abstract void remover(VO entity) throws SQLException;
	public abstract void editar(VO entity) throws SQLException;
	public abstract ResultSet listar() throws SQLException;
    
}