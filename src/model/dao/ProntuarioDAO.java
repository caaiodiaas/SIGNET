package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.vo.ProntuarioVO;

public class ProntuarioDAO<VO extends ProntuarioVO> extends BaseDAO<VO>{
	
		public void inserir(VO vo) {
		String sql = "INSERT INTO Prontuario(prontuario_data,prontuario_observacoes, paciente_id, medico_id, prontuario_id) values (?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1,vo.getData());
			ptst.setString(2,vo.getObservacoes());
			ptst.setLong(3,vo.getPaciente().getId());
			ptst.setLong(4,vo.getMedico().getId());
			ptst.setLong(5,vo.getId());
			
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
			String sql = "DELETE * FROM prontuario WHERE prontuario_id = ?";
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
		
		public void removerPorMedico(VO vo) {
			String sql = "DELETE * FROM prontuario WHERE medico_id = ?";
			PreparedStatement ptst;
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setLong(1, vo.getMedico().getId());
				ptst.executeUpdate();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				}
		}
		
		public void removerPorPaciente(VO vo) {
			String sql = "DELETE * FROM prontuario WHERE paciente_id = ?";
			PreparedStatement ptst;
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setLong(1, vo.getPaciente().getId());
				ptst.executeUpdate();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				}
		}
		
		public void removerPorData(VO vo) {
			String sql = "DELETE * FROM prontuario WHERE prontuario_data = ?";
			PreparedStatement ptst;
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setString(1, vo.getData());
				ptst.executeUpdate();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				}
		}
		
		public void removerTudo() {
			String sql = "DELETE * FROM prontuario ";
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
			String sql = "SELECT * FROM prontuario";
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
		
		public ResultSet listarPorData(VO vo) {
			String sql = "SELECT * FROM prontuario WHERE prontuario_data = ?";
			 PreparedStatement ptst;
		        ResultSet rs = null;
		        try {
		            ptst = getConnection().prepareStatement(sql);
		            ptst.setString(1,vo.getData());
		            rs = ptst.executeQuery(sql);
		        } catch (SQLException e) {
		            // TODO: handle exception
		            e.printStackTrace();
		        }
			return rs;
		}
		
		public ResultSet listarPorPaciente(VO vo) {
			String sql = "SELECT * FROM prontuario WHERE paciente_id = ?";
			PreparedStatement ptst;
	        ResultSet rs = null;
	        try {
	            ptst = getConnection().prepareStatement(sql);
	            ptst.setLong(1,vo.getPaciente().getId());
	            rs = ptst.executeQuery(sql);
	        } catch (SQLException e) {
	            // TODO: handle exception
	            e.printStackTrace();
			}
			return rs;
		}
		
		public ResultSet listarPorMedico(VO vo) {
			String sql = "SELECT * FROM prontuario WHERE medico_id = ?";
			PreparedStatement ptst;
	        ResultSet rs = null;
	        try {
	            ptst = getConnection().prepareStatement(sql);
	            ptst.setLong(1,vo.getMedico().getId());
	            rs = ptst.executeQuery(sql);
	        } catch (SQLException e) {
	            // TODO: handle exception
	            e.printStackTrace();
			}
			return rs;
		}
		
		public void editar(VO vo) {
			String sql = "UPDATE prontuario SET prontuario_observacoes = ? WHERE consulta_id = ?";
			PreparedStatement ptst;
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setString(1, vo.getObservacoes());
				ptst.setLong(2, vo.getId());
				ptst.executeUpdate();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		public void editarData(VO vo) {
			String sql = "UPDATE prontuario SET prontuario_data = ? WHERE consulta_id = ?";
			PreparedStatement ptst;
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setString(1, vo.getData());
				ptst.setLong(2, vo.getId());
				ptst.executeUpdate();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		
	}