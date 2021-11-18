package model.bo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dao.BaseInterDAO;
import model.dao.MedicoDAO;
import model.vo.ConsultaVO;
import model.vo.MedicoVO;
import model.vo.UsuarioVO;

public class MedicoBO implements BaseInterBO<MedicoVO>{
	BaseInterDAO<MedicoVO> dao = new MedicoDAO<>();
	
	public void inserir(MedicoVO vo) throws Exception{
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
	
	public MedicoVO buscarPorId(MedicoVO vo) throws Exception{
		try {
		MedicoVO vo2 = new MedicoVO();
		ResultSet rs = dao.buscarPorId(vo);
		if(rs.next() == false) {
			throw new Exception("Erro ao listar, mï¿½dico nï¿½o encontrado.");
		}
		else {
		while(rs.next()) {

			vo2.setId(rs.getLong("medico_id"));
			vo2.setNome(rs.getString("pessoa_nome"));
			vo2.setCpf(rs.getString("pessoa_cpf"));
			vo2.setEndereco(rs.getString("pessoa_endereco"));
			vo2.setCrm(rs.getString("medico_crm"));
			vo2.setValorConsulta(rs.getString("medico_valorConsulta"));
			vo2.setEspecializacao(rs.getString("medico_especializacao"));
			
			System.out.println("Id: " + vo2.getId());
			System.out.println("Nome: " + vo2.getNome());
			System.out.println("CPF: " + vo2.getCpf());
			System.out.println("Endereco: " + vo2.getEndereco());
			System.out.println("Crm: " + vo2.getCrm());
			System.out.println("Especializaï¿½ï¿½o: " + vo2.getEspecializacao());
			System.out.println("Valor da consulta: R$" + vo2.getValorConsulta());
		}
			return vo2;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}

	public MedicoVO buscarPorCpf(MedicoVO vo) throws Exception{
		try {
		MedicoVO vo2 = new MedicoVO();
		MedicoDAO<MedicoVO> dao2 = new MedicoDAO<>();
		ResultSet rs = dao2.buscarPorCpf(vo);
		if(rs.next() == false) {
			throw new Exception("Erro ao listar, mï¿½dico nï¿½o encontrado.");
		}
		else {
			vo2.setId(rs.getLong("medico_id"));
			vo2.setNome(rs.getString("pessoa_nome"));
			vo2.setCpf(rs.getString("pessoa_cpf"));
			vo2.setEndereco(rs.getString("pessoa_endereco"));
			vo2.setCrm(rs.getString("medico_crm"));
			vo2.setValorConsulta(rs.getString("medico_valor_consulta"));
			vo2.setEspecializacao(rs.getString("medico_especializacao"));
		while(rs.next()) {
			vo2.setId(rs.getLong("medico_id"));
			vo2.setNome(rs.getString("pessoa_nome"));
			vo2.setCpf(rs.getString("pessoa_cpf"));
			vo2.setEndereco(rs.getString("pessoa_endereco"));
			vo2.setCrm(rs.getString("medico_crm"));
			vo2.setValorConsulta(rs.getString("medico_valor_consulta"));
			vo2.setEspecializacao(rs.getString("medico_especializacao"));

		}
			return vo2;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}	
	}
	
	public List<MedicoVO> buscar(MedicoVO vo) throws Exception{
		try {
		List<MedicoVO> list = new ArrayList<>();	
		MedicoDAO<MedicoVO> dao2 = new MedicoDAO<>();
		ResultSet rs = dao2.buscarTudo();
		if(rs.next() == false) {
			throw new Exception("Erro ao listar, mï¿½dico nï¿½o encontrado.");
		}
		else {
			MedicoVO vo2 = new MedicoVO();
			vo2.setId(rs.getLong("medico_id"));
			vo2.setNome(rs.getString("pessoa_nome"));
			vo2.setCpf(rs.getString("pessoa_cpf"));
			vo2.setEndereco(rs.getString("pessoa_endereco"));
			vo2.setCrm(rs.getString("medico_crm"));
			vo2.setValorConsulta(rs.getString("medico_valor_consulta"));
			vo2.setEspecializacao(rs.getString("medico_especializacao"));
			vo2.setLogin(rs.getString(("usuario_login")));
			vo2.setSenha(rs.getString(("usuario_senha")));
			vo2.setId(rs.getLong("medico_id"));
			vo2.setTipoUsuario(1);
			
			String nome1, nome2, crm1, crm2, cpf1, cpf2, especializacao1, especializacao2;
			
			if (vo.getNome() == null || vo2.getNome() == null) {
				nome1 = "-";
				nome2 = "--";
			}else {
				nome1 = vo.getNome().substring(0, 3);
				nome2 = vo2.getNome().substring(0, 3);
			}

			
			if (vo.getCrm() == null || vo2.getCrm() == null) {
				crm1 = "-";
				crm2 = "--";
			}else {
				crm1 = vo.getCrm().substring(0, 3);
				crm2 = vo2.getCrm().substring(0, 3);
			}


			if (vo.getCpf() == null || vo2.getCpf() == null) {
				cpf1 = "-";
				cpf2 = "--";
			}else {
				cpf1 = vo.getCpf().substring(0, 3);
				cpf2 = vo2.getCpf().substring(0, 3);
			}

			

			if (vo.getEspecializacao() == null || vo2.getEspecializacao() == null) {
				especializacao1 = "-";
				especializacao2 = "--";
			}else {
				especializacao1 = vo.getEspecializacao().substring(0, 3);
				especializacao2 = vo2.getEspecializacao().substring(0, 3);
			}

			

			if(nome1.equals(nome2) || crm1.equals(crm2) || cpf1.equals(cpf2) || especializacao1.equals(especializacao2)) {
				list.add(vo2);
			}
				
		while(rs.next()) {
			MedicoVO vo3 = new MedicoVO();
			vo3.setId(rs.getLong("medico_id"));
			vo3.setNome(rs.getString("pessoa_nome"));
			vo3.setCpf(rs.getString("pessoa_cpf"));
			vo3.setEndereco(rs.getString("pessoa_endereco"));
			vo3.setCrm(rs.getString("medico_crm"));
			vo3.setValorConsulta(rs.getString("medico_valor_consulta"));
			vo3.setEspecializacao(rs.getString("medico_especializacao"));
			vo2.setLogin(rs.getString(("usuario_login")));
			vo2.setSenha(rs.getString(("usuario_senha")));
			vo2.setId(rs.getLong("medico_id"));
			vo2.setTipoUsuario(1);
			
			nome1 = vo.getNome().substring(0, 3);
			nome2 = vo3.getNome().substring(0, 3);
			
			if (vo.getNome() == null || vo3.getNome() == null) {
				nome1 = "-";
				nome2 = "--";
			}else {
				nome1 = vo.getNome().substring(0, 3);
				nome2 = vo3.getNome().substring(0, 3);
			}

			
			if (vo.getCrm() == null || vo3.getCrm() == null) {
				crm1 = "-";
				crm2 = "--";
			}else {
				crm1 = vo.getCrm().substring(0, 3);
				crm2 = vo3.getCrm().substring(0, 3);
			}


			if (vo.getCpf() == null || vo3.getCpf() == null) {
				cpf1 = "-";
				cpf2 = "--";
			}else {
				cpf1 = vo.getCpf().substring(0, 3);
				cpf2 = vo3.getCpf().substring(0, 3);
			}

			

			if (vo.getEspecializacao() == null || vo3.getEspecializacao() == null) {
				especializacao1 = "-";
				especializacao2 = "--";
			}else {
				especializacao1 = vo.getEspecializacao().substring(0, 3);
				especializacao2 = vo3.getEspecializacao().substring(0, 3);
			}
			
			if(nome1.equals(nome2) || crm1.equals(crm2) || cpf1.equals(cpf2) || especializacao1.equals(especializacao2)) {
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
	
	public List<MedicoVO> buscarPorCrm(MedicoVO vo) throws Exception{
		try {
		List<MedicoVO> list = new ArrayList<>();	
		MedicoDAO<MedicoVO> dao2 = new MedicoDAO<>();
		ResultSet rs = dao2.buscarPorCrm(vo);
		if(rs.next() == false) {
			throw new Exception("Erro ao listar, mï¿½dico nï¿½o encontrado.");
		}
		else {
		while(rs.next()) {
			MedicoVO vo2 = new MedicoVO();
			vo2.setId(rs.getLong("medico_id"));
			vo2.setNome(rs.getString("pessoa_nome"));
			vo2.setCpf(rs.getString("pessoa_cpf"));
			vo2.setEndereco(rs.getString("pessoa_endereco"));
			vo2.setCrm(rs.getString("medico_crm"));
			vo2.setValorConsulta(rs.getString("medico_valorConsulta"));
			vo2.setEspecializacao(rs.getString("medico_especializacao"));
			
			list.add(vo2);
			
			System.out.println("Id: " + vo2.getId());
			System.out.println("Nome: " + vo2.getNome());
			System.out.println("CPF: " + vo2.getCpf());
			System.out.println("Endereco: " + vo2.getEndereco());
			System.out.println("Crm: " + vo2.getCrm());
			System.out.println("Especializaï¿½ï¿½o: " + vo2.getEspecializacao());
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
			throw new Exception("Erro ao listar, mï¿½dicos nï¿½o encontrados.");
		}
		else {
		while(rs.next()) {
			MedicoVO vo2 = new MedicoVO();
			vo2.setId(rs.getLong("medico_id"));
			vo2.setNome(rs.getString("pessoa_nome"));
			vo2.setCpf(rs.getString("pessoa_cpf"));
			vo2.setEndereco(rs.getString("pessoa_endereco"));
			vo2.setCrm(rs.getString("medico_crm"));
			vo2.setValorConsulta(rs.getString("medico_valorConsulta"));
			vo2.setEspecializacao(rs.getString("medico_especializacao"));
			
			list.add(vo2);
			
			System.out.println("Id: " + vo2.getId());
			System.out.println("Nome: " + vo2.getNome());
			System.out.println("CPF: " + vo2.getCpf());
			System.out.println("Endereco: " + vo2.getEndereco());
			System.out.println("Crm: " + vo2.getCrm());
			System.out.println("Especializaï¿½ï¿½o: " + vo2.getEspecializacao());
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
		List<MedicoVO> list= new ArrayList<>();
		MedicoDAO<MedicoVO> dao2 = new MedicoDAO<>();
		ResultSet rs = dao2.buscarTudo();

		if(rs.next() == false) {
			throw new Exception("Erro ao listar, Médicos não encontrados.");
		}
		else {
			MedicoVO vo2 = new MedicoVO();

			vo2.setNome(rs.getString("pessoa_nome"));
			vo2.setEndereco(rs.getString("pessoa_endereco"));
			vo2.setCpf(rs.getString("pessoa_cpf"));
			vo2.setCrm(rs.getString("medico_crm"));
			vo2.setEspecializacao(rs.getString("medico_especializacao"));
			vo2.setValorConsulta(rs.getString("medico_valor_consulta"));
			vo2.setId(rs.getLong("medico_id"));
			
			
			list.add(vo2);

		while(rs.next()) {
			
			MedicoVO vo3 = new MedicoVO();

			vo3.setNome(rs.getString("pessoa_nome"));
			vo3.setEndereco(rs.getString("pessoa_endereco"));
			vo3.setCpf(rs.getString("pessoa_cpf"));
			vo3.setCrm(rs.getString("medico_crm"));
			vo3.setEspecializacao(rs.getString("medico_especializacao"));
			vo3.setValorConsulta(rs.getString("medico_valor_consulta"));
			vo3.setId(rs.getLong("medico_id"));
			
			list.add(vo3);
				
		}
			return list;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	
	public void remover(MedicoVO vo) throws Exception{
		MedicoDAO<MedicoVO> dao2 = new MedicoDAO<>();
		try {
			ResultSet rs = dao2.buscarPorCpf(vo);
			if (rs.next()== false) {
				throw new Exception("ID nï¿½o encontrado, impossï¿½vel remover");
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
				throw new Exception("Impossï¿½vel editar, mï¿½dico nï¿½o encontrado.");
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
				throw new Exception("Impossï¿½vel editar, mï¿½dico nï¿½o encontrado.");
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
				throw new Exception("Impossï¿½vel editar, mï¿½dico nï¿½o encontrado.");
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
				throw new Exception("Impossï¿½vel editar, mï¿½dico nï¿½o encontrado.");
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
				throw new Exception("Impossï¿½vel editar, mï¿½dico nï¿½o encontrado.");
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
				throw new Exception("Impossï¿½vel editar, mï¿½dico nï¿½o encontrado.");
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
