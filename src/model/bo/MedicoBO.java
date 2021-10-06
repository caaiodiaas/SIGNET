package model.bo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dao.BaseInterDAO;
import model.dao.MedicoDAO;
import model.vo.MedicoVO;

public class MedicoBO implements BaseInterBO<MedicoVO>{
	BaseInterDAO<MedicoVO> dao = new MedicoDAO<>();
	
	public void inserir(MedicoVO vo) throws Exception{
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
	
	public List<MedicoVO> buscarPorId(MedicoVO vo) throws Exception{
		try {
		List<MedicoVO> list = new ArrayList<>();	
		ResultSet rs = dao.buscarPorId(vo);
		if(rs.next() == false) {
			throw new Exception("Erro ao listar, médico não encontrado.");
		}
		else {
		while(rs.next()) {
			MedicoVO vo2 = new MedicoVO();
			vo2.setId(rs.getLong("medico_id"));
			vo2.setNome(rs.getString("pessoa_nome"));
			vo2.setCpf(rs.getString("pessoa_cpf"));
			vo2.setEndereco(rs.getString("pessoa_endereco"));
			vo2.setCrm(rs.getString("medico_crm"));
			vo2.setValorConsulta(rs.getFloat("medico_valorConsulta"));
			vo2.setEspecializacao(rs.getString("medico_especializacao"));
			
			list.add(vo2);
			
			System.out.println("Id: " + vo2.getId());
			System.out.println("Nome: " + vo2.getNome());
			System.out.println("CPF: " + vo2.getCpf());
			System.out.println("Endereco: " + vo2.getEndereco());
			System.out.println("Crm: " + vo2.getCrm());
			System.out.println("Especialização: " + vo2.getEspecializacao());
			System.out.println("Valor da consulta: R$" + vo2.getValorConsulta());
		}
			return list;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}

	public List<MedicoVO> buscarPorCpf(MedicoVO vo) throws Exception{
		try {
		List<MedicoVO> list = new ArrayList<>();	
		MedicoDAO<MedicoVO> dao2 = new MedicoDAO<>();
		ResultSet rs = dao2.buscarPorCpf(vo);
		if(rs.next() == false) {
			throw new Exception("Erro ao listar, médico não encontrado.");
		}
		else {
		while(rs.next()) {
			MedicoVO vo2 = new MedicoVO();
			vo2.setId(rs.getLong("medico_id"));
			vo2.setNome(rs.getString("pessoa_nome"));
			vo2.setCpf(rs.getString("pessoa_cpf"));
			vo2.setEndereco(rs.getString("pessoa_endereco"));
			vo2.setCrm(rs.getString("medico_crm"));
			vo2.setValorConsulta(rs.getFloat("medico_valorConsulta"));
			vo2.setEspecializacao(rs.getString("medico_especializacao"));
			
			list.add(vo2);
			
			System.out.println("Id: " + vo2.getId());
			System.out.println("Nome: " + vo2.getNome());
			System.out.println("CPF: " + vo2.getCpf());
			System.out.println("Endereco: " + vo2.getEndereco());
			System.out.println("Crm: " + vo2.getCrm());
			System.out.println("Especialização: " + vo2.getEspecializacao());
			System.out.println("Valor da consulta: R$" + vo2.getValorConsulta());
		}
			return list;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}	
	}
	
	public List<MedicoVO> buscarPorNome(MedicoVO vo) throws Exception{
		try {
		List<MedicoVO> list = new ArrayList<>();	
		MedicoDAO<MedicoVO> dao2 = new MedicoDAO<>();
		ResultSet rs = dao2.buscarPorNome(vo);
		if(rs.next() == false) {
			throw new Exception("Erro ao listar, médico não encontrado.");
		}
		else {
		while(rs.next()) {
			MedicoVO vo2 = new MedicoVO();
			vo2.setId(rs.getLong("medico_id"));
			vo2.setNome(rs.getString("pessoa_nome"));
			vo2.setCpf(rs.getString("pessoa_cpf"));
			vo2.setEndereco(rs.getString("pessoa_endereco"));
			vo2.setCrm(rs.getString("medico_crm"));
			vo2.setValorConsulta(rs.getFloat("medico_valorConsulta"));
			vo2.setEspecializacao(rs.getString("medico_especializacao"));
			
			list.add(vo2);
			
			System.out.println("Id: " + vo2.getId());
			System.out.println("Nome: " + vo2.getNome());
			System.out.println("CPF: " + vo2.getCpf());
			System.out.println("Endereco: " + vo2.getEndereco());
			System.out.println("Crm: " + vo2.getCrm());
			System.out.println("Especialização: " + vo2.getEspecializacao());
			System.out.println("Valor da consulta: R$" + vo2.getValorConsulta());
		}
			return list;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}	
	}
	
	public List<MedicoVO> buscarPorCrm(MedicoVO vo) throws Exception{
		try {
		List<MedicoVO> list = new ArrayList<>();	
		MedicoDAO<MedicoVO> dao2 = new MedicoDAO<>();
		ResultSet rs = dao2.buscarPorCrm(vo);
		if(rs.next() == false) {
			throw new Exception("Erro ao listar, médico não encontrado.");
		}
		else {
		while(rs.next()) {
			MedicoVO vo2 = new MedicoVO();
			vo2.setId(rs.getLong("medico_id"));
			vo2.setNome(rs.getString("pessoa_nome"));
			vo2.setCpf(rs.getString("pessoa_cpf"));
			vo2.setEndereco(rs.getString("pessoa_endereco"));
			vo2.setCrm(rs.getString("medico_crm"));
			vo2.setValorConsulta(rs.getFloat("medico_valorConsulta"));
			vo2.setEspecializacao(rs.getString("medico_especializacao"));
			
			list.add(vo2);
			
			System.out.println("Id: " + vo2.getId());
			System.out.println("Nome: " + vo2.getNome());
			System.out.println("CPF: " + vo2.getCpf());
			System.out.println("Endereco: " + vo2.getEndereco());
			System.out.println("Crm: " + vo2.getCrm());
			System.out.println("Especialização: " + vo2.getEspecializacao());
			System.out.println("Valor da consulta: R$" + vo2.getValorConsulta());
		}
			return list;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}	
	}

	public List<MedicoVO> buscarPorEspecializacao(MedicoVO vo) throws Exception{
		try {
		List<MedicoVO> list = new ArrayList<>();	
		MedicoDAO<MedicoVO> dao2 = new MedicoDAO<>();
		ResultSet rs = dao2.buscarPorEspecializacao(vo);
		if(rs.next() == false) {
			throw new Exception("Erro ao listar, médicos não encontrados.");
		}
		else {
		while(rs.next()) {
			MedicoVO vo2 = new MedicoVO();
			vo2.setId(rs.getLong("medico_id"));
			vo2.setNome(rs.getString("pessoa_nome"));
			vo2.setCpf(rs.getString("pessoa_cpf"));
			vo2.setEndereco(rs.getString("pessoa_endereco"));
			vo2.setCrm(rs.getString("medico_crm"));
			vo2.setValorConsulta(rs.getFloat("medico_valorConsulta"));
			vo2.setEspecializacao(rs.getString("medico_especializacao"));
			
			list.add(vo2);
			
			System.out.println("Id: " + vo2.getId());
			System.out.println("Nome: " + vo2.getNome());
			System.out.println("CPF: " + vo2.getCpf());
			System.out.println("Endereco: " + vo2.getEndereco());
			System.out.println("Crm: " + vo2.getCrm());
			System.out.println("Especialização: " + vo2.getEspecializacao());
			System.out.println("Valor da consulta: R$" + vo2.getValorConsulta());
		}
			return list;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}	
	}
	
	public List<MedicoVO> buscarTudo() throws Exception{
		try {
		List<MedicoVO> list = new ArrayList<>();	
		ResultSet rs = dao.buscarTudo();
		if(rs.next() == false) {
			throw new Exception("Erro ao listar, médicos não encontrados.");
		}
		else {
		while(rs.next()) {
			MedicoVO vo2 = new MedicoVO();
			vo2.setId(rs.getLong("medico_id"));
			vo2.setNome(rs.getString("pessoa_nome"));
			vo2.setCpf(rs.getString("pessoa_cpf"));
			vo2.setEndereco(rs.getString("pessoa_endereco"));
			vo2.setCrm(rs.getString("medico_crm"));
			vo2.setValorConsulta(rs.getFloat("medico_valorConsulta"));
			vo2.setEspecializacao(rs.getString("medico_especializacao"));
			
			list.add(vo2);
			
			System.out.println("Id: " + vo2.getId());
			System.out.println("Nome: " + vo2.getNome());
			System.out.println("CPF: " + vo2.getCpf());
			System.out.println("Endereco: " + vo2.getEndereco());
			System.out.println("Crm: " + vo2.getCrm());
			System.out.println("Especialização: " + vo2.getEspecializacao());
			System.out.println("Valor da consulta: R$" + vo2.getValorConsulta());
		}
			return list;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	
	public void remover(MedicoVO vo) throws Exception{
		try {
			ResultSet rs = dao.buscarPorId(vo);
			if (rs.next()== false) {
				throw new Exception("ID não encontrado, impossível remover");
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
	
	public void editar(MedicoVO vo) throws Exception{
		try {
			ResultSet rs = dao.buscarPorId(vo);
			if (rs.next()== false) {
				throw new Exception("Impossível editar, médico não encontrado.");
			}
			else {
				dao.editar(vo);
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void editarCpf(MedicoVO vo) throws Exception{
		MedicoDAO<MedicoVO> dao2 = new MedicoDAO<>();
		try {
			ResultSet rs = dao2.buscarPorId(vo);
			if (rs.next()== false) {
				throw new Exception("Impossível editar, médico não encontrado.");
			}
			else {
				dao2.editarCpf(vo);;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void editarEndereco(MedicoVO vo) throws Exception{
		MedicoDAO<MedicoVO> dao2 = new MedicoDAO<>();
		try {
			ResultSet rs = dao2.buscarPorId(vo);
			if (rs.next()== false) {
				throw new Exception("Impossível editar, médico não encontrado.");
			}
			else {
				dao2.editarEndereco(vo);;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void editarCrm(MedicoVO vo) throws Exception{
		MedicoDAO<MedicoVO> dao2 = new MedicoDAO<>();
		try {
			ResultSet rs = dao2.buscarPorId(vo);
			if (rs.next()== false) {
				throw new Exception("Impossível editar, médico não encontrado.");
			}
			else {
				dao2.editarCrm(vo);;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void editarEspecializacao(MedicoVO vo) throws Exception{
		MedicoDAO<MedicoVO> dao2 = new MedicoDAO<>();
		try {
			ResultSet rs = dao2.buscarPorId(vo);
			if (rs.next()== false) {
				throw new Exception("Impossível editar, médico não encontrado.");
			}
			else {
				dao2.editarEspecializacao(vo);;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void editarValorConsulta(MedicoVO vo) throws Exception{
		MedicoDAO<MedicoVO> dao2 = new MedicoDAO<>();
		try {
			ResultSet rs = dao2.buscarPorId(vo);
			if (rs.next()== false) {
				throw new Exception("Impossível editar, médico não encontrado.");
			}
			else {
				dao2.editarValorConsulta(vo);;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
