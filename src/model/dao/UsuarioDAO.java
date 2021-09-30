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
		String sql = "INSERT INTO usuario(pessoa_nome,pessoa_endereco,pessoa_cpf,usuario_login,usuario_senha,usuario_tipoUsuario, usuario_id) values (?,?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1,vo.getNome());
			ptst.setString(2,vo.getEndereco());
			ptst.setString(3,vo.getCpf());
			ptst.setString(4,vo.getLogin());
			ptst.setString(5,vo.getSenha());
			ptst.setInt(6,vo.getTipoUsuario());
			ptst.setLong(7,vo.getId());

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
	
	public void remover(VO vo) {
		String sql = "DELETE * FROM usuario WHERE usuario_id = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, vo.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void removerPorTipoUsuario(VO vo) {
		String sql = "DELETE * FROM usuario WHERE usuario_tipoUsuario = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, vo.getTipoUsuario());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void removerPorNome(VO vo) {
		String sql = "DELETE * FROM usuario WHERE usuario_nome = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getNome());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void removerTudo() {
		String sql = "DELETE * FROM usuario";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public ResultSet listar() {
		String sql = "SELECT * FROM usuario";
		Statement st;
		ResultSet rs = null;
		try {
			st = getConnection().createStatement();
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet listarTipoUsuario(VO vo) {
		String sql = "SELECT * FROM usuario WHERE usuario_tipoUsuario = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1,vo.getId())
			rs = ptst.executeQuery(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rs;
	}
	
	public void editar(VO vo) {
		String sql = "UPDATE usuario SET pessoa_nome = ? where usuario_id = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getNome());
			ptst.setLong(2, vo.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void editarLogin(VO vo) {
		String sql = "UPDATE usuario SET usuario_login = ? where usuario_id = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getLogin());
			ptst.setLong(2, vo.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void editarSenha(VO vo) {
		String sql = "UPDATE usuario SET usuario_login = ? where usuario_id = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getSenha());
			ptst.setLong(2, vo.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void editarTipoUsuario(VO vo) {
		String sql = "UPDATE usuario SET usuario_tipoUsuario = ? where usuario_id = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, vo.getTipoUsuario());
			ptst.setLong(2, vo.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
