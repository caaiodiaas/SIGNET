package model.bo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dao.AdministradorDAO;
import model.dao.BaseInterDAO;
import model.vo.AdministradorVO;

public class AdministradorBO implements BaseInterBO<AdministradorVO>{
	BaseInterDAO<AdministradorVO> dao = new AdministradorDAO<>();
	public void inserir(AdministradorVO vo) throws Exception{
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
	
	
	public List<AdministradorVO> buscarPorId(AdministradorVO vo) throws Exception{
		try {
		List<AdministradorVO> list = new ArrayList<>();	
		ResultSet rs = dao.buscarPorId(vo);
		if(rs.next() == false) {
			throw new Exception("Erro ao listar, ID n�o encontrado");
		}
		else {
		while(rs.next()) {
			AdministradorVO vo2 = new AdministradorVO();
			vo2.setId(rs.getLong("administrador_id"));
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

	
	public List<AdministradorVO> buscarTudo() throws Exception{
		try {
		List<AdministradorVO> list = new ArrayList<>();	
		ResultSet rs = dao.buscarTudo();
		if(rs.next() == false) {
			throw new Exception("Erro ao listar, ID n�o encontrado");
		}
		else {
		while(rs.next()) {
			AdministradorVO vo2 = new AdministradorVO();
			vo2.setId(rs.getLong("administrador_id"));
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
	
	
	public void remover(AdministradorVO vo) throws Exception{
		try {
			ResultSet rs = dao.buscarPorId(vo);
			if (rs.next()== false) {
				throw new Exception("ID n�o encontrado, imposs�vel remover");
			}
			else {
				dao.remover(vo);
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void removerTudo(AdministradorVO vo) throws Exception{
		try {
			AdministradorDAO<AdministradorVO> dao2 = new AdministradorDAO<>();
				dao2.removerTudo();
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void editar(AdministradorVO vo) throws Exception{
		try {
			ResultSet rs = dao.buscarPorId(vo);
			if (rs.next()== false) {
				throw new Exception("ID n�o encontrado, imposs�vel editar");
			}
			else {
				dao.editar(vo);
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void editarCpf(AdministradorVO vo) throws Exception{
		AdministradorDAO<AdministradorVO> dao2 = new AdministradorDAO<>();
		try {
			ResultSet rs = dao2.buscarPorId(vo);
			if (rs.next()== false) {
				throw new Exception("ID n�o encontrado, imposs�vel editar");
			}
			else {
				dao2.editarCpf(vo);;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void editarEndereco(AdministradorVO vo) throws Exception{
		AdministradorDAO<AdministradorVO> dao2 = new AdministradorDAO<>();
		try {
			ResultSet rs = dao2.buscarPorId(vo);
			if (rs.next()== false) {
				throw new Exception("ID n�o encontrado, imposs�vel editar");
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
