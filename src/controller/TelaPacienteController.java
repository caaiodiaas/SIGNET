package controller;

import javafx.event.ActionEvent;
import view.Telas;

public class TelaPacienteController {

	public void Editar() {

	};

	public void abrirConsultas() {

	};

	public void Exluir() {

	};

	public void voltar(ActionEvent event) {
		try {
			Telas.telaLogin();
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
}