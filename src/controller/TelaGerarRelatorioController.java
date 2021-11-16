package controller;

import javafx.event.ActionEvent;
import view.Telas;

public class TelaGerarRelatorioController {
	
	public void GerarRelatórios() {

	};

	public void Voltar(ActionEvent event) {
		try {
			Telas.telaLogin();
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
}