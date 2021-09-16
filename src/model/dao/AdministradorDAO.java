package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.AdministradorVO;
import model.vo.PessoaVO;


public class AdministradorDAO extends BaseDAO {
	
	public void inserir(AdministradorVO vo) {
		conn = getConnection();
		String sql = "INSERT INTO Admnistrador(pessoa_nome,pessoa_endereco,pessoa_cpf,pessoa_id) values (?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1,vo.getNome());
			ptst.setString(2,vo.getEndereco());
			ptst.setString(3,vo.getCpf());
			ptst.execute();		
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
		public void removerByCpf(AdministradorVO vo) {
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
					administradores.add(vo);
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return administradores;
		}
		
		public void editar(AdministradorVO vo) {
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
	}
