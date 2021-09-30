package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.MedicoVO;
import model.vo.UsuarioVO;

public class UsuarioDAO<VO extends UsuarioVO> extends BaseDAO<VO>{
	
	public void inserir(VO vo) {
		String sql = "INSERT INTO usuario(pessoa_nome,pessoa_endereco,pessoa_cpf,usuario_login,usuario_senha,usuario_tipoUsuario) values (?,?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1,vo.getNome());
			ptst.setString(2,vo.getEndereco());
			ptst.setString(3,vo.getCpf());
			ptst.setString(4,vo.getLogin());
			ptst.setString(5,vo.getSenha());
			ptst.setInt(6,vo.getTipoUsuario());

			int affectedRows = ptst.executeUpdate();			
			
			if (affectedRows == 0) {
				throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if (generatedKeys.next()) {
				vo.setId(generatedKeys.getLong(1));
			}
			else {
				throw new SQLException("A inserção falhou. Nenhum Id foi retornado.");
			}	
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public void removerPorLogin(UsuarioVO vo) {
		conn = getConnection();
		String sql = "DELETE * FROM usuario WHERE usuario_login = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1,vo.getLogin());
			ptst.executeUpdate();		
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public void removerPorTipoUsuario(UsuarioVO vo) {
		conn = getConnection();
		String sql = "DELETE * FROM usuario WHERE usuario_tipoUsuario = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1,vo.getTipoUsuario());
			ptst.executeUpdate();		
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public void removerTudo() {
		conn = getConnection();
		String sql = "DELETE * FROM usuario";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.executeUpdate();		
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public List<UsuarioVO> listar() {
		conn = getConnection();
		String sql = "SELECT * FROM usuario";
		Statement st;
		ResultSet rs;
		List<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				UsuarioVO vo = new UsuarioVO();
				vo.setCpf(rs.getString("pessoa_cpf"));
				vo.setEndereco(rs.getString("pessoa_endereco"));
				vo.setNome(rs.getString("pessoa_nome"));

				vo.setLogin(rs.getString("usuario_login"));
				usuarios.add(vo);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return usuarios;
	}
	
	public List<UsuarioVO> listarPorTipoUsuario(UsuarioVO vo) {

		conn = getConnection();
		String sql = "SELECT * FROM usuario WHERE usuario_tipoUsuario = ?";
		Statement st;
		ResultSet rs;
		List<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				vo.setCpf(rs.getString("pessoa_cpf"));
				vo.setEndereco(rs.getString("pessoa_endereco"));
				vo.setNome(rs.getString("pessoa_nome"));

				vo.setLogin(rs.getString("usuario_login"));
				vo.setTipoUsuario(rs.getInt("usuario_tipoUsuario"));
				usuarios.add(vo);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return usuarios;
	}
	
	public void editarLogin(UsuarioVO vo) {
		conn = getConnection();
		String sql = "UPDATE usuario SET usuario_login = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1,vo.getLogin());
			ptst.executeUpdate();		
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public void editarSenha(UsuarioVO vo) {

		conn = getConnection();
		String sql = "UPDATE usuario SET usuario_senha = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1,vo.getSenha());
			ptst.executeUpdate();		
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public void editarTipoUsuario(UsuarioVO vo) {
		conn = getConnection();
		String sql = "UPDATE usuario SET usuario_tipoUsuario = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1,vo.getTipoUsuario());
			ptst.executeUpdate();		
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
