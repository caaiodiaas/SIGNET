package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.ConsultaVO;
import model.vo.MedicoVO;
import model.vo.PacienteVO;

public class ConsultaDAO extends BaseDAO {
	
		public void inserir(ConsultaVO vo, PacienteVO vo2, MedicoVO vo3) {
		conn = getConnection();
		String sql = "INSERT INTO consulta(consulta_data,consulta_horario,consulta_status,pessoa_nome,paciente_id,pessoa_nome,medico_id,consulta_id) values (?,?,?,?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1,vo.getData());
			ptst.setString(2,vo.getHorario());
			ptst.setInt(3,vo.getStatus());
			ptst.setString(4,vo2.getNome());
			ptst.setLong(5,vo2.getId());
			ptst.setString(6,vo3.getNome());
			ptst.setLong(7,vo3.getId());
			ptst.setLong(8,vo.getId());
			
			
			ptst.execute();		
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
			
		public void removerPorId(ConsultaVO vo) {
			conn = getConnection();
			String sql = "DELETE * FROM consulta WHERE id_consulta = ?";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setLong(1,vo.getId());
				ptst.executeUpdate();		
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		public void removerPorPaciente(ConsultaVO vo) {
			conn = getConnection();
			String sql = "DELETE * FROM consulta WHERE paciente_id = ?";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setLong(1,vo.getPaciente().getId());
				ptst.executeUpdate();		
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		public void removerPorMedico(ConsultaVO vo) {
			conn = getConnection();
			String sql = "DELETE * FROM consulta WHERE medico_id = ?";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setLong(1,vo.getMedico().getId());
				ptst.executeUpdate();		
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		public void removerPorStatus(ConsultaVO vo) {
			conn = getConnection();
			String sql = "DELETE * FROM consulta WHERE consulta_status = ?";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setInt(1,vo.getStatus());
				ptst.executeUpdate();		
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		public void removerPorData(ConsultaVO vo) {
			conn = getConnection();
			String sql = "DELETE * FROM consulta WHERE consulta_data = ?";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setString(1,vo.getData());
				ptst.executeUpdate();		
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		public void removerTudo() {
			conn = getConnection();
			String sql = "DELETE * FROM consulta";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.executeUpdate();		
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		public List<ConsultaVO> listar() {
			conn = getConnection();
			String sql = "SELECT * FROM consulta";
			Statement st;
			ResultSet rs;
			List<ConsultaVO> consultas = new ArrayList<ConsultaVO>();
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while(rs.next()) {
					
					ConsultaVO vo = new ConsultaVO();
					MedicoVO vo2 = new MedicoVO();
					PacienteVO vo3 = new PacienteVO();

					vo.setData(rs.getString("consulta_data"));
					vo.setHorario(rs.getString("consulta_horario"));
					vo.setStatus(rs.getInt("consulta_status"));
					vo.setId(rs.getLong("id_consulta"));
					
					vo2.setNome(rs.getString("pessoa_nome"));
					vo.setMedico(vo2);
					
					vo3.setNome(rs.getString("pessoa_nome"));
					vo.setPaciente(vo3);
					
					consultas.add(vo);
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return consultas;
		}
		
		public List<ConsultaVO> listarPorPaciente(PacienteVO vo3) {
			conn = getConnection();
			String sql = "SELECT * FROM consulta WHERE paciente_id = ?";
			Statement st;
			ResultSet rs;
			List<ConsultaVO> consultas = new ArrayList<ConsultaVO>();
			
			PreparedStatement ptst;

			try {
				ptst = conn.prepareStatement(sql);
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				ptst.setLong(1,vo3.getId());
				while(rs.next()) {
					
					ConsultaVO vo = new ConsultaVO();
					MedicoVO vo2 = new MedicoVO();
					
					vo.setData(rs.getString("consulta_data"));
					vo.setHorario(rs.getString("consulta_horario"));
					vo.setStatus(rs.getInt("consulta_status"));
					vo.setId(rs.getLong("id_consulta"));
					
					vo2.setNome(rs.getString("pessoa_nome"));
					vo2.setId(rs.getLong("medico_id"));
					vo.setMedico(vo2);
					
					vo3.setNome(rs.getString("pessoa_nome"));
					vo3.setId(rs.getLong("paciente_id"));
					vo.setPaciente(vo3);
					
					consultas.add(vo);
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return consultas;
		}
				
		public List<ConsultaVO> listarPorMedico(MedicoVO vo2) {
			conn = getConnection();
			String sql = "SELECT * FROM consulta WHERE medico_id = ?";
			Statement st;
			ResultSet rs;
			List<ConsultaVO> consultas = new ArrayList<ConsultaVO>();
			
			PreparedStatement ptst;

			try {
				ptst = conn.prepareStatement(sql);
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				ptst.setLong(1,vo2.getId());
				while(rs.next()) {
					
					ConsultaVO vo = new ConsultaVO();
					PacienteVO vo3 = new PacienteVO();
					
					vo.setData(rs.getString("consulta_data"));
					vo.setHorario(rs.getString("consulta_horario"));
					vo.setStatus(rs.getInt("consulta_status"));
					vo.setId(rs.getLong("id_consulta"));
					
					vo2.setNome(rs.getString("pessoa_nome"));
					vo2.setId(rs.getLong("medico_id"));
					vo.setMedico(vo2);
					
					vo3.setNome(rs.getString("pessoa_nome"));
					vo3.setId(rs.getLong("paciente_id"));
					vo.setPaciente(vo3);
					
					consultas.add(vo);
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return consultas;
		}
			
		public List<ConsultaVO> listarPorData(ConsultaVO vo) {
			conn = getConnection();
			String sql = "SELECT * FROM consulta WHERE consulta_data = ?";
			Statement st;
			ResultSet rs;
			List<ConsultaVO> consultas = new ArrayList<ConsultaVO>();
			
			PreparedStatement ptst;

			try {
				ptst = conn.prepareStatement(sql);
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				ptst.setString(1,vo.getData());
				while(rs.next()) {
					
					MedicoVO vo2 = new MedicoVO();
					PacienteVO vo3 = new PacienteVO();
					
					vo.setData(rs.getString("consulta_data"));
					vo.setHorario(rs.getString("consulta_horario"));
					vo.setStatus(rs.getInt("consulta_status"));
					vo.setId(rs.getLong("id_consulta"));
					
					vo2.setNome(rs.getString("pessoa_nome"));
					vo2.setId(rs.getLong("medico_id"));
					vo.setMedico(vo2);
					
					vo3.setNome(rs.getString("pessoa_nome"));
					vo3.setId(rs.getLong("paciente_id"));
					vo.setPaciente(vo3);
					
					consultas.add(vo);
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return consultas;
		}
		
		public List<ConsultaVO> listarPorStatus(ConsultaVO vo) {
			conn = getConnection();
			String sql = "SELECT * FROM consulta WHERE consulta_status = ?";
			Statement st;
			ResultSet rs;
			List<ConsultaVO> consultas = new ArrayList<ConsultaVO>();
			
			PreparedStatement ptst;

			try {
				ptst = conn.prepareStatement(sql);
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				ptst.setInt(1,vo.getStatus());
				while(rs.next()) {
					
					MedicoVO vo2 = new MedicoVO();
					PacienteVO vo3 = new PacienteVO();
					
					vo.setData(rs.getString("consulta_data"));
					vo.setHorario(rs.getString("consulta_horario"));
					vo.setStatus(rs.getInt("consulta_status"));
					vo.setId(rs.getLong("id_consulta"));
					
					vo2.setNome(rs.getString("pessoa_nome"));
					vo2.setId(rs.getLong("medico_id"));
					vo.setMedico(vo2);
					
					vo3.setNome(rs.getString("pessoa_nome"));
					vo3.setId(rs.getLong("paciente_id"));
					vo.setPaciente(vo3);
					
					consultas.add(vo);
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return consultas;
		}
		
		public void editar(ConsultaVO vo) {
			conn = getConnection();
			String sql = "UPDATE consulta SET consulta_status = ?";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setInt(1,vo.getStatus());
				ptst.executeUpdate();		
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
