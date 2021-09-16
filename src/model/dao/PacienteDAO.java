package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.ConsultaVO;
import model.vo.PacienteVO;
import model.vo.ProntuarioVO;

public class PacienteDAO extends BaseDAO {
	
		public void inserir(ConsultaVO vo, ProntuarioVO vo2, PacienteVO vo3) {
		conn = getConnection();
		String sql = "INSERT INTO paciente(pessoa_nome,pessoa_endereco,pessoa_cpf,paciente_id) values (?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1,vo3.getNome());
			ptst.setString(2,vo3.getEndereco());
			ptst.setString(3,vo3.getCpf());
			ptst.setLong(4,vo3.getId());
			ptst.execute();		
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
		
		public void removerPorCpf(PacienteVO vo) {
			conn = getConnection();
			String sql = "DELETE * FROM paciente WHERE pessoa_cpf = ?";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setString(1,vo.getCpf());
				ptst.executeUpdate();		
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		public void removerPorNome(PacienteVO vo) {
			conn = getConnection();
			String sql = "DELETE * FROM paciente WHERE pessoa_nome = ?";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setString(1,vo.getNome());
				ptst.executeUpdate();		
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		public void removerPorId(PacienteVO vo) {
			conn = getConnection();
			String sql = "DELETE * FROM paciente WHERE paciente_id = ?";
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
			String sql = "DELETE * FROM paciente";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.executeUpdate();		
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		public List<PacienteVO> listar() {
			conn = getConnection();
			String sql = "SELECT * FROM paciente = ?";
			Statement st;
			ResultSet rs;
			ConsultaDAO dao = new ConsultaDAO();
			List<PacienteVO> pacientes = new ArrayList<PacienteVO>();
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while(rs.next()) {
					PacienteVO vo = new PacienteVO();
					vo.setId(rs.getLong("pessoa_id"));
					vo.setCpf(rs.getString("pessoa_cpf"));
					vo.setEndereco(rs.getString("pessoa_endereco"));
					vo.setNome(rs.getString("pessoa_nome"));
					
					List<ConsultaVO> consultas = dao.listarPorPaciente(vo);
					vo.setConsultas(consultas);
					
					pacientes.add(vo);
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return pacientes;
		}
				
		public List<PacienteVO> listarPorCpf(PacienteVO vo) {
			conn = getConnection();
			String sql = "SELECT * FROM paciente WHERE pessoa_cpf = ?";
			Statement st;
			ResultSet rs;
			ConsultaDAO dao = new ConsultaDAO();
			List<PacienteVO> pacientes = new ArrayList<PacienteVO>();
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while(rs.next()) {
					vo.setId(rs.getLong("pessoa_id"));
					vo.setCpf(rs.getString("pessoa_cpf"));
					vo.setEndereco(rs.getString("pessoa_endereco"));
					vo.setNome(rs.getString("pessoa_nome"));
					
					List<ConsultaVO> consultas = dao.listarPorPaciente(vo);
					vo.setConsultas(consultas);
					
					pacientes.add(vo);
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return pacientes;
		}
				
		public List<PacienteVO> listarPorId(PacienteVO vo) {
			conn = getConnection();
			String sql = "SELECT * FROM paciente WHERE paciente_id = ?";
			Statement st;
			ResultSet rs;
			ConsultaDAO dao = new ConsultaDAO();
			List<PacienteVO> pacientes = new ArrayList<PacienteVO>();
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while(rs.next()) {
					vo.setId(rs.getLong("pessoa_id"));
					vo.setCpf(rs.getString("pessoa_cpf"));
					vo.setEndereco(rs.getString("pessoa_endereco"));
					vo.setNome(rs.getString("pessoa_nome"));
					
					List<ConsultaVO> consultas = dao.listarPorPaciente(vo);
					vo.setConsultas(consultas);
					
					pacientes.add(vo);
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return pacientes;
		}
		
		public List<PacienteVO> listarPorNome(PacienteVO vo) {
			conn = getConnection();
			String sql = "SELECT * FROM paciente WHERE pessoa_nome = ?";
			Statement st;
			ResultSet rs;
			ConsultaDAO dao = new ConsultaDAO();
			List<PacienteVO> pacientes = new ArrayList<PacienteVO>();
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while(rs.next()) {
					vo.setId(rs.getLong("pessoa_id"));
					vo.setCpf(rs.getString("pessoa_cpf"));
					vo.setEndereco(rs.getString("pessoa_endereco"));
					vo.setNome(rs.getString("pessoa_nome"));
					
					List<ConsultaVO> consultas = dao.listarPorPaciente(vo);
					vo.setConsultas(consultas);
					
					pacientes.add(vo);
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return pacientes;
		}
		
		public void editarNome(PacienteVO vo) {
			conn = getConnection();
			String sql = "UPDATE paciente SET pessoa_nome = ?";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setString(1,vo.getNome());
				ptst.executeUpdate();		
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		public void editarCpf(PacienteVO vo) {
			conn = getConnection();
			String sql = "UPDATE paciente SET pessoa_cpf = ?";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setString(1,vo.getCpf());
				ptst.executeUpdate();		
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		public void editarEndereco(PacienteVO vo) {
			conn = getConnection();
			String sql = "UPDATE paciente SET pessoa_endereco = ?";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setString(1,vo.getEndereco());
				ptst.executeUpdate();		
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		public void editarId(PacienteVO vo) {
			conn = getConnection();
			String sql = "UPDATE paciente SET paciente_id = ?";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setLong(1,vo.getId());
				ptst.executeUpdate();		
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}