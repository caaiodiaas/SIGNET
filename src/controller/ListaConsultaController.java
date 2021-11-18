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
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import model.vo.ConsultaVO;
import model.vo.MedicoVO;
import view.Telas;
import model.bo.ConsultaBO;
import model.bo.MedicoBO;
import model.dao.ConsultaDAO;

public class ListaConsultaController extends Telas implements Initializable{
	
	@FXML private TableView<ConsultaVO> tabelaConsulta;
    @FXML private TableColumn<ConsultaVO, Long> colunaId;
    @FXML private TableColumn<ConsultaVO, String> colunaPaciente;
	@FXML private TableColumn<ConsultaVO, String> colunaMedico;
	@FXML private TableColumn<ConsultaVO, String> colunaData;
	@FXML private TableColumn<ConsultaVO, String> colunaHora;
	@FXML private TableColumn<ConsultaVO, Integer> colunaStatus;
	
	@FXML private TitledPane telaDados;
	@FXML private TextField acessarPaciente;
	@FXML private ComboBox<String> acessarMedico;
	@FXML private TextField acessarData;
	@FXML private TextField acessarHorario;
	@FXML private ComboBox<String> acessarStatus;
	@FXML private Button acessarSalvar;
	@FXML private Button acessarRemover;
	
	@FXML private TextField pesquisaConsulta;
	
	public void initialize (URL url,ResourceBundle rb) {
		colunaPaciente.setCellValueFactory(new PropertyValueFactory<>("Paciente"));
		colunaMedico.setCellValueFactory(new PropertyValueFactory<>("Medico"));
		colunaData.setCellValueFactory(new PropertyValueFactory<>("Data"));
		colunaHora.setCellValueFactory(new PropertyValueFactory<>("Horario"));
		colunaStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
		colunaId.setCellValueFactory(new PropertyValueFactory<>("Id"));
		
		try {

			tabelaConsulta.setItems(listaDeConsultas());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    private ObservableList<ConsultaVO> listaDeConsultas() throws Exception {
    	ConsultaBO bo = new ConsultaBO();
    	List<ConsultaVO> list = bo.buscarTudo();
    	ObservableList<ConsultaVO> consultasList = FXCollections.observableArrayList(list);
        return consultasList;
    }
    
    private ObservableList<ConsultaVO> listaDeConsultas(ConsultaVO vo) throws Exception {
    	ConsultaBO bo = new ConsultaBO();
    	List<ConsultaVO> list = bo.buscar(vo);
    	ObservableList<ConsultaVO> consultasList = FXCollections.observableArrayList(list);
        return consultasList;
    }
	
	public void adicionar() {
		try {
            // Abrir TelaLogin
            telaCadastrarConsulta();

        } catch (Exception e) {
            //TODO: handle exception
        }
	};

	public void editar() {
		
		acessarMedico.setDisable(false);
		acessarData.setEditable(true);
		acessarHorario.setEditable(true);
		acessarStatus.setDisable(false);
		acessarSalvar.setVisible(true);
		acessarRemover.setVisible(true);

	};
	
	public void comboStatus() {
		acessarStatus.setItems(FXCollections.observableArrayList("Marcada", "Realizada", "Cancelada"));

	};
	
	public void comboMedico() {
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
		acessarMedico.setItems(FXCollections.observableArrayList(list2));
	};
	
	public void salvar() {
		ConsultaDAO<ConsultaVO> dao = new ConsultaDAO<>();
		ConsultaVO vo = new ConsultaVO();
		vo.setMedico(acessarMedico.getValue());
		vo.setPaciente(acessarPaciente.getText());
		vo.setData(acessarData.getText());
		vo.setHorario(acessarHorario.getText());
		vo.setStatus(acessarStatus.getValue());
		try {
			dao.editar(vo);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		
		acessarMedico.setDisable(true);
		acessarData.setEditable(false);
		acessarHorario.setEditable(false);
		acessarStatus.setDisable(true);
		acessarSalvar.setVisible(false);
		acessarRemover.setVisible(false);
		telaDados.setVisible(false);
		try {
			tabelaConsulta.setItems(listaDeConsultas());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
	
	public void remover() {
		ConsultaDAO<ConsultaVO> dao = new ConsultaDAO<>();
		ConsultaVO vo = new ConsultaVO();
		vo.setPaciente(acessarPaciente.getText());
		vo.setData(acessarData.getText());
		dao.removerPorPaciente(vo);
		
		
		
		acessarMedico.setDisable(true);
		acessarData.setEditable(false);
		acessarHorario.setEditable(false);
		acessarStatus.setDisable(true);
		acessarSalvar.setVisible(false);
		acessarRemover.setVisible(false);
		telaDados.setVisible(false);
		try {
			tabelaConsulta.setItems(listaDeConsultas());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	};
	
	public void voltarDados() {
		acessarMedico.setDisable(true);
		acessarData.setEditable(false);
		acessarHorario.setEditable(false);
		acessarStatus.setDisable(true);
		acessarSalvar.setVisible(false);
		acessarRemover.setVisible(false);
		telaDados.setVisible(false);
	};
	
	public void acessar() throws Exception {
		try {
			ObservableList<ConsultaVO> consulta = tabelaConsulta.getSelectionModel().getSelectedItems();
			acessarPaciente.setText(consulta.get(0).getPaciente());
			acessarMedico.setValue(consulta.get(0).getMedico());
			acessarData.setText(consulta.get(0).getData());
			acessarHorario.setText(consulta.get(0).getHorario());
			acessarStatus.setValue(consulta.get(0).getStatus());
			telaDados.setVisible(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
	
	public void buscar() throws Exception {
		
		ConsultaVO vo = new ConsultaVO();
		vo.setMedico(pesquisaConsulta.getText());
		vo.setPaciente(pesquisaConsulta.getText());
		vo.setStatus(pesquisaConsulta.getText());
		vo.setData(pesquisaConsulta.getText());
		vo.setHorario(pesquisaConsulta.getText());
		
		if(pesquisaConsulta.getText() == null || pesquisaConsulta.getText().equals("")) {
			tabelaConsulta.setItems(listaDeConsultas());
		}
		
		tabelaConsulta.setItems(listaDeConsultas(vo));

	};
	
	public void voltar(ActionEvent event) {
		try {
			Telas.telaAdministrador();
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
}