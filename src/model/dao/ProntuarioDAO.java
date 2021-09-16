package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.MedicoVO;
import model.vo.PacienteVO;
import model.vo.PessoaVO;
import model.vo.ProntuarioVO;

public class ProntuarioDAO extends BaseDAO {
	
	public void inserir(ProntuarioVO vo,MedicoVO vo2, PacienteVO vo3) {
		conn = getConnection();
		String sql = "INSERT INTO Prontuario(prontuario_data,prontuario_observacoes,pessoa_nome, pessoa_nome, prontuario_id) values (?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setDate(1,vo.getData());
			ptst.setString(2,vo.getObservacoes());
			ptst.setLong(3,vo.getId());
			ptst.setString(5,vo2.getNome());
			ptst.setString(6,vo3.getNome());
			ptst.execute();		
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
		public void removerByCrm(ProntuarioVO vo) {
			conn = getConnection();
			String sql = "DELETE FROM prontuario WHERE prontuario_id = ?";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setLong(1,vo.getId());
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
					
					vo.setData(rs.getDate("prontuario_data"));
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
		public void editar(ProntuarioVO vo) {
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
	}