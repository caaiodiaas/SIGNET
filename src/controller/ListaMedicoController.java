package controller;

import javafx.event.ActionEvent;
import view.Telas;

public class ListaMedicoController {
	public void Adicionar() {

	};

	public void abrirPerfilMedico() {

	};

	public void Anterior() {

	};
	
	public void Proxima() {

	};
	
	public void Buscar() {

	};
	
	public void Voltar(ActionEvent event) {
		try {
			Telas.telaAdministrador();
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
}