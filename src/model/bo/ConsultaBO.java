package model.bo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dao.BaseInterDAO;
import model.dao.ConsultaDAO;
import model.vo.ConsultaVO;

public class ConsultaBO implements BaseInterBO<ConsultaVO>{
	BaseInterDAO<ConsultaVO> dao = new ConsultaDAO<>();
	public void inserir(ConsultaVO vo) throws Exception{
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
		
	public ConsultaVO buscarPorId(ConsultaVO vo) throws Exception{
		try {
		ConsultaVO vo2 = new ConsultaVO();
		ResultSet rs = dao.buscarPorId(vo);
		if(rs.next() == false) {
			throw new Exception("Erro ao listar, Consulta n�o encontrado.");
		}
		else {
		while(rs.next()) {

			
			vo2.setId(rs.getLong("consulta_id"));
			vo2.setData(rs.getString("consulta_data"));
			vo2.setHorario(rs.getString("consulta_horario"));
			vo2.setStatus(rs.getInt("consulta_status"));
			
			vo2.getPaciente().setNome(rs.getString("pessoa_nome"));
			vo2.getPaciente().setId(rs.getLong("paciente_id"));
			vo2.getMedico().setNome(rs.getString("pessoa_nome"));
			vo2.getMedico().setId(rs.getLong("medico_id"));
			
			System.out.println("ID Consulta: " + vo2.getId());
			System.out.println("Data: " + vo2.getData());
			System.out.println("Horario: " + vo2.getHorario());
			System.out.println("Status: " + vo2.getStatus());
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

	public List<ConsultaVO> buscarPorStatus(ConsultaVO vo) throws Exception{
		try {
		List<ConsultaVO> list = new ArrayList<>();	
		ConsultaDAO<ConsultaVO> dao2 = new ConsultaDAO<>();
		ResultSet rs = dao2.buscarPorStatus(vo);
		if(rs.next() == false) {
			throw new Exception("Erro ao listar, Consulta n�o encontrado.");
		}
		else {
		while(rs.next()) {
			ConsultaVO vo2 = new ConsultaVO();
			
			vo2.setId(rs.getLong("consulta_id"));
			vo2.setData(rs.getString("consulta_data"));
			vo2.setHorario(rs.getString("consulta_horario"));
			vo2.setStatus(rs.getInt("consulta_status"));
			
			vo2.getPaciente().setNome(rs.getString("pessoa_nome"));
			vo2.getPaciente().setId(rs.getLong("paciente_id"));
			vo2.getMedico().setNome(rs.getString("pessoa_nome"));
			vo2.getMedico().setId(rs.getLong("medico_id"));
			
			list.add(vo2);
			
			System.out.println("ID Consulta: " + vo2.getId());
			System.out.println("Data: " + vo2.getData());
			System.out.println("Horario: " + vo2.getHorario());
			System.out.println("Status: " + vo2.getStatus());
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
	
	public List<ConsultaVO> buscarPorData(ConsultaVO vo) throws Exception{
		try {
		List<ConsultaVO> list = new ArrayList<>();	
		ConsultaDAO<ConsultaVO> dao2 = new ConsultaDAO<>();
		ResultSet rs = dao2.buscarPorData(vo);
		if(rs.next() == false) {
			throw new Exception("Erro ao listar, Consulta n�o encontrado.");
		}
		else {
		while(rs.next()) {
			ConsultaVO vo2 = new ConsultaVO();
			
			vo2.setId(rs.getLong("consulta_id"));
			vo2.setData(rs.getString("consulta_data"));
			vo2.setHorario(rs.getString("consulta_horario"));
			vo2.setStatus(rs.getInt("consulta_status"));
			
			vo2.getPaciente().setNome(rs.getString("pessoa_nome"));
			vo2.getPaciente().setId(rs.getLong("paciente_id"));
			vo2.getMedico().setNome(rs.getString("pessoa_nome"));
			vo2.getMedico().setId(rs.getLong("medico_id"));
			
			list.add(vo2);
			
			System.out.println("ID Consulta: " + vo2.getId());
			System.out.println("Data: " + vo2.getData());
			System.out.println("Horario: " + vo2.getHorario());
			System.out.println("Status: " + vo2.getStatus());
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
	
	public List<ConsultaVO> buscarPorPaciente(ConsultaVO vo) throws Exception{
		try {
		List<ConsultaVO> list = new ArrayList<>();	
		ConsultaDAO<ConsultaVO> dao2 = new ConsultaDAO<>();
		ResultSet rs = dao2.buscarPorPaciente(vo);
		if(rs.next() == false) {
			throw new Exception("Erro ao listar, Consulta n�o encontrado.");
		}
		else {
		while(rs.next()) {
			ConsultaVO vo2 = new ConsultaVO();
			
			vo2.setId(rs.getLong("consulta_id"));
			vo2.setData(rs.getString("consulta_data"));
			vo2.setHorario(rs.getString("consulta_horario"));
			vo2.setStatus(rs.getInt("consulta_status"));
			
			vo2.getPaciente().setNome(rs.getString("pessoa_nome"));
			vo2.getPaciente().setId(rs.getLong("paciente_id"));
			vo2.getMedico().setNome(rs.getString("pessoa_nome"));
			vo2.getMedico().setId(rs.getLong("medico_id"));
			
			list.add(vo2);
			
			System.out.println("ID Consulta: " + vo2.getId());
			System.out.println("Data: " + vo2.getData());
			System.out.println("Horario: " + vo2.getHorario());
			System.out.println("Status: " + vo2.getStatus());
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
	
	public List<ConsultaVO> buscarPorMedico(ConsultaVO vo) throws Exception{
		try {
		List<ConsultaVO> list = new ArrayList<>();	
		ConsultaDAO<ConsultaVO> dao2 = new ConsultaDAO<>();
		ResultSet rs = dao2.buscarPorMedico(vo);
		if(rs.next() == false) {
			throw new Exception("Erro ao listar, Consulta n�o encontrado.");
		}
		else {
		while(rs.next()) {
			ConsultaVO vo2 = new ConsultaVO();
			
			vo2.setId(rs.getLong("consulta_id"));
			vo2.setData(rs.getString("consulta_data"));
			vo2.setHorario(rs.getString("consulta_horario"));
			vo2.setStatus(rs.getInt("consulta_status"));
			
			vo2.getPaciente().setNome(rs.getString("pessoa_nome"));
			vo2.getPaciente().setId(rs.getLong("paciente_id"));
			vo2.getMedico().setNome(rs.getString("pessoa_nome"));
			vo2.getMedico().setId(rs.getLong("medico_id"));
			
			list.add(vo2);
			
			System.out.println("ID Consulta: " + vo2.getId());
			System.out.println("Data: " + vo2.getData());
			System.out.println("Horario: " + vo2.getHorario());
			System.out.println("Status: " + vo2.getStatus());
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
	
	public List<ConsultaVO> buscarTudo() throws Exception{
		try {
		List<ConsultaVO> list = new ArrayList<>();	
		ResultSet rs = dao.buscarTudo();
		if(rs.next() == false) {
			throw new Exception("Erro ao listar, Consultas n�o encontrados.");
		}
		else {
		while(rs.next()) {
			ConsultaVO vo2 = new ConsultaVO();
			
			vo2.setId(rs.getLong("consulta_id"));
			vo2.setData(rs.getString("consulta_data"));
			vo2.setHorario(rs.getString("consulta_horario"));
			vo2.setStatus(rs.getInt("consulta_status"));
			
			vo2.getPaciente().setNome(rs.getString("pessoa_nome"));
			vo2.getPaciente().setId(rs.getLong("paciente_id"));
			vo2.getMedico().setNome(rs.getString("pessoa_nome"));
			vo2.getMedico().setId(rs.getLong("medico_id"));
			
			list.add(vo2);
			
			System.out.println("ID Consulta: " + vo2.getId());
			System.out.println("Data: " + vo2.getData());
			System.out.println("Horario: " + vo2.getHorario());
			System.out.println("Status: " + vo2.getStatus());
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
	
	public void remover(ConsultaVO vo) throws Exception{
		try {
			ResultSet rs = dao.buscarPorId(vo);
			if (rs.next()== false) {
				throw new Exception("Imposs�vel remover, Consulta n�o encontrado.");
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
	
	public void editar(ConsultaVO vo) throws Exception{
		try {
			ResultSet rs = dao.buscarPorId(vo);
			if (rs.next()== false) {
				throw new Exception("Imposs�vel editar, Consulta n�o encontrada.");
			}
			else {
				dao.editar(vo);
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void editarHorario(ConsultaVO vo) throws Exception{
		ConsultaDAO<ConsultaVO> dao2 = new ConsultaDAO<>();
		try {
			ResultSet rs = dao2.buscarPorId(vo);
			if (rs.next()== false) {
				throw new Exception("Imposs�vel editar, Consulta n�o encontrada.");
			}
			else {
				dao2.editarHorario(vo);;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void editarData(ConsultaVO vo) throws Exception{
		ConsultaDAO<ConsultaVO> dao2 = new ConsultaDAO<>();
		try {
			ResultSet rs = dao2.buscarPorId(vo);
			if (rs.next()== false) {
				throw new Exception("Imposs�vel editar, Consulta n�o encontrada.");
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
