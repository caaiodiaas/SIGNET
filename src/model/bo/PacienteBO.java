package model.bo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dao.PacienteDAO;
import model.dao.BaseInterDAO;
import model.vo.PacienteVO;

public class PacienteBO implements BaseInterBO<PacienteVO>{
	BaseInterDAO<PacienteVO> dao = new PacienteDAO<>();
	
	public void inserir(PacienteVO vo) throws Exception{
		try {
			ResultSet rs = dao.buscarPorId(vo);
			if (rs.next()) {
				throw new Exception("Imposs�vel cadastrar, paciente j� existente.");
			}
			else {
				dao.inserir(vo);
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public PacienteVO buscarPorId(PacienteVO vo) throws Exception{
		try {
		PacienteVO vo2 = new PacienteVO();
		ResultSet rs = dao.buscarPorId(vo);
		if(rs.next() == false) {
			throw new Exception("Erro ao listar, paciente n�o encontrado.");
		}
		else {
		while(rs.next()) {

			vo2.setId(rs.getLong("paciente_id"));
			vo2.setNome(rs.getString("pessoa_nome"));
			vo2.setCpf(rs.getString("pessoa_cpf"));
			vo2.setEndereco(rs.getString("pessoa_endereco"));
			
			
			System.out.println("Id: " + vo2.getId());
			System.out.println("Nome: " + vo2.getNome());
			System.out.println("CPF: " + vo2.getCpf());
			System.out.println("Endereco: " + vo2.getEndereco());
		}
			return vo2;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}

	public List<PacienteVO> buscarPorCpf(PacienteVO vo) throws Exception{
		try {
		List<PacienteVO> list = new ArrayList<>();	
		PacienteDAO<PacienteVO> dao2 = new PacienteDAO<>();
		ResultSet rs = dao2.buscarPorCpf(vo);
		if(rs.next() == false) {
			throw new Exception("Erro ao listar, paciente n�o encontrado.");
		}
		else {
		while(rs.next()) {
			PacienteVO vo2 = new PacienteVO();
			vo2.setId(rs.getLong("paciente_id"));
			vo2.setNome(rs.getString("pessoa_nome"));
			vo2.setCpf(rs.getString("pessoa_cpf"));
			vo2.setEndereco(rs.getString("pessoa_endereco"));
			
			list.add(vo2);
			
			System.out.println("Id: " + vo2.getId());
			System.out.println("Nome: " + vo2.getNome());
			System.out.println("CPF: " + vo2.getCpf());
			System.out.println("Endereco: " + vo2.getEndereco());
		}
			return list;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}	
	}
	
	public List<PacienteVO> buscarPorNome(PacienteVO vo) throws Exception{
		try {
		List<PacienteVO> list = new ArrayList<>();	
		PacienteDAO<PacienteVO> dao2 = new PacienteDAO<>();
		ResultSet rs = dao2.buscarPorNome(vo);
		if(rs.next() == false) {
			throw new Exception("Erro ao listar, paciente n�o encontrado.");
		}
		else {
		while(rs.next()) {
			PacienteVO vo2 = new PacienteVO();
			vo2.setId(rs.getLong("paciente_id"));
			vo2.setNome(rs.getString("pessoa_nome"));
			vo2.setCpf(rs.getString("pessoa_cpf"));
			vo2.setEndereco(rs.getString("pessoa_endereco"));
			
			list.add(vo2);
			
			System.out.println("Id: " + vo2.getId());
			System.out.println("Nome: " + vo2.getNome());
			System.out.println("CPF: " + vo2.getCpf());
			System.out.println("Endereco: " + vo2.getEndereco());
		}
			return list;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}	
	}
	
	public List<PacienteVO> buscarTudo() throws Exception{
		try {
		List<PacienteVO> list = new ArrayList<>();	
		ResultSet rs = dao.buscarTudo();
		if(rs.next() == false) {
			throw new Exception("Erro ao listar, pacientes n�o encontrados.");
		}
		else {
		while(rs.next()) {
			PacienteVO vo2 = new PacienteVO();
			vo2.setId(rs.getLong("paciente_id"));
			vo2.setNome(rs.getString("pessoa_nome"));
			vo2.setCpf(rs.getString("pessoa_cpf"));
			vo2.setEndereco(rs.getString("pessoa_endereco"));
			
			list.add(vo2);
			
			System.out.println("Id: " + vo2.getId());
			System.out.println("Nome: " + vo2.getNome());
			System.out.println("CPF: " + vo2.getCpf());
			System.out.println("Endereco: " + vo2.getEndereco());
		}
			return list;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	
	public void remover(PacienteVO vo) throws Exception{
		try {
			ResultSet rs = dao.buscarPorId(vo);
			if (rs.next()== false) {
				throw new Exception("Imposs�vel remover, paciente n�o encontrado.");
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
	
	public void editar(PacienteVO vo) throws Exception{
		try {
			ResultSet rs = dao.buscarPorId(vo);
			if (rs.next()== false) {
				throw new Exception("Imposs�vel editar, paciente n�o encontrado.");
			}
			else {
				dao.editar(vo);
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void editarCpf(PacienteVO vo) throws Exception{
		PacienteDAO<PacienteVO> dao2 = new PacienteDAO<>();
		try {
			ResultSet rs = dao2.buscarPorId(vo);
			if (rs.next()== false) {
				throw new Exception("Imposs�vel editar, paciente n�o encontrado.");
			}
			else {
				dao2.editarCpf(vo);;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void editarEndereco(PacienteVO vo) throws Exception{
		PacienteDAO<PacienteVO> dao2 = new PacienteDAO<>();
		try {
			ResultSet rs = dao2.buscarPorId(vo);
			if (rs.next()== false) {
				throw new Exception("Imposs�vel editar, paciente n�o encontrado.");
			}
			else {
				dao2.editarEndereco(vo);;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
