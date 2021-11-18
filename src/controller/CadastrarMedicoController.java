package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.dao.MedicoDAO;
import model.vo.MedicoVO;
import view.Telas;

public class CadastrarMedicoController extends Telas{
	
	@FXML TextField nome;
	@FXML TextField endereco;
	@FXML TextField cpf;
	@FXML TextField crm;
	@FXML TextField especializacao;
	@FXML TextField valorConsulta;
	@FXML TextField login;
	@FXML TextField senha;

	
	public void cadastrar() {
		
		MedicoVO vo = new MedicoVO();
		
		vo.setNome(nome.getText());
		vo.setEndereco(endereco.getText());
		vo.setCpf(cpf.getText());
		vo.setCrm(crm.getText());
		vo.setEspecializacao(especializacao.getText());
		vo.setValorConsulta(valorConsulta.getText());
		vo.setLogin(login.getText());
		vo.setSenha(senha.getText());
		vo.setTipoUsuario(1);
		
		MedicoDAO<MedicoVO> dao = new MedicoDAO<>();
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
			telaListaMedico();
        } catch (Exception e) {
            //TODO: handle exception
        }
	};
}
