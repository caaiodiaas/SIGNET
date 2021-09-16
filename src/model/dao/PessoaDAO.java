package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.PessoaVO;

public class PessoaDAO extends BaseDAO {
	
		public void inserir(PessoaVO vo) {
		conn = getConnection();
		String sql = "INSERT INTO pessoa(pessoa_nome,pessoa_endereco,pessoa_cpf) values (?,?,?)";
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
		
		public void removerPorCpf(PessoaVO vo) {
			conn = getConnection();
			String sql = "DELETE * FROM pessoa WHERE pessoa_cpf = ?";
			PreparedStatement ptst;
			try {
				ptst = conn.prepareStatement(sql);
				ptst.setString(1,vo.getCpf());
				ptst.executeUpdate();		
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		public List<PessoaVO> listar() {
			conn = getConnection();
			String sql = "SELECT * FROM pessoa";
			Statement st;
			ResultSet rs;
			List<PessoaVO> pessoas = new ArrayList<PessoaVO>();
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while(rs.next()) {
					PessoaVO vo = new PessoaVO();
					vo.setCpf(rs.getString("pessoa_cpf"));
					vo.setEndereco(rs.getString("pessoa_endereco"));
					vo.setNome(rs.getString("pessoa_nome"));
					pessoas.add(vo);
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return pessoas;
		}
		
		public void editar(PessoaVO vo) {
			conn = getConnection();
			String sql = "UPDATE pessoa SET pessoa_nome = ?";
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