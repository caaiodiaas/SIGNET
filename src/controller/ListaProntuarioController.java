package controller;

import javafx.event.ActionEvent;
import view.Telas;

public class ListaProntuarioController {
	public void Adicionar() {

	};

	public void abrirPerfil() {

	};

	public void Anterior() {

	};
	
	public void Proxima() {

	};

	public void Buscar() {

	};
	
	public void Voltar(ActionEvent event) {
		try {
			Telas.telaPaciente();
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
}