package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.vo.ConsultaVO;

public class ConsultaDAO<VO extends ConsultaVO> extends BaseDAO<VO>{
	
		public void inserir(VO vo) {
		String sql = "INSERT INTO consulta(consulta_data,consulta_horario,consulta_status,pessoa_nome,paciente_id,pessoa_nome,medico_id,consulta_id) values (?,?,?,?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1,vo.getData());
			ptst.setString(2,vo.getHorario());
			ptst.setInt(3,vo.getStatus());
			ptst.setString(4,vo.getPaciente().getNome());
			ptst.setLong(5,vo.getPaciente().getId());
			ptst.setString(6,vo.getMedico().getNome());
			ptst.setLong(7,vo.getMedico().getId());
			ptst.setLong(8,vo.getId());
			
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
			String sql = "DELETE * FROM consulta WHERE consulta_id = ?";
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
		
		public void removerPorPaciente(VO vo) {
			String sql = "DELETE * FROM consulta WHERE paciente_id = ?";
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
		
		public void removerPorMedico(VO vo) {
			String sql = "DELETE * FROM consulta WHERE medico_id = ?";
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
		
		public void removerPorStatus(VO vo) {
			String sql = "DELETE * FROM consulta WHERE consulta_status = ?";
			PreparedStatement ptst;
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setInt(1, vo.getStatus());
				ptst.executeUpdate();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				}
		}
		
		public void removerPorData(VO vo) {
			String sql = "DELETE * FROM consulta WHERE consulta_data = ?";
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
			String sql = "DELETE * FROM consulta";
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
			String sql = "SELECT * FROM consulta";
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
			String sql = "SELECT * FROM consulta WHERE consulta_data = ?";
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
			String sql = "SELECT * FROM consulta WHERE paciente_id = ?";
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
			String sql = "SELECT * FROM consulta WHERE medico_id = ?";
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
		
		public ResultSet listarPorStatus(VO vo) {
			String sql = "SELECT * FROM consulta WHERE consulta_status = ?";
			 PreparedStatement ptst;
		        ResultSet rs = null;
		        try {
		            ptst = getConnection().prepareStatement(sql);
		            ptst.setInt(1,vo.getStatus());
		            rs = ptst.executeQuery(sql);
		        } catch (SQLException e) {
		            // TODO: handle exception
		            e.printStackTrace();
		        }
			return rs;
		}
		
		
		
		public void editarData(VO vo) {
			String sql = "UPDATE consulta SET consulta_data = ? WHERE consulta_id = ?";
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
		
		public void editarHorario(VO vo) {
			String sql = "UPDATE consulta SET consulta_horario = ? WHERE consulta_id = ?";
			PreparedStatement ptst;
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setString(1, vo.getHorario());
				ptst.setLong(2, vo.getId());
				ptst.executeUpdate();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		public void editar(VO vo) {
			String sql = "UPDATE consulta SET consulta_status = ? WHERE consulta_id = ?";
			PreparedStatement ptst;
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setInt(1, vo.getStatus());
				ptst.setLong(2, vo.getId());
				ptst.executeUpdate();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
