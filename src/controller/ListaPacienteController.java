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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import model.bo.MedicoBO;
import model.bo.PacienteBO;
import model.bo.ProntuarioBO;
import model.dao.MedicoDAO;
import model.dao.PacienteDAO;
import model.dao.ProntuarioDAO;
import model.vo.MedicoVO;
import model.vo.PacienteVO;
import model.vo.ProntuarioVO;
import view.Telas;

public class ListaPacienteController extends Telas implements Initializable{
	
	@FXML private TableView<PacienteVO> tabelaPaciente;
    @FXML private TableColumn<PacienteVO, String> colunaPaciente;
	@FXML private TableColumn<PacienteVO, String> colunaCpf;
	@FXML private TableColumn<PacienteVO, Long> colunaId;
	
	@FXML private TitledPane telaDados;
	@FXML private TextField acessarNome;
	@FXML private TextField acessarCpf;
	@FXML private TextField acessarEndereco;
	@FXML private Button acessarSalvar;
	@FXML private Button acessarRemover;
	@FXML private Button acessarProntuarios;
	@FXML private Button abrirProntuario;
	@FXML private Button novoProntuario;
	@FXML private ComboBox<String> prontuarios;
	
	@FXML private TitledPane telaProntuario;
	@FXML private TextField prontuarioPaciente;
	@FXML private ComboBox<String> prontuarioMedico;
	@FXML private TextField prontuarioData;
	@FXML private TextArea prontuarioObservacoes;
	@FXML private Button prontuarioEditar;
	@FXML private Button prontuarioCadastrar;
	@FXML private Button prontuarioSalvar;
	@FXML private Button prontuarioRemover;

	
	@FXML private TextField pesquisaPaciente;


		
	public void initialize (URL url,ResourceBundle rb) {
		
		colunaPaciente.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		colunaCpf.setCellValueFactory(new PropertyValueFactory<>("Cpf"));
		colunaId.setCellValueFactory(new PropertyValueFactory<>("Id"));
		
		try {
			tabelaPaciente.setItems(listaDePacientes()); //FALTA SÓ ESSA DIGRAÇA DO SATANÁS
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    private ObservableList<PacienteVO> listaDePacientes() throws Exception {
    	PacienteBO bo = new PacienteBO();
    	List<PacienteVO> list = bo.buscarTudo();
    	ObservableList<PacienteVO> PacientesList = FXCollections.observableArrayList(list);
        return PacientesList;
    }
    
    private ObservableList<PacienteVO> listaDePacientes(PacienteVO vo) throws Exception {
    	PacienteBO bo = new PacienteBO();
    	List<PacienteVO> list = bo.buscar(vo);
    	ObservableList<PacienteVO> PacientesList = FXCollections.observableArrayList(list);
        return PacientesList;
    }
    
    
	public void adicionarPaciente() throws Exception {
		telaCadastrarPaciente();

	};

	public void editar() {
		
		acessarNome.setEditable(true);
		acessarEndereco.setEditable(true);
		acessarSalvar.setVisible(true);
		acessarRemover.setVisible(true);

	};
	
	public void salvar() {
		PacienteDAO<PacienteVO> dao = new PacienteDAO<>();
		PacienteVO vo = new PacienteVO();
		vo.setCpf(acessarCpf.getText());
		vo.setNome(acessarNome.getText());
		vo.setEndereco(acessarEndereco.getText());
		try {
			dao.editar(vo);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		
		acessarNome.setEditable(false);
		acessarEndereco.setEditable(false);
		acessarSalvar.setVisible(false);
		acessarRemover.setVisible(false);
		telaDados.setVisible(false);
		try {
			tabelaPaciente.setItems(listaDePacientes());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
	
	public void remover() {
		PacienteDAO<PacienteVO> dao = new PacienteDAO<>();
		PacienteVO vo = new PacienteVO();
		vo.setCpf(acessarCpf.getText());
		dao.removerPorCpf(vo);
		
		
		
		acessarNome.setEditable(false);
		acessarEndereco.setEditable(false);
		acessarSalvar.setVisible(false);
		acessarRemover.setVisible(false);
		telaDados.setVisible(false);
		try {
			tabelaPaciente.setItems(listaDePacientes());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	};
	
	public void voltarDados() {
		acessarNome.setEditable(false);
		acessarEndereco.setEditable(false);
		acessarCpf.setEditable(false);
		acessarSalvar.setVisible(false);
		acessarRemover.setVisible(false);
		telaDados.setVisible(false);
	};
	
	public void acessar() throws Exception {
		try {
			ObservableList<PacienteVO> paciente = tabelaPaciente.getSelectionModel().getSelectedItems();
			acessarNome.setText(paciente.get(0).getNome());
			acessarEndereco.setText(paciente.get(0).getEndereco());
			acessarCpf.setText(paciente.get(0).getCpf());
			telaDados.setVisible(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};

public void buscarPaciente() throws Exception {
		
		PacienteVO vo = new PacienteVO();
		
		vo.setNome(pesquisaPaciente.getText());
		vo.setCpf(pesquisaPaciente.getText());

		if(pesquisaPaciente.getText().equals("") || pesquisaPaciente.getText() == null) {
			tabelaPaciente.setItems(listaDePacientes());
		}
		
		tabelaPaciente.setItems(listaDePacientes(vo));

	};
	
	public void voltar(ActionEvent event) {
		try {
			Telas.telaAdministrador();
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
	
	public void comboProntuarios() {
		ProntuarioBO bo = new ProntuarioBO();
		ProntuarioVO vo2 = new ProntuarioVO();
		vo2.setPaciente(acessarNome.getText());
		List<ProntuarioVO> list = new ArrayList<>();
		try {
			list = bo.buscar(vo2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> list2 = new ArrayList<>();
		for (ProntuarioVO vo : list) {
			list2.add(vo.getData());
		}
		prontuarios.setItems(FXCollections.observableArrayList(list2));

		
	};
	
	public void comboMedicoProntuario() {
		MedicoBO bo = new MedicoBO();
		List<MedicoVO> list = new ArrayList<>();
		try {
			list = bo.buscarTudo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> list2 = new ArrayList<>();
		for (MedicoVO vo : list) {
			list2.add(vo.getNome());
		}
		prontuarioMedico.setItems(FXCollections.observableArrayList(list2));
	};
	
	public void abrirProntuario() throws Exception {
		try {
			ProntuarioBO bo = new ProntuarioBO();
			ProntuarioVO vo = new ProntuarioVO();
			vo.setData(prontuarios.getValue());
			ObservableList<ProntuarioVO> prontuario = FXCollections.observableArrayList(bo.buscar(vo));
			prontuarioPaciente.setText(prontuario.get(0).getPaciente());
			prontuarioMedico.setValue(prontuario.get(0).getMedico());
			prontuarioData.setText(prontuario.get(0).getData());
			prontuarioObservacoes.setText(prontuario.get(0).getObservacoes());
			prontuarioEditar.setVisible(true);
			telaProntuario.setVisible(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	};
	
	public void acessarProntuario() throws Exception {
		prontuarios.setDisable(false);
		abrirProntuario.setVisible(true);
		novoProntuario.setVisible(true);

	};
	
	public void novoProntuario() throws Exception {
		try {
			prontuarioPaciente.setText(acessarNome.getText());
			prontuarioMedico.setValue(null);
			prontuarioData.setText(null);
			prontuarioObservacoes.setText(null);
			prontuarioCadastrar.setVisible(true);
			prontuarioEditar.setVisible(false);
			prontuarioMedico.setDisable(false);
			prontuarioObservacoes.setEditable(true);
			prontuarioData.setEditable(true);
			telaProntuario.setVisible(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	};
	
	public void cadastrarProntuario() throws Exception {
		
		ProntuarioDAO<ProntuarioVO> dao = new ProntuarioDAO<>();
		ProntuarioVO vo = new ProntuarioVO();
		vo.setPaciente(prontuarioPaciente.getText());
		vo.setMedico(prontuarioMedico.getValue());
		vo.setData(prontuarioData.getText());
		vo.setObservacoes(prontuarioObservacoes.getText());
		dao.inserir(vo);
			
		prontuarioCadastrar.setVisible(false);
		prontuarioEditar.setVisible(true);
		prontuarioMedico.setDisable(true);
		prontuarioObservacoes.setEditable(false);
		prontuarioData.setEditable(false);
		telaProntuario.setVisible(false);
		
		



	};
	
	public void editarProntuario() {
		
		prontuarioMedico.setDisable(false);
		prontuarioObservacoes.setEditable(true);
		prontuarioSalvar.setVisible(true);
		prontuarioRemover.setVisible(true);
		

	};
	
	public void salvarProntuario() {
		ProntuarioDAO<ProntuarioVO> dao = new ProntuarioDAO<>();
		ProntuarioVO vo = new ProntuarioVO();
		vo.setPaciente(prontuarioPaciente.getText());
		vo.setMedico(prontuarioMedico.getValue());
		vo.setData(prontuarioData.getText());
		vo.setObservacoes(prontuarioObservacoes.getText());
		try {
			dao.editar(vo);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		
		prontuarioMedico.setDisable(true);
		prontuarioObservacoes.setEditable(false);
		prontuarioSalvar.setVisible(false);
		prontuarioRemover.setVisible(false);
		prontuarios.setDisable(true);
		abrirProntuario.setVisible(false);
		novoProntuario.setVisible(false);
		try {
			ProntuarioBO bo = new ProntuarioBO();
			List<ProntuarioVO> list = new ArrayList<>();
				list = bo.buscarTudo();
			List<String> list2 = new ArrayList<>();
			for (ProntuarioVO vo2 : list) {
				list2.add(vo2.getData());
			}
			prontuarios.setItems(FXCollections.observableArrayList(list2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		telaProntuario.setVisible(false);
	};
	
	public void removerProntuario() {
		ProntuarioDAO<ProntuarioVO> dao = new ProntuarioDAO<>();
		ProntuarioVO vo = new ProntuarioVO();
		vo.setPaciente(prontuarioPaciente.getText());
		vo.setMedico(prontuarioMedico.getValue());
		vo.setData(prontuarioData.getText());
		vo.setObservacoes(prontuarioObservacoes.getText());
		dao.remover(vo);
		
		prontuarioMedico.setDisable(true);
		prontuarioObservacoes.setEditable(false);
		prontuarioSalvar.setVisible(false);
		prontuarioRemover.setVisible(false);
		prontuarios.setDisable(true);
		abrirProntuario.setVisible(false);
		novoProntuario.setVisible(false);
		telaProntuario.setVisible(false);
		
	};
	
	public void voltarProntuario(ActionEvent event) {
		prontuarioMedico.setDisable(true);
		prontuarioObservacoes.setEditable(false);
		prontuarioSalvar.setVisible(false);
		prontuarioRemover.setVisible(false);
		prontuarios.setDisable(true);
		abrirProntuario.setVisible(false);
		novoProntuario.setVisible(false);

		telaProntuario.setVisible(false);
	};
}