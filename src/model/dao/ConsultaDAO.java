package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.vo.ConsultaVO;

public class ConsultaDAO<VO extends ConsultaVO> extends BaseDAO<VO>{
	
		public void inserir(VO vo) {
		String sql = "INSERT INTO consulta(consulta_data,consulta_horario,consulta_status,paciente_nome,medico_nome) values (?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1,vo.getData());
			ptst.setString(2,vo.getHorario());
			ptst.setString(3,vo.getStatus());
			ptst.setString(4,vo.getPaciente());
			ptst.setString(5,vo.getMedico());

			
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
			String sql = "DELETE FROM consulta WHERE paciente_nome = '"+vo.getPaciente()+"' AND consulta_data = '" +vo.getData() +"'";
			Statement ptst;
			try {
				ptst = conn.createStatement();;
				ptst.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				}

		}
		
		public void removerPorMedico(VO vo) {
			String sql = "DELETE * FROM consulta WHERE medico_nome = ?";
			PreparedStatement ptst;
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setString(1, vo.getMedico());
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
				ptst.setString(1, vo.getStatus());
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
		
		public ResultSet buscarTudo() {
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
		
		public ResultSet buscarPorId(VO vo) {
			String sql = "SELECT * FROM consulta WHERE consulta_id = ?";
			PreparedStatement ptst;
			ResultSet rs = null;
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setLong(1,vo.getId());
				rs = ptst.executeQuery(sql);
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return rs;
		}
		
		public ResultSet buscarPorData(VO vo) {
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
		
		public ResultSet buscarPorPaciente(VO vo) {
			String sql = "SELECT * FROM consulta WHERE paciente_nome = ?";
			 PreparedStatement ptst;
		        ResultSet rs = null;
		        try {
		            ptst = getConnection().prepareStatement(sql);
		            ptst.setString(1,vo.getPaciente());
		            rs = ptst.executeQuery(sql);
		        } catch (SQLException e) {
		            // TODO: handle exception
		            e.printStackTrace();
		        }
			return rs;
		}
		
		public ResultSet buscarPorMedico(VO vo) {
			String sql = "SELECT * FROM consulta WHERE medico_nome = ?";
			 PreparedStatement ptst;
		        ResultSet rs = null;
		        try {
		            ptst = getConnection().prepareStatement(sql);
		            ptst.setString(1,vo.getMedico());
		            rs = ptst.executeQuery(sql);
		        } catch (SQLException e) {
		            // TODO: handle exception
		            e.printStackTrace();
		        }
			return rs;
		}
		
		public ResultSet buscarPorStatus(VO vo) {
			String sql = "SELECT * FROM consulta WHERE consulta_status = ?";
			 PreparedStatement ptst;
		        ResultSet rs = null;
		        try {
		            ptst = getConnection().prepareStatement(sql);
		            ptst.setString(1,vo.getStatus());
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
		
		public void editar(VO vo) throws SQLException {
            conn = getConnection();
            String sql = "UPDATE consulta SET medico_nome = '" + vo.getMedico() + "', consulta_data = '" + vo.getData() + "', consulta_horario = '" + vo.getHorario() + "', consulta_status = '" + vo.getStatus() + "' WHERE paciente_nome = '" + vo.getPaciente()+"'";

            try {
                Statement ptst = conn.createStatement();
         
                ptst.executeUpdate(sql);
            } catch (SQLException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
	}
