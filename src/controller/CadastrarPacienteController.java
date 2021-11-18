package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.dao.PacienteDAO;
import model.vo.PacienteVO;
import view.Telas;

public class CadastrarPacienteController extends Telas{
	
	@FXML TextField nome;
	@FXML TextField endereco;
	@FXML TextField cpf;
	@FXML TextField login;
	@FXML TextField senha;

	
	public void cadastrar() {
		
		PacienteVO vo = new PacienteVO();
		
		vo.setNome(nome.getText());
		vo.setEndereco(endereco.getText());
		vo.setCpf(cpf.getText());
		vo.setLogin(login.getText());
		vo.setSenha(senha.getText());
		vo.setTipoUsuario(2);
		
		PacienteDAO<PacienteVO> dao = new PacienteDAO<>();
		dao.inserir(vo);
		voltar();


	};
	
	public void remover() {
		try {

        } catch (Exception e) {
            //TODO: handle exception
        }
	};
	
	public void voltar() {
		try {
			telaListaPaciente();
        } catch (Exception e) {
            //TODO: handle exception
        }
	};
	
}
