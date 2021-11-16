package model.bo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dao.UsuarioDAO;
import model.vo.UsuarioVO;

public class UsuarioBO implements BaseInterBO<UsuarioVO>{
	UsuarioDAO<UsuarioVO> dao = new UsuarioDAO<>();
	
	public void inserir(UsuarioVO vo) throws Exception{
		try {
			ResultSet rs = dao.buscarPorId(vo);
			if (rs.next()) {
				throw new Exception("Imposs�vel cadastrar, usu�rio n�o encontrado.");
			}
			else {
				dao.inserir(vo);
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public UsuarioVO buscarPorId(UsuarioVO vo) throws Exception{
		try {
		UsuarioVO vo2 = new UsuarioVO();
		ResultSet rs = dao.buscarPorId(vo);
		if(rs.next() == false) {
			throw new Exception("Erro ao listar, usu�rio n�o encontrado.");
		}
		else {
		while(rs.next()) {

			vo2.setId(rs.getLong("usuario_id"));
			vo2.setLogin(rs.getString("usuario_login"));
			vo2.setSenha(rs.getString("usuario_senha"));
			vo2.setTipoUsuario(rs.getInt("usuario_tipoUsuario"));
			vo2.setNome(rs.getString("pessoa_nome"));
			vo2.setCpf(rs.getString("pessoa_cpf"));
			vo2.setEndereco(rs.getString("pessoa_endereco"));
			
			System.out.println("Id: " + vo2.getId());
			System.out.println("Login: " + vo2.getLogin());
			System.out.println("Senha: " + vo2.getSenha());
			
			switch(vo2.getTipoUsuario()) {
			case 0: System.out.println("Tipo de usu�rio: Administrador");
			break;
			case 1: System.out.println("Tipo de usu�rio: M�dico");
			break;
			case 2: System.out.println("Tipo de usu�rio: Paciente");
			break;
			}
			
			System.out.println("Nome: " + vo2.getNome());
			System.out.println("CPF: " + vo2.getCpf());
			System.out.println("Endere�o: " + vo2.getEndereco());
		}
			return vo2;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}

	public List<UsuarioVO> buscarPorCpf(UsuarioVO vo) throws Exception{
		try {
		List<UsuarioVO> list = new ArrayList<>();	
		UsuarioDAO<UsuarioVO> dao2 = new UsuarioDAO<>();
		ResultSet rs = dao2.buscarPorCpf(vo);
		if(rs.next() == false) {
			throw new Exception("Erro ao listar, Usuario n�o encontrado.");
		}
		else {
		while(rs.next()) {
			UsuarioVO vo2 = new UsuarioVO();
			vo2.setId(rs.getLong("usuario_id"));
			vo2.setLogin(rs.getString("usuario_login"));
			vo2.setSenha(rs.getString("usuario_senha"));
			vo2.setTipoUsuario(rs.getInt("usuario_tipoUsuario"));
			vo2.setNome(rs.getString("pessoa_nome"));
			vo2.setCpf(rs.getString("pessoa_cpf"));
			vo2.setEndereco(rs.getString("pessoa_endereco"));
			
			list.add(vo2);
			
			System.out.println("Id: " + vo2.getId());
			System.out.println("Login: " + vo2.getLogin());
			System.out.println("Senha: " + vo2.getSenha());
			
			switch(vo2.getTipoUsuario()) {
			case 0: System.out.println("Tipo de usu�rio: Administrador");
			break;
			case 1: System.out.println("Tipo de usu�rio: M�dico");
			break;
			case 2: System.out.println("Tipo de usu�rio: Paciente");
			break;
			}
			
			System.out.println("Nome: " + vo2.getNome());
			System.out.println("CPF: " + vo2.getCpf());
			System.out.println("Endere�o: " + vo2.getEndereco());
		}
			return list;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}	
	}
	
	public List<UsuarioVO> buscarPorNome(UsuarioVO vo) throws Exception{
		try {
		List<UsuarioVO> list = new ArrayList<>();	
		UsuarioDAO<UsuarioVO> dao2 = new UsuarioDAO<>();
		ResultSet rs = dao2.buscarPorNome(vo);
		if(rs.next() == false) {
			throw new Exception("Erro ao listar, Usuario n�o encontrado.");
		}
		else {
		while(rs.next()) {
			UsuarioVO vo2 = new UsuarioVO();
			vo2.setId(rs.getLong("usuario_id"));
			vo2.setLogin(rs.getString("usuario_login"));
			vo2.setSenha(rs.getString("usuario_senha"));
			vo2.setTipoUsuario(rs.getInt("usuario_tipoUsuario"));
			vo2.setNome(rs.getString("pessoa_nome"));
			vo2.setCpf(rs.getString("pessoa_cpf"));
			vo2.setEndereco(rs.getString("pessoa_endereco"));
			
			list.add(vo2);
			
			System.out.println("Id: " + vo2.getId());
			System.out.println("Login: " + vo2.getLogin());
			System.out.println("Senha: " + vo2.getSenha());
			
			switch(vo2.getTipoUsuario()) {
			case 0: System.out.println("Tipo de usu�rio: Administrador");
			break;
			case 1: System.out.println("Tipo de usu�rio: M�dico");
			break;
			case 2: System.out.println("Tipo de usu�rio: Paciente");
			break;
			}
			
			System.out.println("Nome: " + vo2.getNome());
			System.out.println("CPF: " + vo2.getCpf());
			System.out.println("Endere�o: " + vo2.getEndereco());
		}
			return list;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}	
	}

	public UsuarioVO buscarPorLogin(UsuarioVO vo) throws Exception{

		try {
		UsuarioVO vo2 = new UsuarioVO();
		UsuarioDAO<UsuarioVO> dao2 = new UsuarioDAO<>();
		ResultSet rs = dao2.buscarPorLogin(vo);
		if(rs.next() == false) {
			throw new Exception("Erro ao listar, Usuario n�o encontrado.");
		}
		else {
			vo2.setLogin(rs.getString("usuario_login"));
			vo2.setSenha(rs.getString("usuario_senha"));
			vo2.setTipoUsuario(rs.getInt("usuario_tipoUsuario"));
			vo2.setNome(rs.getString("pessoa_nome"));
			vo2.setCpf(rs.getString("pessoa_cpf"));
			vo2.setEndereco(rs.getString("pessoa_endereco"));
			
		while(rs.next()) {
			vo2.setLogin(rs.getString("usuario_login"));
			vo2.setSenha(rs.getString("usuario_senha"));
			vo2.setTipoUsuario(rs.getInt("usuario_tipoUsuario"));
			vo2.setNome(rs.getString("pessoa_nome"));
			vo2.setCpf(rs.getString("pessoa_cpf"));
			vo2.setEndereco(rs.getString("pessoa_endereco"));
			
			System.out.println("Id: " + vo2.getId());
			System.out.println("Login: " + vo2.getLogin());
			System.out.println("Senha: " + vo2.getSenha());
			
			switch(vo2.getTipoUsuario()) {
			case 0: System.out.println("Tipo de usu�rio: Administrador");
			break;
			case 1: System.out.println("Tipo de usu�rio: M�dico");
			break;
			case 2: System.out.println("Tipo de usu�rio: Paciente");
			break;
			}
			
			System.out.println("Nome: " + vo2.getNome());
			System.out.println("CPF: " + vo2.getCpf());
			System.out.println("Endere�o: " + vo2.getEndereco());
		}
			return vo2;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}	
	}

	public List<UsuarioVO> buscarPorTipoUsuario(UsuarioVO vo) throws Exception{
		try {
		List<UsuarioVO> list = new ArrayList<>();	
		UsuarioDAO<UsuarioVO> dao2 = new UsuarioDAO<>();
		ResultSet rs = dao2.buscarPorTipoUsuario(vo);
		if(rs.next() == false) {
			throw new Exception("Erro ao listar, Usuario n�o encontrado.");
		}
		else {
		while(rs.next()) {
			UsuarioVO vo2 = new UsuarioVO();
			vo2.setId(rs.getLong("usuario_id"));
			vo2.setLogin(rs.getString("usuario_login"));
			vo2.setSenha(rs.getString("usuario_senha"));
			vo2.setTipoUsuario(rs.getInt("usuario_tipoUsuario"));
			vo2.setNome(rs.getString("pessoa_nome"));
			vo2.setCpf(rs.getString("pessoa_cpf"));
			vo2.setEndereco(rs.getString("pessoa_endereco"));
			
			list.add(vo2);
			
			System.out.println("Id: " + vo2.getId());
			System.out.println("Login: " + vo2.getLogin());
			System.out.println("Senha: " + vo2.getSenha());
			
			switch(vo2.getTipoUsuario()) {
			case 0: System.out.println("Tipo de usu�rio: Administrador");
			break;
			case 1: System.out.println("Tipo de usu�rio: M�dico");
			break;
			case 2: System.out.println("Tipo de usu�rio: Paciente");
			break;
			}
			
			System.out.println("Nome: " + vo2.getNome());
			System.out.println("CPF: " + vo2.getCpf());
			System.out.println("Endere�o: " + vo2.getEndereco());
		}
			return list;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}	
	}
	
	public List<UsuarioVO> buscarTudo() throws Exception{
		try {
		List<UsuarioVO> list = new ArrayList<>();	
		ResultSet rs = dao.buscarTudo();
		if(rs.next() == false) {
			throw new Exception("Erro ao listar, Usuarios n�o encontrados.");
		}
		else {
		while(rs.next()) {
			UsuarioVO vo2 = new UsuarioVO();
			vo2.setId(rs.getLong("usuario_id"));
			vo2.setLogin(rs.getString("usuario_login"));
			vo2.setSenha(rs.getString("usuario_senha"));
			vo2.setTipoUsuario(rs.getInt("usuario_tipoUsuario"));
			vo2.setNome(rs.getString("pessoa_nome"));
			vo2.setCpf(rs.getString("pessoa_cpf"));
			vo2.setEndereco(rs.getString("pessoa_endereco"));
			
			list.add(vo2);
			
			System.out.println("Id: " + vo2.getId());
			System.out.println("Login: " + vo2.getLogin());
			System.out.println("Senha: " + vo2.getSenha());
			
			switch(vo2.getTipoUsuario()) {
			case 0: System.out.println("Tipo de usu�rio: Administrador");
			break;
			case 1: System.out.println("Tipo de usu�rio: M�dico");
			break;
			case 2: System.out.println("Tipo de usu�rio: Paciente");
			break;
			}
			
			System.out.println("Nome: " + vo2.getNome());
			System.out.println("CPF: " + vo2.getCpf());
			System.out.println("Endere�o: " + vo2.getEndereco());
		}
			return list;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	
	public void remover(UsuarioVO vo) throws Exception{
		try {
			ResultSet rs = dao.buscarPorId(vo);
			if (rs.next()== false) {
				throw new Exception("Imposs�vel remover, Usuario n�o encontrado.");
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
	
	public void editar(UsuarioVO vo) throws Exception{
		try {
			ResultSet rs = dao.buscarPorId(vo);
			if (rs.next()== false) {
				throw new Exception("Imposs�vel editar, usu�rio n�o encontrado.");
			}
			else {
				dao.editar(vo);
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void editarCpf(UsuarioVO vo) throws Exception{
		UsuarioDAO<UsuarioVO> dao2 = new UsuarioDAO<>();
		try {
			ResultSet rs = dao2.buscarPorId(vo);
			if (rs.next()== false) {
				throw new Exception("Imposs�vel editar, usu�rio n�o encontrado.");
			}
			else {
				dao2.editarCpf(vo);;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void editarEndereco(UsuarioVO vo) throws Exception{
		UsuarioDAO<UsuarioVO> dao2 = new UsuarioDAO<>();
		try {
			ResultSet rs = dao2.buscarPorId(vo);
			if (rs.next()== false) {
				throw new Exception("Imposs�vel editar, usu�rio n�o encontrado.");
			}
			else {
				dao2.editarEndereco(vo);;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void editarTipoUsuario(UsuarioVO vo) throws Exception{
		UsuarioDAO<UsuarioVO> dao2 = new UsuarioDAO<>();
		try {
			ResultSet rs = dao2.buscarPorId(vo);
			if (rs.next()== false) {
				throw new Exception("Imposs�vel editar, usu�rio n�o encontrado.");
			}
			else {
				dao2.editarTipoUsuario(vo);;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void editarSenha(UsuarioVO vo) throws Exception{
		UsuarioDAO<UsuarioVO> dao2 = new UsuarioDAO<>();
		try {
			ResultSet rs = dao2.buscarPorId(vo);
			if (rs.next()== false) {
				throw new Exception("Imposs�vel editar, usu�rio n�o encontrado.");
			}
			else {
				dao2.editarSenha(vo);;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void editarLogin(UsuarioVO vo) throws Exception{
		UsuarioDAO<UsuarioVO> dao2 = new UsuarioDAO<>();
		try {
			ResultSet rs = dao2.buscarPorId(vo);
			if (rs.next()== false) {
				throw new Exception("Imposs�vel editar, usu�rio n�o encontrado.");
			}
			else {
				dao2.editarLogin(vo);;
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
}

