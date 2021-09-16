package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.AdministradorVO;


public class AdministradorDAO extends BaseDAO {
	

	public void inserir(AdministradorVO vo) {
		conn = getConnection();
		String sql = "INSERT INTO admnistrador(pessoa_nome,pessoa_endereco,pessoa_cpf,administrador_id) values (?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1,vo.getNome());
			ptst.setString(2,vo.getEndereco());
			ptst.setString(3,vo.getCpf());
			ptst.setLong(4,vo.getId());
			ptst.execute();		
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
		public void removerPorId(AdministradorVO vo) {
			conn = getConnection();
			String sql = "DELETE * FROM administrador WHERE administrador_id = ?";
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
			String sql = "DELETE * FROM administrador";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.executeUpdate();		
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
				
		public List<AdministradorVO> listar() {
			conn = getConnection();
			String sql = "SELECT * FROM administrador";
			Statement st;
			ResultSet rs;
			List<AdministradorVO> administradores = new ArrayList<AdministradorVO>();
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while(rs.next()) {
					AdministradorVO vo = new AdministradorVO();
					vo.setCpf(rs.getString("pessoa_cpf"));
					vo.setEndereco(rs.getString("pessoa_endereco"));
					vo.setNome(rs.getString("pessoa_nome"));

					vo.setId(rs.getLong("administrador_id"));
					administradores.add(vo);
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return administradores;
		}
		
		public void editarNome(AdministradorVO vo) {
			conn = getConnection();
			String sql = "UPDATE administrador SET pessoa_nome = ?";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setString(1,vo.getNome());
				ptst.executeUpdate();		
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		public void editarCpf(AdministradorVO vo) {
			conn = getConnection();
			String sql = "UPDATE administrador SET pessoa_cpf = ?";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setString(1,vo.getCpf());
				ptst.executeUpdate();		
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		public void editarEndereco(AdministradorVO vo) {
			conn = getConnection();
			String sql = "UPDATE administrador SET pessoa_endereco = ?";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setString(1,vo.getEndereco());
				ptst.executeUpdate();		
				} catch (SQLException e) {
					e.printStackTrace();
				}			
		}
		
		public void editarId(AdministradorVO vo) {
			conn = getConnection();
			String sql = "UPDATE administrador SET administrador_id = ?";
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
