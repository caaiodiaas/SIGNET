package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.ConsultaVO;
import model.vo.PacienteVO;
import model.vo.PessoaVO;
import model.vo.ProntuarioVO;

public class PacienteDAO extends BaseDAO {
	
	public void inserir(PessoaVO vo, ConsultaVO vo2, ProntuarioVO vo3, PacienteVO vo4) {
		conn = getConnection();
		String sql = "INSERT INTO paciente(pessoa_nome,pessoa_endereco,pessoa_cpf,pessoa_id) values (?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1,vo.getNome());
			ptst.setString(2,vo.getEndereco());
			ptst.setString(3,vo.getCpf());
			ptst.setLong(4,vo4.getId());
			//ptst.setConsulta(5,vo4.getConsulta());
			//ptst.setProntuario(6,vo4.getProntuario());
			ptst.execute();		
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
		public void removerByCpf(PessoaVO vo) {
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
					PessoaVO vo = new PessoaVO();
					PacienteVO vo2 = new PacienteVO();
					vo2.setId(rs.getLong("pessoa_id"));
					vo.setCpf(rs.getString("pessoa_cpf"));
					vo.setEndereco(rs.getString("pessoa_endereco"));
					vo.setNome(rs.getString("pessoa_nome"));
					vo2.setDados(vo);
					pacientes.add(vo2);
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return pacientes;
		}
		public void editar(PessoaVO vo) {
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