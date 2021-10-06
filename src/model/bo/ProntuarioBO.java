package model.bo;

import java.sql.ResultSet;

import model.dao.BaseInterDAO;
import model.dao.ProntuarioDAO;
import model.vo.ProntuarioVO;

public class ProntuarioBO implements BaseInterBO<ProntuarioVO>{
	BaseInterDAO<ProntuarioVO> dao = new ProntuarioDAO()<>();
	public void inserir(ProntuarioVO vo) throws Exception{
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
