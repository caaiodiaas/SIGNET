package model.bo;

import java.sql.ResultSet;

import model.dao.BaseInterDAO;
import model.dao.UsuarioDAO;
import model.vo.UsuarioVO;

public class UsuarioBO implements BaseInterBO<UsuarioVO>{
	BaseInterDAO<UsuarioVO> dao = new UsuarioDAO()<>();
	public void inserir(UsuarioVO vo) throws Exception{
		try {
			ResultSet rs = dao.buscarPorId(vo);
			if (rs.next()) {
				throw new Exception("Impossível cadastrar");
			}
			else {
				dao.inserir(vo);
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
