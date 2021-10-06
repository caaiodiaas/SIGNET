package model.bo;

import java.sql.SQLException;

public interface BaseInterBO <VO>{
	public void inserir(VO entity) throws Exception;
	public void remover(VO entity) throws Exception;
	public void editar(VO entity) throws Exception;
	public void listarPorId(VO entity) throws Exception;
	public void listarPorCpf(VO entity) throws Exception;
	public void listarPorNome(VO entity) throws Exception;
	public void listar() throws SQLException;
	
}
