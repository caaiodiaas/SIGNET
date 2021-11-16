package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.vo.ConsultaVO;
import view.Telas;
import model.bo.ConsultaBO;
import model.bo.PacienteBO;

public class ListaConsultaController extends Telas{
	
	@FXML private TableView<ConsultaVO> tabelaConsulta;
    @FXML private TableColumn<ConsultaVO, Long> colunaId;
    @FXML private TableColumn<ConsultaVO, String> colunaPaciente;
	@FXML private TableColumn<ConsultaVO, String> colunaMedico;
	@FXML private TableColumn<ConsultaVO, String> colunaData;
	@FXML private TableColumn<ConsultaVO, String> colunaHorario;
	@FXML private TableColumn<ConsultaVO, Integer> colunaStatus;
	//@FXML private TableColumn<ConsultaVO, ConsultaVO> columnEdit;
	//@FXML private TableColumn<ConsultaVO, ConsultaVO> columnDelete;
	//public static final String PEN_SOLID = "M290.74 93.24l128.02 128.02-277.99 277.99-114.14 12.6C11.35 513.54-1.56 500.62.14 485.34l12.7-114.22 277.9-277.88zm207.2-19.06l-60.11-60.11c-18.75-18.75-49.16-18.75-67.91 0l-56.55 56.55 128.02 128.02 56.55-56.55c18.75-18.76 18.75-49.16 0-67.91z";
	//public static final String TRASH_SOLID = "M432 32H312l-9.4-18.7A24 24 0 0 0 281.1 0H166.8a23.72 23.72 0 0 0-21.4 13.3L136 32H16A16 16 0 0 0 0 48v32a16 16 0 0 0 16 16h416a16 16 0 0 0 16-16V48a16 16 0 0 0-16-16zM53.2 467a48 48 0 0 0 47.9 45h245.8a48 48 0 0 0 47.9-45L416 128H32z";
	ConsultaBO bo = new ConsultaBO();
	PacienteBO bop = new PacienteBO();
	
	public void initialize (URL url,ResourceBundle rb) {
		colunaPaciente.setCellValueFactory(new PropertyValueFactory<ConsultaVO, String>("Paciente"));
		colunaMedico.setCellValueFactory(new PropertyValueFactory<ConsultaVO, String>("Medico"));
		colunaData.setCellValueFactory(new PropertyValueFactory<ConsultaVO, String>("Data"));
		colunaHorario.setCellValueFactory(new PropertyValueFactory<ConsultaVO, String>("Horario"));
		colunaStatus.setCellValueFactory(new PropertyValueFactory<ConsultaVO, Integer>("Status"));
		colunaId.setCellValueFactory(new PropertyValueFactory<ConsultaVO, Long>("Id"));

		tabelaConsulta.getItems().setAll(ListConsulta());
		
	}
	
	private List<ConsultaVO> ListConsulta(){
		List<ConsultaVO> vo = new ArrayList();
		try {
			for( ConsultaVO vo2 : bo.buscarTudo()) {
				System.out.println(bo.buscarTudo());
				vo.add(vo2);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;				
    }; 

	public void adicionar() {
		try {
            // Abrir TelaLogin
            telaConsulta();

        } catch (Exception e) {
            //TODO: handle exception
        }
	};

	public void abrirConsulta() {
		try {
            // Abrir TelaLogin
			telaConsulta();

        } catch (Exception e) {
            //TODO: handle exception
        }
	};
	
	public void buscar() {

	};
	
	public void voltar(ActionEvent event) {
		try {
			Telas.telaAdministrador();
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
}