package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.MedicoVO;
import model.vo.PacienteVO;
import model.vo.ProntuarioVO;

public class ProntuarioDAO<VO extends ProntuarioVO> extends BaseDAO<VO>{
	
		public void inserir(VO vo) {
		String sql = "INSERT INTO Prontuario(prontuario_data,prontuario_observacoes,pessoa_nome,paciente_id, pessoa_nome,medico_id, prontuario_id) values (?,?,?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1,vo.getData());
			ptst.setString(2,vo.getObservacoes());
			ptst.setString(3,vo.getPaciente().getNome());
			ptst.setLong(4,vo.getPaciente().getId());
			ptst.setString(5,vo.getMedico().getNome());
			ptst.setLong(6,vo.getMedico().getId());
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
	
		public void removerPorId(ProntuarioVO vo) {
			conn = getConnection();
			String sql = "DELETE * FROM prontuario WHERE prontuario_id = ?";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setLong(1,vo.getId());
				ptst.executeUpdate();		
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		public void removerPorMedico(MedicoVO vo) {
			conn = getConnection();
			String sql = "DELETE * FROM prontuario WHERE medico_id = ?";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setLong(1,vo.getId());
				ptst.executeUpdate();		
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		public void removerPorPaciente(PacienteVO vo) {
			conn = getConnection();
			String sql = "DELETE * FROM prontuario WHERE paciente_id = ?";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setLong(1,vo.getId());
				ptst.executeUpdate();		
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		public void removerPorData(ProntuarioVO vo) {
			conn = getConnection();
			String sql = "DELETE * FROM prontuario WHERE prontuario_data = ?";
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
			String sql = "DELETE * FROM prontuario ";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.executeUpdate();		
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		public List<ProntuarioVO> listar() {
			conn = getConnection();
			String sql = "SELECT * FROM prontuario";
			Statement st;
			ResultSet rs;
			List<ProntuarioVO> prontuarios = new ArrayList<ProntuarioVO>();
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while(rs.next()) {
					ProntuarioVO vo = new ProntuarioVO();
					MedicoVO vo2 = new MedicoVO();
					PacienteVO vo3 = new PacienteVO();
					
					vo.setData(rs.getString("prontuario_data"));
					vo.setObservacoes(rs.getString("prontuario_observacoes"));
					vo.setId(rs.getLong("prontuario_id"));
					
					vo3.setNome(rs.getString("pessoa_nome"));
					vo.setPaciente(vo3);
					
					vo2.setNome(rs.getString("pessoa_nome"));
					vo.setMedico(vo2);

					prontuarios.add(vo);
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return prontuarios;
		}
		
		public List<ProntuarioVO> listarPorData(ProntuarioVO vo) {
			conn = getConnection();
			String sql = "SELECT * FROM prontuario WHERE pronturario_data = ?";
			PreparedStatement ptst;	
			Statement st;
			ResultSet rs;
			List<ProntuarioVO> prontuarios = new ArrayList<ProntuarioVO>();
			try {
				ptst = conn.prepareStatement(sql);
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				ptst.setString(1,vo.getData());
				
				while(rs.next()) {
					MedicoVO vo2 = new MedicoVO();
					PacienteVO vo3 = new PacienteVO();
					
					vo.setData(rs.getString("prontuario_data"));
					vo.setObservacoes(rs.getString("prontuario_observacoes"));
					vo.setId(rs.getLong("prontuario_id"));
					
					vo2.setNome(rs.getString("pessoa_nome"));
					vo.setMedico(vo2);
					
					vo3.setNome(rs.getString("pessoa_nome"));
					vo.setPaciente(vo3);

					prontuarios.add(vo);
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return prontuarios;
		}
		
		public List<ProntuarioVO> listarPorId(ProntuarioVO vo) {
			conn = getConnection();
			String sql = "SELECT * FROM prontuario WHERE pronturario_id = ?";
			PreparedStatement ptst;	
			Statement st;
			ResultSet rs;
			List<ProntuarioVO> prontuarios = new ArrayList<ProntuarioVO>();
			try {
				ptst = conn.prepareStatement(sql);
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				ptst.setLong(1,vo.getId());
				
				while(rs.next()) {
					MedicoVO vo2 = new MedicoVO();
					PacienteVO vo3 = new PacienteVO();
					
					vo.setData(rs.getString("prontuario_data"));
					vo.setObservacoes(rs.getString("prontuario_observacoes"));
					vo.setId(rs.getLong("prontuario_id"));
					
					vo2.setNome(rs.getString("pessoa_nome"));
					vo.setMedico(vo2);
					
					vo3.setNome(rs.getString("pessoa_nome"));
					vo.setPaciente(vo3);

					prontuarios.add(vo);
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return prontuarios;
		}
		
		public List<ProntuarioVO> listarPorPaciente(PacienteVO vo3) {
			conn = getConnection();
			String sql = "SELECT * FROM prontuario WHERE paciente_id = ?";
			PreparedStatement ptst;	
			Statement st;
			ResultSet rs;
			List<ProntuarioVO> prontuarios = new ArrayList<ProntuarioVO>();
			try {
				ptst = conn.prepareStatement(sql);
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				ptst.setLong(1,vo3.getId());
				while(rs.next()) {
					MedicoVO vo2 = new MedicoVO();
					ProntuarioVO vo = new ProntuarioVO();
					vo.setData(rs.getString("prontuario_data"));
					vo.setObservacoes(rs.getString("prontuario_observacoes"));
					vo.setId(rs.getLong("prontuario_id"));
					
					vo2.setNome(rs.getString("pessoa_nome"));
					vo.setMedico(vo2);
					
					vo3.setNome(rs.getString("pessoa_nome"));
					vo.setPaciente(vo3);

					prontuarios.add(vo);
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return prontuarios;
		}
		
		public List<ProntuarioVO> listarPorMedico(MedicoVO vo2) {
			conn = getConnection();
			String sql = "SELECT * FROM prontuario WHERE medico_id = ?";
			PreparedStatement ptst;	
			Statement st;
			ResultSet rs;
			List<ProntuarioVO> prontuarios = new ArrayList<ProntuarioVO>();
			try {
				ptst = conn.prepareStatement(sql);
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				ptst.setLong(1,vo2.getId());
				while(rs.next()) {
					PacienteVO vo3 = new PacienteVO();
					ProntuarioVO vo = new ProntuarioVO();
					vo.setData(rs.getString("prontuario_data"));
					vo.setObservacoes(rs.getString("prontuario_observacoes"));
					vo.setId(rs.getLong("prontuario_id"));
					
					vo2.setNome(rs.getString("pessoa_nome"));
					vo.setMedico(vo2);
					
					vo3.setNome(rs.getString("pessoa_nome"));
					vo.setPaciente(vo3);

					prontuarios.add(vo);
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return prontuarios;
		}
		
		public void editarObservacoes(ProntuarioVO vo) {
			conn = getConnection();
			String sql = "UPDATE prontuario SET prontuario_observacoes = ?";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setString(1,vo.getObservacoes());
				ptst.executeUpdate();		
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		public void editarData(ProntuarioVO vo) {
			conn = getConnection();
			String sql = "UPDATE prontuario SET prontuario_data = ?";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setString(1,vo.getData());
				ptst.executeUpdate();		
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		public void editarId(ProntuarioVO vo) {
			conn = getConnection();
			String sql = "UPDATE prontuario SET prontuario_id = ?";
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