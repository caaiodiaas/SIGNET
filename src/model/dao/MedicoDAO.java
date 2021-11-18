package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.vo.MedicoVO;

public class MedicoDAO<VO extends MedicoVO> extends BaseDAO<VO> {
	
		public void inserir(VO vo) {
		String sql = "INSERT INTO medico(pessoa_nome,pessoa_endereco,pessoa_cpf,usuario_login,usuario_senha,usuario_tipousuario,medico_crm,medico_valor_Consulta,medico_especializacao) values (?,?,?,?,?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			
			
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1,vo.getNome());
			ptst.setString(2,vo.getEndereco());
			ptst.setString(3,vo.getCpf());
			ptst.setString(4,vo.getLogin());
			ptst.setString(5,vo.getSenha());
			ptst.setInt(6,vo.getTipoUsuario());
			ptst.setString(7,vo.getCrm());
			ptst.setString(8,vo.getValorConsulta());
			ptst.setString(9,vo.getEspecializacao());
			
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
	
		public void removerPorCrm(VO vo) {
			String sql = "DELETE * FROM medico WHERE medico_crm = ?";
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
		
		public void removerPorCpf(VO vo) {
			String sql = "DELETE FROM medico WHERE pessoa_cpf = '"+vo.getCpf()+"'";
			Statement ptst;
			try {
				ptst = conn.createStatement();;
				ptst.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				}

		}
				
		public void removerPorNome(VO vo) {
			String sql = "DELETE * FROM medico WHERE pessoa_nome = ?";
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
		
		public void removerPorEspecializacao(VO vo) {
			String sql = "DELETE * FROM medico WHERE medico_especializacao = ?";
			PreparedStatement ptst;
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setString(1, vo.getEspecializacao());
				ptst.executeUpdate();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				}
		}
		
		public void remover(VO vo) {
			String sql = "DELETE * FROM medico WHERE medico_id = ?";
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
		
		public void removerTudo() {
			String sql = "DELETE * FROM medico";
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
			String sql = "SELECT * FROM medico";
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
			String sql = "SELECT * FROM medico WHERE medico_id = ?";
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
		
		public ResultSet buscarPorNome(VO vo) {
			String sql = "SELECT * FROM medico WHERE pessoa_nome = ?";
			PreparedStatement ptst;
			ResultSet rs = null;
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setString(1,vo.getNome());
				rs = ptst.executeQuery(sql);
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return rs;
		}
		
		public ResultSet buscarPorCpf(VO vo) {
			String sql = "SELECT * FROM medico WHERE pessoa_cpf = ?";
			PreparedStatement ptst;
			ResultSet rs = null;
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setString(1,vo.getCpf());
				rs = ptst.executeQuery();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return rs;
		}
		
		public ResultSet buscarPorCrm(VO vo) {
			String sql = "SELECT * FROM medico WHERE medico_crm = ?";
			PreparedStatement ptst;
			ResultSet rs = null;
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setString(1,vo.getCrm());
				rs = ptst.executeQuery(sql);
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return rs;
		}
		
		public ResultSet buscarPorEspecializacao(VO vo) {
			String sql = "SELECT * FROM medico WHERE medico_especializacao = ?";
			 PreparedStatement ptst;
		        ResultSet rs = null;
		        try {
		            ptst = getConnection().prepareStatement(sql);
		            ptst.setString(1,vo.getEspecializacao());
		            rs = ptst.executeQuery(sql);
		        } catch (SQLException e) {
		            // TODO: handle exception
		            e.printStackTrace();
		        }
			return rs;
		}
				
		public ResultSet buscarPorValorConsulta(VO vo) {
			String sql = "SELECT * FROM medico WHERE medico_valor_consulta = ?";
			 PreparedStatement ptst;
		        ResultSet rs = null;
		        try {
		            ptst = getConnection().prepareStatement(sql);
		            ptst.setString(1,vo.getValorConsulta());
		            rs = ptst.executeQuery(sql);
		        } catch (SQLException e) {
		            // TODO: handle exception
		            e.printStackTrace();
		        }
			return rs;
		}
		
		public void editar(VO vo) throws SQLException {
            conn = getConnection();
            String sql = "UPDATE medico SET pessoa_nome = '" + vo.getNome() + "', pessoa_endereco = '" + vo.getEndereco() + "', medico_crm = '" + vo.getCrm() + "', medico_valor_consulta = '" + vo.getValorConsulta() + "', medico_especializacao = '" + vo.getEspecializacao() +  "' WHERE pessoa_cpf = '" + vo.getCpf()+"'";

            try {
                Statement ptst = conn.createStatement();
         
                ptst.executeUpdate(sql);
            } catch (SQLException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
		
		public void editarCrm(VO vo) throws SQLException {
			String sql = "UPDATE medico SET medico_crm = ? WHERE pessoa_cpf = ?";
			PreparedStatement ptst;
			ptst = getConnection().prepareStatement(sql);
			try {
				ptst.setString(1, vo.getCrm());
				ptst.setString(2, vo.getCpf());
				ptst.executeUpdate();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				}
		}
		
		public void editarCpf(VO vo) {
			String sql = "UPDATE medico SET pessoa_cpf = ? WHERE pessoa_cpf = ?";
			PreparedStatement ptst;
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setString(1, vo.getCpf());
				ptst.setString(2, vo.getCpf());
				ptst.executeUpdate();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				}
		}
		
		
		public void editarEndereco(VO vo) {
			String sql = "UPDATE medico SET pessoa_endereco = ? WHERE pessoa_cpf = ?";
			PreparedStatement ptst;
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setString(1, vo.getEndereco());
				ptst.setString(2, vo.getCpf());
				ptst.executeUpdate();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				}
		}
		
		public void editarEspecializacao(VO vo) {
			String sql = "UPDATE medico SET medico_especializacao = ? WHERE pessoa_cpf = ?";
			PreparedStatement ptst;
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setString(1, vo.getEspecializacao());
				ptst.setString(2, vo.getCpf());
				ptst.executeUpdate();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				}
		}
		
		public void editarValorConsulta(VO vo) {
			String sql = "UPDATE medico SET medico_valor_consulta = ? WHERE pessoa_cpf = ?";
			PreparedStatement ptst;
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setString(1, vo.getValorConsulta());
				ptst.setString(2, vo.getCpf());
				ptst.executeUpdate();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				}
		}
	
	}