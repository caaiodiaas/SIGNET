package model.bo;

import java.sql.ResultSet;

import model.dao.BaseInterDAO;
import model.dao.ConsultaDAO;
import model.vo.ConsultaVO;

public class ConsultaBO implements BaseInterBO<ConsultaVO>{
	BaseInterDAO<ConsultaVO> dao = new ConsultaDAO()<>();
	public void inserir(ConsultaVO vo) throws Exception{
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
