package controller;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.bo.MedicoBO;
import model.bo.PacienteBO;
import model.dao.ConsultaDAO;
import model.vo.ConsultaVO;
import model.vo.MedicoVO;
import model.vo.PacienteVO;
import view.Telas;

public class CadastrarConsultaController extends Telas{
	
	@FXML ComboBox<String> paciente;
	@FXML ComboBox<String> medico;
	@FXML TextField data;
	@FXML TextField horario;
	@FXML ComboBox<String> status;

	public void comboPaciente() {
		PacienteBO bo = new PacienteBO();
		List<PacienteVO> list = new ArrayList<>();
		try {
			list = bo.buscarTudo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> list2 = new ArrayList<>();
		for (PacienteVO vo : list) {
			list2.add(vo.getNome());
		}
		paciente.setItems(FXCollections.observableArrayList(list2));

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
		medico.setItems(FXCollections.observableArrayList(list2));
	};
	
	public void comboStatus() {
		status.setItems(FXCollections.observableArrayList("Marcada", "Realizada", "Cancelada"));

	};
	
	public void cadastrar() {
		ConsultaVO vo = new ConsultaVO();
		PacienteBO bo1 = new PacienteBO();
		PacienteVO vo1 = new PacienteVO();
		vo1.setNome(paciente.getValue());
		MedicoBO bo2 = new MedicoBO();
		MedicoVO vo2 = new MedicoVO();
		vo2.setNome(medico.getValue());
		
		try {
			vo.setPaciente(bo1.buscar(vo1).get(0).getNome());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			vo.setMedico(bo2.buscar(vo2).get(0).getNome());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		vo.setData(data.getText());
		vo.setHorario(horario.getText());
		vo.setStatus(status.getValue());
		
		ConsultaDAO<ConsultaVO> dao = new ConsultaDAO<>();
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
			telaListaConsulta();
        } catch (Exception e) {
            //TODO: handle exception
        }
	};
}
