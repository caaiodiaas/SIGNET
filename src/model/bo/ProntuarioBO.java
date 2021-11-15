package model.bo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dao.BaseInterDAO;
import model.dao.ProntuarioDAO;
import model.vo.ProntuarioVO;

public class ProntuarioBO implements BaseInterBO<ProntuarioVO>{
	BaseInterDAO<ProntuarioVO> dao = new ProntuarioDAO<>();
	public void inserir(ProntuarioVO vo) throws Exception{
		try {
			ResultSet rs = dao.buscarPorId(vo);
			if (rs.next()) {
				throw new Exception("Imposs�vel cadastrar");
			}
			else {
				dao.inserir(vo);
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
			throw new Exception("Erro ao listar, Prontuario n�o encontrado.");
		}
		else {
		while(rs.next()) {


			vo2.setId(rs.getLong("prontuario_id"));
			vo2.setData(rs.getString("prontuario_data"));
			vo2.setObservacoes(rs.getString("prontuario_observacoes"));
			
			vo2.getPaciente().setNome(rs.getString("pessoa_nome"));
			vo2.getPaciente().setId(rs.getLong("paciente_id"));
			vo2.getMedico().setNome(rs.getString("pessoa_nome"));
			vo2.getMedico().setId(rs.getLong("medico_id"));
			

			
			System.out.println("ID Prontuario: " + vo2.getId());
			System.out.println("Data: " + vo2.getData());
			System.out.println("Horario: " + vo2.getObservacoes());
			System.out.println("Paciente: " + vo2.getPaciente().getNome());
			System.out.println("ID Paciente: " + vo2.getPaciente().getId());
			System.out.println("Medico: " + vo2.getMedico().getNome());
			System.out.println("ID Medico: " + vo2.getMedico().getId());
		}
			return vo2;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	
	public List<ProntuarioVO> buscarPorData(ProntuarioVO vo) throws Exception{
		try {
		List<ProntuarioVO> list = new ArrayList<>();	
		ProntuarioDAO<ProntuarioVO> dao2 = new ProntuarioDAO<>();
		ResultSet rs = dao2.buscarPorData(vo);
		if(rs.next() == false) {
			throw new Exception("Erro ao listar, Prontuario n�o encontrado.");
		}
		else {
		while(rs.next()) {
			ProntuarioVO vo2 = new ProntuarioVO();

			vo2.setId(rs.getLong("prontuario_id"));
			vo2.setData(rs.getString("prontuario_data"));
			vo2.setObservacoes(rs.getString("prontuario_observacoes"));
			
			vo2.getPaciente().setNome(rs.getString("pessoa_nome"));
			vo2.getPaciente().setId(rs.getLong("paciente_id"));
			vo2.getMedico().setNome(rs.getString("pessoa_nome"));
			vo2.getMedico().setId(rs.getLong("medico_id"));
			
			list.add(vo2);
			
			System.out.println("ID Prontuario: " + vo2.getId());
			System.out.println("Data: " + vo2.getData());
			System.out.println("Horario: " + vo2.getObservacoes());
			System.out.println("Paciente: " + vo2.getPaciente().getNome());
			System.out.println("ID Paciente: " + vo2.getPaciente().getId());
			System.out.println("Medico: " + vo2.getMedico().getNome());
			System.out.println("ID Medico: " + vo2.getMedico().getId());
		}
			return list;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}	
	}
	
	public List<ProntuarioVO> buscarPorPaciente(ProntuarioVO vo) throws Exception{
		try {
		List<ProntuarioVO> list = new ArrayList<>();	
		ProntuarioDAO<ProntuarioVO> dao2 = new ProntuarioDAO<>();
		ResultSet rs = dao2.buscarPorPaciente(vo);
		if(rs.next() == false) {
			throw new Exception("Erro ao listar, Prontuario n�o encontrado.");
		}
		else {
		while(rs.next()) {
			ProntuarioVO vo2 = new ProntuarioVO();
		
			vo2.setId(rs.getLong("prontuario_id"));
			vo2.setData(rs.getString("prontuario_data"));
			vo2.setObservacoes(rs.getString("prontuario_observacoes"));
			
			vo2.getPaciente().setNome(rs.getString("pessoa_nome"));
			vo2.getPaciente().setId(rs.getLong("paciente_id"));
			vo2.getMedico().setNome(rs.getString("pessoa_nome"));
			vo2.getMedico().setId(rs.getLong("medico_id"));
			
			list.add(vo2);
			
			System.out.println("ID Prontuario: " + vo2.getId());
			System.out.println("Data: " + vo2.getData());
			System.out.println("Horario: " + vo2.getObservacoes());
			System.out.println("Paciente: " + vo2.getPaciente().getNome());
			System.out.println("ID Paciente: " + vo2.getPaciente().getId());
			System.out.println("Medico: " + vo2.getMedico().getNome());
			System.out.println("ID Medico: " + vo2.getMedico().getId());
		}
			return list;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}	
	}
	
	public List<ProntuarioVO> buscarPorMedico(ProntuarioVO vo) throws Exception{
		try {
		List<ProntuarioVO> list = new ArrayList<>();	
		ProntuarioDAO<ProntuarioVO> dao2 = new ProntuarioDAO<>();
		ResultSet rs = dao2.buscarPorMedico(vo);
		if(rs.next() == false) {
			throw new Exception("Erro ao listar, Prontuario n�o encontrado.");
		}
		else {
		while(rs.next()) {
			ProntuarioVO vo2 = new ProntuarioVO();
			
			vo2.setId(rs.getLong("prontuario_id"));
			vo2.setData(rs.getString("prontuario_data"));
			vo2.setObservacoes(rs.getString("prontuario_observacoes"));
			
			vo2.getPaciente().setNome(rs.getString("pessoa_nome"));
			vo2.getPaciente().setId(rs.getLong("paciente_id"));
			vo2.getMedico().setNome(rs.getString("pessoa_nome"));
			vo2.getMedico().setId(rs.getLong("medico_id"));
			
			list.add(vo2);
			
			System.out.println("ID Prontuario: " + vo2.getId());
			System.out.println("Data: " + vo2.getData());
			System.out.println("Horario: " + vo2.getObservacoes());
			System.out.println("Paciente: " + vo2.getPaciente().getNome());
			System.out.println("ID Paciente: " + vo2.getPaciente().getId());
			System.out.println("Medico: " + vo2.getMedico().getNome());
			System.out.println("ID Medico: " + vo2.getMedico().getId());
		}
			return list;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}	
	}
	
	public List<ProntuarioVO> buscarTudo() throws Exception{
		try {
		List<ProntuarioVO> list = new ArrayList<>();	
		ResultSet rs = dao.buscarTudo();
		if(rs.next() == false) {
			throw new Exception("Erro ao listar, Prontuarios n�o encontrados.");
		}
		else {
		while(rs.next()) {
			ProntuarioVO vo2 = new ProntuarioVO();

			vo2.setId(rs.getLong("prontuario_id"));
			vo2.setData(rs.getString("prontuario_data"));
			vo2.setObservacoes(rs.getString("prontuario_observacoes"));
			
			vo2.getPaciente().setNome(rs.getString("pessoa_nome"));
			vo2.getPaciente().setId(rs.getLong("paciente_id"));
			vo2.getMedico().setNome(rs.getString("pessoa_nome"));
			vo2.getMedico().setId(rs.getLong("medico_id"));
			
			list.add(vo2);
			
			System.out.println("ID Prontuario: " + vo2.getId());
			System.out.println("Data: " + vo2.getData());
			System.out.println("Horario: " + vo2.getObservacoes());
			System.out.println("Paciente: " + vo2.getPaciente().getNome());
			System.out.println("ID Paciente: " + vo2.getPaciente().getId());
			System.out.println("Medico: " + vo2.getMedico().getNome());
			System.out.println("ID Medico: " + vo2.getMedico().getId());
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
				throw new Exception("Imposs�vel remover, Prontuario n�o encontrado.");
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
				throw new Exception("Imposs�vel editar, Prontuario n�o encontrado.");
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
				throw new Exception("Imposs�vel editar, Prontuario n�o encontrado.");
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
