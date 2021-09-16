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
		String sql = "INSERT INTO paciente(pessoa_nome,pessoa_endereco,pessoa_cpf,pessoa_id) values (?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1,vo3.getNome());
			ptst.setString(2,vo3.getEndereco());
			ptst.setString(3,vo3.getCpf());
			ptst.setLong(4,vo3.getId());
			//ptst.setConsulta(5,vo3.getConsulta());
			//ptst.setProntuarios(6,vo3.getProntuario());
			ptst.execute();		
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
		public void removerByCpf(PacienteVO vo) {
			conn = getConnection();
			String sql = "DELETE FROM paciente WHERE pessoa_cpf = ?";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setString(1,vo.getCpf());
				ptst.executeUpdate();		
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		public List<PacienteVO> listar() {
			conn = getConnection();
			String sql = "SELECT * FROM paciente";
			Statement st;
			ResultSet rs;
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
					pacientes.add(vo);
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return pacientes;
		}
		public void editar(PacienteVO vo) {
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
	}