package model.bo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import model.dao.BaseInterDAO;
import model.dao.ConsultaDAO;
import model.dao.MedicoDAO;
import model.vo.ConsultaVO;
import model.vo.MedicoVO;
import model.vo.PacienteVO;

public class ConsultaBO implements BaseInterBO<ConsultaVO>{
	BaseInterDAO<ConsultaVO> dao = new ConsultaDAO<>();
	private ObservableList<ConsultaVO> list;
	public void inserir(ConsultaVO vo) throws Exception{
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
	
	public List<ConsultaVO> buscarTudo() throws Exception{
		try {
		List<ConsultaVO> list= new ArrayList<>();
		ResultSet rs = dao.buscarTudo();

		if(rs.next() == false) {
			throw new Exception("Erro ao listar, Consultas nï¿½o encontrados.");
		}
		else {
			ConsultaVO vo2 = new ConsultaVO();

			
			vo2.setId(rs.getLong("consulta_id"));
			vo2.setData(rs.getString("consulta_data"));
			vo2.setHorario(rs.getString("consulta_horario"));
			vo2.setStatus(rs.getString("consulta_status"));
			vo2.setPaciente(rs.getString("paciente_nome"));
			vo2.setMedico(rs.getString("medico_nome"));

			
			list.add(vo2);

		while(rs.next()) {
			
			ConsultaVO vo3 = new ConsultaVO();

			
			vo3.setId(rs.getLong("consulta_id"));
			vo3.setData(rs.getString("consulta_data"));
			vo3.setHorario(rs.getString("consulta_horario"));
			vo3.setStatus(rs.getString("consulta_status"));
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
	
	public List<ConsultaVO> buscar(ConsultaVO vo) throws Exception{
		try {
		List<ConsultaVO> list = new ArrayList<>();	
		ConsultaDAO<ConsultaVO> dao2 = new ConsultaDAO<>();
		ResultSet rs = dao2.buscarTudo();
		if(rs.next() == false) {
			throw new Exception("Erro ao listar, Consulta não encontrado.");
		}
		else {
			ConsultaVO vo2 = new ConsultaVO();
			vo2.setId(rs.getLong("consulta_id"));
			vo2.setPaciente(rs.getString("paciente_nome"));
			vo2.setMedico(rs.getString("medico_nome"));
			vo2.setData(rs.getString("consulta_data"));
			vo2.setHorario(rs.getString("consulta_horario"));
			vo2.setStatus(rs.getString("consulta_status"));
			
			String paciente1, paciente2, medico1, medico2, data1, data2, horario1, horario2, status1, status2;
			
			if (vo.getPaciente() == null || vo2.getPaciente() == null) {
				paciente1 = "-";
				paciente2 = "--";
			}else {
				paciente1 = vo.getPaciente().substring(0, 3);
				paciente2 = vo2.getPaciente().substring(0, 3);
			}

			
			if (vo.getMedico() == null || vo2.getMedico() == null) {
				medico1 = "-";
				medico2 = "--";
			}else {
				medico1 = vo.getMedico().substring(0, 3);
				medico2 = vo2.getMedico().substring(0, 3);
			}


			if (vo.getData() == null || vo2.getData() == null) {
				data1 = "-";
				data2 = "--";
			}else {
				data1 = vo.getData().substring(0, 3);
				data2 = vo2.getData().substring(0, 3);
			}

			

			if (vo.getHorario() == null || vo2.getHorario() == null) {
				horario1 = "-";
				horario2 = "--";
			}else {
				horario1 = vo.getHorario().substring(0, 3);
				horario2 = vo2.getHorario().substring(0, 3);
			}

			if (vo.getStatus() == null || vo2.getStatus() == null) {
				status1 = "-";
				status2 = "--";
			}else {
				status1 = vo.getStatus().substring(0, 3);
				status2 = vo2.getStatus().substring(0, 3);
			}
			

			if(paciente1.equals(paciente2) || medico1.equals(medico2) || data1.equals(data2) || horario1.equals(horario2) || status1.equals(status2)) {
				list.add(vo2);
			}
				
		while(rs.next()) {
			ConsultaVO vo3 = new ConsultaVO();
			vo3.setId(rs.getLong("consulta_id"));
			vo3.setPaciente(rs.getString("paciente_nome"));
			vo3.setMedico(rs.getString("medico_nome"));
			vo3.setData(rs.getString("consulta_data"));
			vo3.setHorario(rs.getString("consulta_horario"));
			vo3.setStatus(rs.getString("consulta_status"));
			
			if (vo.getPaciente() == null || vo3.getPaciente() == null) {
				paciente1 = "-";
				paciente2 = "--";
			}else {
				paciente1 = vo.getPaciente().substring(0, 3);
				paciente2 = vo3.getPaciente().substring(0, 3);
			}

			
			if (vo.getMedico() == null || vo3.getMedico() == null) {
				medico1 = "-";
				medico2 = "--";
			}else {
				medico1 = vo.getMedico().substring(0, 3);
				medico2 = vo3.getMedico().substring(0, 3);
			}


			if (vo.getData() == null || vo3.getData() == null) {
				data1 = "-";
				data2 = "--";
			}else {
				data1 = vo.getData().substring(0, 3);
				data2 = vo3.getData().substring(0, 3);
			}

			

			if (vo.getHorario() == null || vo3.getHorario() == null) {
				horario1 = "-";
				horario2 = "--";
			}else {
				horario1 = vo.getHorario().substring(0, 3);
				horario2 = vo3.getHorario().substring(0, 3);
			}

			if (vo.getStatus() == null || vo3.getStatus() == null) {
				status1 = "-";
				status2 = "--";
			}else {
				status1 = vo.getStatus().substring(0, 3);
				status2 = vo3.getStatus().substring(0, 3);
			}
			

			if(paciente1.equals(paciente2) || medico1.equals(medico2) || data1.equals(data2) || horario1.equals(horario2) || status1.equals(status2)) {
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
	
	public void remover(ConsultaVO vo) throws Exception{
		try {
			ResultSet rs = dao.buscarPorId(vo);
			if (rs.next()== false) {
				throw new Exception("Impossï¿½vel remover, Consulta nï¿½o encontrado.");
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
				throw new Exception("Impossï¿½vel editar, Consulta nï¿½o encontrada.");
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
				throw new Exception("Impossï¿½vel editar, Consulta nï¿½o encontrada.");
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
				throw new Exception("Impossï¿½vel editar, Consulta nï¿½o encontrada.");
			}
			else {
				dao2.editarData(vo);;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	@Override
	public ConsultaVO buscarPorId(ConsultaVO entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
