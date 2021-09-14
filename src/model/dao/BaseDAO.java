package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDAO{
    Connection conn = null;
    String url = "jdbc:postgresql://localhost:5432/SIGNET";
    String user = "postgres";
    String senha = "";

    public Connection getConnection(){
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
}