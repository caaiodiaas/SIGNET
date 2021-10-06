package model.bo;

import model.dao.BaseInterDAO;
import model.dao.UsuarioDAO;
import model.vo.UsuarioVO;

public class UsuarioBO implements BaseInterBO<UsuarioVO>{
	
	BaseInterDAO<UsuarioVO> dao = new UsuarioDAO();
	
	public void inserir(UsuarioVO vo) throws Exception {
		ResultSet rs = dao.
	}
}
