package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.ConsultaVO;
import model.vo.MedicoVO;

public class MedicoDAO extends BaseDAO {
	
		public void inserir(MedicoVO vo, ConsultaVO vo2) {
		conn = getConnection();
		String sql = "INSERT INTO medico(pessoa_nome,pessoa_endereco,pessoa_cpf, medico_crm, medico_valor_consulta,medico_especializacao) values (?,?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1,vo.getNome());
			ptst.setString(2,vo.getEndereco());
			ptst.setString(3,vo.getCpf());
			ptst.setString(4,vo.getCrm());
			ptst.setFloat(5,vo.getValorConsulta());
			ptst.setString(6,vo.getEspecializacao());
			
			ptst.execute();		
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
		public void removerPorCrm(MedicoVO vo) {
			conn = getConnection();
			String sql = "DELETE * FROM medico WHERE medico_crm = ?";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setString(1,vo.getCrm());
				ptst.executeUpdate();		
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		public void removerPorCpf(MedicoVO vo) {
			conn = getConnection();
			String sql = "DELETE * FROM medico WHERE medico_cpf = ?";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setString(1,vo.getCpf());
				ptst.executeUpdate();		
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
				
		public void removerPorNome(MedicoVO vo) {
			conn = getConnection();
			String sql = "DELETE * FROM medico WHERE pessoa_nome = ?";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setString(1,vo.getNome());
				ptst.executeUpdate();		
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		public void removerPorEspecializacao(MedicoVO vo) {
			conn = getConnection();
			String sql = "DELETE * FROM medico WHERE medico_especializacao = ?";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setString(1,vo.getEspecializacao());
				ptst.executeUpdate();		
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		public void removerPorId(MedicoVO vo) {
			conn = getConnection();
			String sql = "DELETE * FROM medico WHERE medico_id = ?";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setLong(1,vo.getId());
				ptst.executeUpdate();		
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		public void removerTudo() {
			conn = getConnection();
			String sql = "DELETE * FROM medico";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.executeUpdate();		
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
				
		public List<MedicoVO> listar() {
			conn = getConnection();
			String sql = "SELECT * FROM medico";
			Statement st;
			ResultSet rs;

			ConsultaDAO dao = new ConsultaDAO();
			List<MedicoVO> medicos = new ArrayList<MedicoVO>();
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while(rs.next()) {
					MedicoVO vo = new MedicoVO();
					vo.setCpf(rs.getString("pessoa_cpf"));
					vo.setEndereco(rs.getString("pessoa_endereco"));
					vo.setNome(rs.getString("pessoa_nome"));
					vo.setCrm(rs.getString("medico_crm"));
					vo.setValorConsulta(rs.getFloat("medico_valor_consulta"));
					vo.setEspecializacao(rs.getString("medico_especializacao"));
					
					List<ConsultaVO> consultas = dao.listarPorMedico(vo);
					vo.setConsultas(consultas);
					
					medicos.add(vo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return medicos;
		}
		
		public List<MedicoVO> listarPorCpf(MedicoVO vo) {
			conn = getConnection();
			String sql = "SELECT * FROM medico WHERE pessoa_cpf = ?";
			PreparedStatement ptst;
			Statement st;
			ResultSet rs;
			ConsultaDAO dao = new ConsultaDAO();
			List<MedicoVO> medicos = new ArrayList<MedicoVO>();
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				ptst = conn.prepareStatement(sql);
				ptst.setString(1,vo.getCpf());
				
				while(rs.next()) {					
					vo.setCpf(rs.getString("pessoa_cpf"));
					vo.setEndereco(rs.getString("pessoa_endereco"));
					vo.setNome(rs.getString("pessoa_nome"));
					vo.setCrm(rs.getString("medico_crm"));
					vo.setValorConsulta(rs.getFloat("medico_valor_consulta"));
					vo.setEspecializacao(rs.getString("medico_especializacao"));
					
					List<ConsultaVO> consultas = dao.listarPorMedico(vo);
					vo.setConsultas(consultas);
					
					medicos.add(vo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return medicos;
		}
		
		public List<MedicoVO> listarPorCrm(MedicoVO vo) {
			conn = getConnection();
			String sql = "SELECT * FROM medico WHERE medico_crm = ?";
			PreparedStatement ptst;
			Statement st;
			ResultSet rs;
			ConsultaDAO dao = new ConsultaDAO();
			List<MedicoVO> medicos = new ArrayList<MedicoVO>();
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				ptst = conn.prepareStatement(sql);
				ptst.setString(1,vo.getCrm());
				
				while(rs.next()) {					
					vo.setCpf(rs.getString("pessoa_cpf"));
					vo.setEndereco(rs.getString("pessoa_endereco"));
					vo.setNome(rs.getString("pessoa_nome"));
					vo.setCrm(rs.getString("medico_crm"));
					vo.setValorConsulta(rs.getFloat("medico_valor_consulta"));
					vo.setEspecializacao(rs.getString("medico_especializacao"));
					
					List<ConsultaVO> consultas = dao.listarPorMedico(vo);
					vo.setConsultas(consultas);
					
					medicos.add(vo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return medicos;
		}
		
		public List<MedicoVO> listarPorNome(MedicoVO vo) {
			conn = getConnection();
			String sql = "SELECT * FROM medico WHERE pessoa_nome = ?";
			PreparedStatement ptst;
			Statement st;
			ResultSet rs;
			ConsultaDAO dao = new ConsultaDAO();
			List<MedicoVO> medicos = new ArrayList<MedicoVO>();
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				ptst = conn.prepareStatement(sql);
				ptst.setString(1,vo.getNome());
				
				while(rs.next()) {					
					vo.setCpf(rs.getString("pessoa_cpf"));
					vo.setEndereco(rs.getString("pessoa_endereco"));
					vo.setNome(rs.getString("pessoa_nome"));
					vo.setCrm(rs.getString("medico_crm"));
					vo.setValorConsulta(rs.getFloat("medico_valor_consulta"));
					vo.setEspecializacao(rs.getString("medico_especializacao"));
					
					List<ConsultaVO> consultas = dao.listarPorMedico(vo);
					vo.setConsultas(consultas);
					
					medicos.add(vo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return medicos;
		}
		
		public List<MedicoVO> listarPorId(MedicoVO vo) {
			conn = getConnection();
			String sql = "SELECT * FROM medico WHERE medico_id = ?";
			PreparedStatement ptst;
			Statement st;
			ResultSet rs;
			ConsultaDAO dao = new ConsultaDAO();
			List<MedicoVO> medicos = new ArrayList<MedicoVO>();
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				ptst = conn.prepareStatement(sql);
				ptst.setLong(1,vo.getId());
				
				while(rs.next()) {					
					vo.setCpf(rs.getString("pessoa_cpf"));
					vo.setEndereco(rs.getString("pessoa_endereco"));
					vo.setNome(rs.getString("pessoa_nome"));
					vo.setCrm(rs.getString("medico_crm"));
					vo.setValorConsulta(rs.getFloat("medico_valor_consulta"));
					vo.setEspecializacao(rs.getString("medico_especializacao"));
					
					List<ConsultaVO> consultas = dao.listarPorMedico(vo);
					vo.setConsultas(consultas);
					
					medicos.add(vo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return medicos;
		}
		
		public List<MedicoVO> listarPorEspecializacao(MedicoVO vo) {
			conn = getConnection();
			String sql = "SELECT * FROM medico WHERE medico_especializacao = ?";
			PreparedStatement ptst;
			Statement st;
			ResultSet rs;
			ConsultaDAO dao = new ConsultaDAO();
			List<MedicoVO> medicos = new ArrayList<MedicoVO>();
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				ptst = conn.prepareStatement(sql);
				ptst.setString(1,vo.getEspecializacao());
				
				while(rs.next()) {					
					vo.setCpf(rs.getString("pessoa_cpf"));
					vo.setEndereco(rs.getString("pessoa_endereco"));
					vo.setNome(rs.getString("pessoa_nome"));
					vo.setCrm(rs.getString("medico_crm"));
					vo.setValorConsulta(rs.getFloat("medico_valor_consulta"));
					vo.setEspecializacao(rs.getString("medico_especializacao"));
					
					List<ConsultaVO> consultas = dao.listarPorMedico(vo);
					vo.setConsultas(consultas);
					
					medicos.add(vo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return medicos;
		}
		
		public List<MedicoVO> listarPorValorConsulta(MedicoVO vo) {
			conn = getConnection();
			String sql = "SELECT * FROM medico WHERE medico_valor_consulta = ?";
			PreparedStatement ptst;
			Statement st;
			ResultSet rs;
			ConsultaDAO dao = new ConsultaDAO();
			List<MedicoVO> medicos = new ArrayList<MedicoVO>();
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				ptst = conn.prepareStatement(sql);
				ptst.setFloat(1,vo.getValorConsulta());
				
				while(rs.next()) {					
					vo.setCpf(rs.getString("pessoa_cpf"));
					vo.setEndereco(rs.getString("pessoa_endereco"));
					vo.setNome(rs.getString("pessoa_nome"));
					vo.setCrm(rs.getString("medico_crm"));
					vo.setValorConsulta(rs.getFloat("medico_valor_consulta"));
					vo.setEspecializacao(rs.getString("medico_especializacao"));
					
					List<ConsultaVO> consultas = dao.listarPorMedico(vo);
					vo.setConsultas(consultas);
					
					medicos.add(vo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return medicos;
		}
		
		public void editarCrm(MedicoVO vo) {
			conn = getConnection();
			String sql = "UPDATE medico SET medicos_crm = ?";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setString(1,vo.getCrm());
				ptst.executeUpdate();		
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		public void editarCpf(MedicoVO vo) {
			conn = getConnection();
			String sql = "UPDATE medico SET medicos_cpf = ?";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setString(1,vo.getCpf());
				ptst.executeUpdate();		
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		public void editarNome(MedicoVO vo) {
			conn = getConnection();
			String sql = "UPDATE medico SET pessoa_nome = ?";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setString(1,vo.getNome());
				ptst.executeUpdate();		
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		public void editarEndereco(MedicoVO vo) {
			conn = getConnection();
			String sql = "UPDATE medico SET pessoa_endereco = ?";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setString(1,vo.getEndereco());
				ptst.executeUpdate();		
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		public void editarId(MedicoVO vo) {
			conn = getConnection();
			String sql = "UPDATE medico SET medicos_id = ?";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setLong(1,vo.getId());
				ptst.executeUpdate();		
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		public void editarEspecializacao(MedicoVO vo) {
			conn = getConnection();
			String sql = "UPDATE medico SET medicos_especializacao = ?";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setString(1,vo.getEspecializacao());
				ptst.executeUpdate();		
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		public void editarValorConsulta(MedicoVO vo) {
			conn = getConnection();
			String sql = "UPDATE medico SET medicos_valor_consulta = ?";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setFloat(1,vo.getValorConsulta());
				ptst.executeUpdate();		
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	
	}