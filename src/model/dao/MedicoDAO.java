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
		String sql = "INSERT INTO medico(pessoa_nome,pessoa_endereco,pessoa_cpf, medicos_crm, medicos_valor_consulta,medicos_especializacao) values (?,?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1,vo.getNome());
			ptst.setString(2,vo.getEndereco());
			ptst.setString(3,vo.getCpf());
			ptst.setString(4,vo.getCrm());
			ptst.setFloat(5,vo.getValorConsulta());
			ptst.setString(6,vo.getEspecializacao());
			
			//ptst.setConsultas(7,vo3.getConsultas());
			
			ptst.execute();		
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
		public void removerByCrm(MedicoVO vo) {
			conn = getConnection();
			String sql = "DELETE FROM medico WHERE medicos_crm = ?";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setString(1,vo.getCrm());
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
			List<MedicoVO> medicos = new ArrayList<MedicoVO>();
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while(rs.next()) {
					MedicoVO vo = new MedicoVO();
					vo.setCpf(rs.getString("pessoa_cpf"));
					vo.setEndereco(rs.getString("pessoa_endereco"));
					vo.setNome(rs.getString("pessoa_nome"));
					vo.setCrm(rs.getString("medicos_crm"));
					vo.setValorConsulta(rs.getFloat("medicos_valor_consulta"));
					vo.setEspecializacao(rs.getString("medicos_especializacao"));
					medicos.add(vo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return medicos;
		}
		public void editar(MedicoVO vo) {
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
	}