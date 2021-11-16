package controller;

import javafx.event.ActionEvent;
import view.Telas;

public class TelaMedicoController extends Telas {

	public void Editar() {

	};

	public void abrirConsultas() {
		try {
			Telas.telaConsulta();
		} catch (Exception e) {
			e.printStackTrace();
		}
	};

	public void Voltar(ActionEvent event) {
		try {
			Telas.telaLogin();
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
}