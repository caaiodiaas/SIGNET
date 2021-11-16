package controller;

import javafx.event.ActionEvent;
import view.Telas;

public class TelaProntuarioController {

	public void Editar() {

	};

	public void Voltar(ActionEvent event) {
		try {
			Telas.telaLogin();
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
}