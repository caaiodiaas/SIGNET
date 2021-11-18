package controller;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.bo.ConsultaBO;
import model.bo.MedicoBO;
import model.bo.UsuarioBO;
import model.dao.MedicoDAO;
import model.vo.ConsultaVO;
import model.vo.MedicoVO;
import model.vo.UsuarioVO;
import view.Telas;

public class TelaMedicoController extends Telas{

	@FXML private TextField textoValorConsultaMedico;
	@FXML private TextField textoEspecializacaoMedico;
	@FXML private TextField textoIdMedico;
	@FXML private TextField textoNomeMedico;
	@FXML private TextField textoEnderecoMedico;
	@FXML private TextField textoCrmMedico;
	@FXML private TextField textoCpfMedico;
	@FXML private Button botaoSalvarMedico;
	@FXML private Button botaoRemoverMedico;
	@FXML private Button botaoVoltarMedico;
	@FXML private Button botaoEditarMedico;
	@FXML private Label labelNome;
	@FXML private Label labelCpf;
	@FXML private Label labelCrm;
	@FXML private Label labelEndereco;
	@FXML private Label labelEspecializacao;
	@FXML private Label labelValorConsulta;

	
	public void initialize (URL url,ResourceBundle rb) throws Exception {
	
	    MedicoVO vo = new MedicoVO();
	    MedicoBO medBO = new MedicoBO();
	    vo = medBO.buscarPorCpf(vo);
	    
	    
        labelNome.setText(vo.getNome());
		labelCrm.setText(vo.getCrm());
		labelEndereco.setText(vo.getEndereco());
		labelEspecializacao.setText(vo.getEspecializacao());
		labelValorConsulta.setText(vo.getValorConsulta());

	}
	
	

	
	public void editar(ActionEvent event) {
		try {
			textoValorConsultaMedico.setVisible(true);
			textoEspecializacaoMedico.setVisible(true);
			textoNomeMedico.setVisible(true);
			textoEnderecoMedico.setVisible(true);
			textoCrmMedico.setVisible(true);
			textoValorConsultaMedico.setEditable(true);
			textoEspecializacaoMedico.setEditable(true);
			textoNomeMedico.setEditable(true);
			textoEnderecoMedico.setEditable(true);
			textoCrmMedico.setEditable(true);
			botaoSalvarMedico.setVisible(true);
			botaoRemoverMedico.setVisible(true);
			labelNome.setVisible(false);
			labelCrm.setVisible(false);
			labelEndereco.setVisible(false);
			labelEspecializacao.setVisible(false);
			labelValorConsulta.setVisible(false);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
	
	public void salvar(ActionEvent event) {
		try {
			textoValorConsultaMedico.setEditable(false);
			textoEspecializacaoMedico.setEditable(false);
			textoNomeMedico.setEditable(false);
			textoEnderecoMedico.setEditable(false);
			textoCrmMedico.setEditable(false);
			botaoSalvarMedico.setVisible(false);
			botaoRemoverMedico.setVisible(false);
			
			MedicoVO vo = new MedicoVO();
			
			vo.setValorConsulta(textoValorConsultaMedico.getText());
			vo.setEspecializacao(textoEspecializacaoMedico.getText());
			vo.setNome(textoNomeMedico.getText());
			vo.setEndereco(textoEnderecoMedico.getText());
			vo.setCrm(textoCrmMedico.getText());
			
			labelNome.setText(vo.getNome());
			labelCrm.setText(vo.getCrm());
			labelEndereco.setText(vo.getEndereco());
			labelEspecializacao.setText(vo.getEspecializacao());
			labelValorConsulta.setText(vo.getValorConsulta());
			labelNome.setVisible(true);
			labelCrm.setVisible(true);
			labelEndereco.setVisible(true);
			labelEspecializacao.setVisible(true);
			labelValorConsulta.setVisible(true);
			
			textoValorConsultaMedico.setVisible(false);
			textoEspecializacaoMedico.setVisible(false);
			textoNomeMedico.setVisible(false);
			textoEnderecoMedico.setVisible(false);
			textoCrmMedico.setVisible(false);

			} catch (Exception e) {
			e.printStackTrace();
		}
	};
	

	
	public void abrirConsulta() {
		try {
			telaListaConsulta();
		} catch (Exception e) {
			e.printStackTrace();
		}
	};

	
	public void remover() {
		try {
			telaListaConsulta();
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
	
	public void voltar(ActionEvent event) {
		try {
			Telas.telaLogin();
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
}