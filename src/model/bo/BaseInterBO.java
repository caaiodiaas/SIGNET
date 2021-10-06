package model.bo;

import java.util.List;

public interface BaseInterBO <VO>{
	public void inserir(VO entity) throws Exception;
	public void remover(VO entity) throws Exception;
	public void removerTudo(VO entity) throws Exception;
	public void editar(VO entity) throws Exception;
	public List<?> buscarPorId(VO entity) throws Exception;
	public List<?> buscarTudo() throws Exception;
	
}
