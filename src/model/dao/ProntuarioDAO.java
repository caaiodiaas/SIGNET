package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.vo.ProntuarioVO;

public class ProntuarioDAO<VO extends ProntuarioVO> extends BaseDAO<VO>{
	
	public void inserir(VO vo) {
		String sql = "INSERT INTO prontuario(prontuario_data,prontuario_observacoes,paciente_nome,medico_nome) values (?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1,vo.getData());
			ptst.setString(2,vo.getObservacoes());
			ptst.setString(3,vo.getPaciente());
			ptst.setString(4,vo.getMedico());

			
			int affectedRows = ptst.executeUpdate();			
			
			if (affectedRows == 0) {
				throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
			}

			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			}
			
	
	public void remover(VO vo) {
		String sql = "DELETE FROM prontuario WHERE paciente_nome = ? AND prontuario_data = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getPaciente());
			ptst.setString(2, vo.getData());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			}
	}
		
		
		public void removerPorPaciente(VO vo) {
			String sql = "DELETE FROM prontuario WHERE paciente_nome = '"+ vo.getPaciente()+"'";
			Statement ptst;
			try {
				ptst = conn.createStatement();;
				ptst.executeUpdate(sql);
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
		
		public ResultSet buscarTudo() {
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
		
		public ResultSet buscarPorId(VO vo) {
			String sql = "SELECT * FROM prontuario WHERE prontuario_id = ?";
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
		
		public ResultSet buscarPorPaciente(VO vo) {
			String sql = "SELECT * FROM prontuario WHERE paciente_nome = ?";
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
			String sql = "SELECT * FROM prontuario WHERE medico_nome = ?";
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
		
		public void editar(VO vo) throws SQLException {
            conn = getConnection();
            String sql = "UPDATE prontuario SET medico_nome = '" + vo.getMedico() + "', prontuario_observacoes = '" + vo.getObservacoes() + "' WHERE paciente_nome = '" + vo.getPaciente()+"' AND prontuario_data = '"+vo.getData()+"'";

            try {
                Statement ptst = conn.createStatement();
         
                ptst.executeUpdate(sql);
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