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
import model.vo.PessoaVO;

public class ConsultaDAO extends BaseDAO {
	
	public void inserir(ConsultaVO vo, PacienteVO vo2, MedicoVO vo3) {
		conn = getConnection();
		String sql = "INSERT INTO consulta(consulta_data,consulta_horario,consulta_status,pessoa_nome,pessoa_nome,consulta_id) values (?,?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setDate(1,vo.getData());
			ptst.setTime(2,vo.getHorario());
			ptst.setInt(3,vo.getStatus());
			ptst.setLong(4,vo.getId());
			ptst.setString(5,vo3.getDados().getNome());
			ptst.setString(6,vo2.getDados().getNome());
			
			
			ptst.execute();		
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
		public void removerById(ConsultaVO vo) {
			conn = getConnection();
			String sql = "DELETE FROM consulta WHERE id_consulta = ?";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setLong(1,vo.getId());
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
					PessoaVO vo4 = new PessoaVO();
					
					vo.setData(rs.getDate("consulta_data"));
					vo.setHorario(rs.getTime("consulta_horario"));
					vo.setStatus(rs.getInt("consulta_status"));
					vo.setId(rs.getLong("id_consulta"));
					
					vo4.setNome(rs.getString("pessoa_nome"));
					vo2.setDados(vo4);
					vo.setMedico(vo2);
					
					vo4.setNome(rs.getString("pessoa_nome"));
					vo3.setDados(vo4);
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
