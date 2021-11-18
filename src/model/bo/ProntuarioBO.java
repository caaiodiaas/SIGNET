package model.bo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dao.BaseInterDAO;
import model.dao.ConsultaDAO;
import model.dao.MedicoDAO;
import model.dao.ProntuarioDAO;
import model.vo.ConsultaVO;
import model.vo.MedicoVO;
import model.vo.ProntuarioVO;

public class ProntuarioBO implements BaseInterBO<ProntuarioVO>{
	BaseInterDAO<ProntuarioVO> dao = new ProntuarioDAO<>();
	public void inserir(ProntuarioVO vo) throws Exception{
		try {
			ResultSet rs = dao.buscarPorId(vo);
			if (rs.next()) {
				throw new Exception("Impossï¿½vel cadastrar");
			}
			else {
				dao.inserir(vo);
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<ProntuarioVO> buscar(ProntuarioVO vo) throws Exception{
		try {
		List<ProntuarioVO> list = new ArrayList<>();	
		ProntuarioDAO<ProntuarioVO> dao2 = new ProntuarioDAO<>();
		ResultSet rs = dao2.buscarTudo();
		if(rs.next() == false) {
			throw new Exception("Erro ao listar, Prontuário não encontrado.");
		}
		else {
			ProntuarioVO vo2 = new ProntuarioVO();
			vo2.setId(rs.getLong("prontuario_id"));
			vo2.setPaciente(rs.getString("paciente_nome"));
			vo2.setMedico(rs.getString("medico_nome"));
			vo2.setData(rs.getString("prontuario_data"));
			vo2.setObservacoes(rs.getString("prontuario_observacoes"));
			
			String paciente1, paciente2, data1, data2;
			
			if (vo.getPaciente() == null || vo2.getPaciente() == null) {
				paciente1 = "-";
				paciente2 = "--";
			}else {
				paciente1 = vo.getPaciente().substring(0, 3);
				paciente2 = vo2.getPaciente().substring(0, 3);
			}

	


			if (vo.getData() == null || vo2.getData() == null) {
				data1 = "-";
				data2 = "--";
			}else {
				data1 = vo.getData().substring(0, 3);
				data2 = vo2.getData().substring(0, 3);
			}

			



			

			if(paciente1.equals(paciente2)|| data1.equals(data2) ) {
				list.add(vo2);
			}
				
		while(rs.next()) {
			ProntuarioVO vo3 = new ProntuarioVO();
			vo3.setId(rs.getLong("prontuario_id"));
			vo3.setPaciente(rs.getString("paciente_nome"));
			vo3.setMedico(rs.getString("medico_nome"));
			vo3.setData(rs.getString("prontuario_data"));
			vo3.setObservacoes(rs.getString("prontuario_observacoes"));
			
			
			if (vo.getPaciente() == null || vo3.getPaciente() == null) {
				paciente1 = "-";
				paciente2 = "--";
			}else {
				paciente1 = vo.getPaciente().substring(0, 3);
				paciente2 = vo3.getPaciente().substring(0, 3);
			}

			


			if (vo.getData() == null || vo3.getData() == null) {
				data1 = "-";
				data2 = "--";
			}else {
				data1 = vo.getData().substring(0, 3);
				data2 = vo3.getData().substring(0, 3);
			}

			
			

			if(paciente1.equals(paciente2) || data1.equals(data2) ) {
				list.add(vo3);
			}
				

		}
			return list;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}	
	}
	
	public ProntuarioVO buscarPorId(ProntuarioVO vo) throws Exception{
		try {
		ProntuarioVO vo2 = new ProntuarioVO();
		ResultSet rs = dao.buscarPorId(vo);
		if(rs.next() == false) {
			throw new Exception("Erro ao listar, Prontuario nï¿½o encontrado.");
		}
		else {
		while(rs.next()) {


			vo2.setId(rs.getLong("prontuario_id"));
			vo2.setData(rs.getString("prontuario_data"));
			vo2.setObservacoes(rs.getString("prontuario_observacoes"));
			
			vo2.setPaciente((rs.getString("paciente_nome")));
			vo2.setMedico((rs.getString("medico_nome")));

		}
			return vo2;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	
	public List<ProntuarioVO> buscarTudo() throws Exception{
		try {
		List<ProntuarioVO> list= new ArrayList<>();
		ResultSet rs = dao.buscarTudo();

		if(rs.next() == false) {
			throw new Exception("Erro ao listar, Consultas nï¿½o encontrados.");
		}
		else {
			ProntuarioVO vo2 = new ProntuarioVO();

			
			vo2.setId(rs.getLong("prontuario_id"));
			vo2.setData(rs.getString("prontuario_data"));
			vo2.setObservacoes(rs.getString("prontuario_observacoes"));
			vo2.setPaciente(rs.getString("paciente_nome"));
			vo2.setMedico(rs.getString("medico_nome"));

			
			list.add(vo2);

		while(rs.next()) {
			
			ProntuarioVO vo3 = new ProntuarioVO();

			
			vo3.setId(rs.getLong("prontuario_id"));
			vo3.setData(rs.getString("prontuario_data"));
			vo3.setObservacoes(rs.getString("prontuario_observacoes"));
			vo3.setPaciente(rs.getString("paciente_nome"));
			vo3.setMedico(rs.getString("medico_nome"));

			
			list.add(vo3);
				
		}
			return list;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	
	public void remover(ProntuarioVO vo) throws Exception{
		try {
			ResultSet rs = dao.buscarPorId(vo);
			if (rs.next()== false) {
				throw new Exception("Impossï¿½vel remover, Prontuario nï¿½o encontrado.");
			}
			else {
				dao.remover(vo);
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void removerTudo() throws Exception{
		try {
				dao.removerTudo();
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void editar(ProntuarioVO vo) throws Exception{
		try {
			ResultSet rs = dao.buscarPorId(vo);
			if (rs.next()== false) {
				throw new Exception("Impossï¿½vel editar, Prontuario nï¿½o encontrado.");
			}
			else {
				dao.editar(vo);
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	
	public void editarData(ProntuarioVO vo) throws Exception{
		ProntuarioDAO<ProntuarioVO> dao2 = new ProntuarioDAO<>();
		try {
			ResultSet rs = dao2.buscarPorId(vo);
			if (rs.next()== false) {
				throw new Exception("Impossï¿½vel editar, Prontuario nï¿½o encontrado.");
			}
			else {
				dao2.editarData(vo);;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
