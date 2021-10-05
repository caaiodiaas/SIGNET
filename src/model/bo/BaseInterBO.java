package model.bo;

import java.sql.SQLException;

public interface BaseInterBO <VO>{
	public void inserir(VO entity) throws SQLException;
	public void remover(VO entity) throws SQLException;
	public void editar(VO entity) throws SQLException;
	public void listarPorId(VO entity) throws SQLException;
	public void listarPorCpf(VO entity) throws SQLException;
	public void listarPorNome(VO entity) throws SQLException;
	public void listar() throws SQLException;
	
}
