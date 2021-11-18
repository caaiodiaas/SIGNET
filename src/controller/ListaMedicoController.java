package controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import model.bo.MedicoBO;
import model.dao.MedicoDAO;
import model.vo.MedicoVO;
import view.Telas;

public class ListaMedicoController extends Telas implements Initializable{
	
	@FXML private TableView<MedicoVO> tabelaMedico;
    @FXML private TableColumn<MedicoVO, String> colunaMedico;
    @FXML private TableColumn<MedicoVO, String> colunaEspecializacao;
	@FXML private TableColumn<MedicoVO, String> colunaCrm;
	@FXML private TableColumn<MedicoVO, Long> colunaId;
	@FXML private TitledPane telaDados;
	
	@FXML private TextField acessarNome;
	@FXML private TextField acessarCrm;
	@FXML private TextField acessarEspecializacao;
	@FXML private TextField acessarValorConsulta;
	@FXML private TextField acessarEndereco;
	@FXML private TextField acessarCpf;
	@FXML private Button acessarSalvar;
	@FXML private Button acessarRemover;
	
	@FXML private TextField pesquisaMedico;

		
	public void initialize (URL url,ResourceBundle rb) {
		
		colunaMedico.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		colunaEspecializacao.setCellValueFactory(new PropertyValueFactory<>("Especializacao"));
		colunaCrm.setCellValueFactory(new PropertyValueFactory<>("Crm"));
		colunaId.setCellValueFactory(new PropertyValueFactory<>("Id"));
		
		try {
			tabelaMedico.setItems(listaDeMedicos());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    private ObservableList<MedicoVO> listaDeMedicos() throws Exception {
    	MedicoBO bo = new MedicoBO();
    	List<MedicoVO> list = bo.buscarTudo();
    	ObservableList<MedicoVO> medicosList = FXCollections.observableArrayList(list);
        return medicosList;
    }
    
    private ObservableList<MedicoVO> listaDeMedicos(MedicoVO vo) throws Exception {
    	MedicoBO bo = new MedicoBO();
    	List<MedicoVO> list = bo.buscar(vo);
    	ObservableList<MedicoVO> medicosList = FXCollections.observableArrayList(list);
        return medicosList;
    }
    
	public void buscar() throws Exception {
		
		MedicoVO vo = new MedicoVO();
		
		vo.setNome(pesquisaMedico.getText());
		vo.setCpf(pesquisaMedico.getText());
		vo.setEspecializacao(pesquisaMedico.getText());
		vo.setCrm(pesquisaMedico.getText());
		if(pesquisaMedico.getText().equals("") || pesquisaMedico.getText() == null) {
			tabelaMedico.setItems(listaDeMedicos());
		}
		
		tabelaMedico.setItems(listaDeMedicos(vo));

	};
	
	public void adicionar() {
		try {
			telaCadastrarMedico();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};

	public void editar() {
		acessarNome.setEditable(true);
		acessarCrm.setEditable(true);
		acessarEspecializacao.setEditable(true);
		acessarValorConsulta.setEditable(true);
		acessarEndereco.setEditable(true);
		acessarSalvar.setVisible(true);
		acessarRemover.setVisible(true);
		
	};
	public void salvar() {
		MedicoDAO<MedicoVO> dao = new MedicoDAO<>();
		MedicoVO vo = new MedicoVO();
		vo.setCpf(acessarCpf.getText());
		vo.setNome(acessarNome.getText());
		vo.setCrm(acessarCrm.getText());
		vo.setEspecializacao(acessarEspecializacao.getText());
		vo.setEndereco(acessarEndereco.getText());
		vo.setValorConsulta(acessarValorConsulta.getText());
		try {
			dao.editar(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		acessarNome.setEditable(false);
		acessarCrm.setEditable(false);
		acessarEspecializacao.setEditable(false);
		acessarValorConsulta.setEditable(false);
		acessarEndereco.setEditable(false);
		acessarSalvar.setVisible(false);
		acessarRemover.setVisible(false);
		telaDados.setVisible(false);
		try {
			tabelaMedico.setItems(listaDeMedicos());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
	public void remover() {
		MedicoDAO<MedicoVO> dao = new MedicoDAO<>();
		MedicoVO vo = new MedicoVO();
		vo.setCpf(acessarCpf.getText());
		dao.removerPorCpf(vo);
		
		
		
		acessarNome.setEditable(false);
		acessarCrm.setEditable(false);
		acessarEspecializacao.setEditable(false);
		acessarValorConsulta.setEditable(false);
		acessarEndereco.setEditable(false);
		acessarSalvar.setVisible(false);
		acessarRemover.setVisible(false);
		telaDados.setVisible(false);
		try {
			tabelaMedico.setItems(listaDeMedicos());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	};
	public void voltarDados() {
		acessarNome.setEditable(false);
		acessarCrm.setEditable(false);
		acessarEspecializacao.setEditable(false);
		acessarValorConsulta.setEditable(false);
		acessarEndereco.setEditable(false);
		acessarCpf.setEditable(false);
		acessarSalvar.setVisible(false);
		acessarRemover.setVisible(false);
		telaDados.setVisible(false);
	};


	
	public void acessar() throws Exception {
		try {
			ObservableList<MedicoVO> medico = tabelaMedico.getSelectionModel().getSelectedItems();
			acessarNome.setText(medico.get(0).getNome());
			acessarCrm.setText(medico.get(0).getCrm());
			acessarEspecializacao.setText(medico.get(0).getEspecializacao());
			acessarValorConsulta.setText(medico.get(0).getValorConsulta());
			acessarEndereco.setText(medico.get(0).getEndereco());
			acessarCpf.setText(medico.get(0).getCpf());
			telaDados.setVisible(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
	
	public void voltar(ActionEvent event) {
		try {
			Telas.telaAdministrador();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

 