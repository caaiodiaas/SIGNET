package model.dao;

public class TesteDAO {
    public static void main(String[] args){
        BaseDAO dao = new BaseDAO();
        System.out.println(dao.getConnection());
    }
}