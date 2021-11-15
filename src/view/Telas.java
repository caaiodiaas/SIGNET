package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Telas extends Application{

	private static Stage primaryStage = new Stage();
	
	public static void main(String args[]) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("VE/TelaAdministrador.fxml"));
		
		Scene cena = new Scene(root);
		
		primaryStage.setTitle("Projeto SIGNET");
		primaryStage.setScene(cena);
		primaryStage.show();
		
	}

	public static void telaLogin() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaLogin.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		primaryStage.show();
	}

}