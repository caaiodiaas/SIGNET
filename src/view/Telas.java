package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Telas extends Application {

	private static Stage primaryStage = new Stage();

	public static void main(String args[]) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("VE/TelaLogin.fxml"));

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

	public static void telaMedico() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaMedico.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		primaryStage.show();
	}

	public static void telaPaciente() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaPaciente.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		primaryStage.show();
	}

	public static void telaAdministrador() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaAdministrador.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		primaryStage.show();
	}

	public static void telaConsulta() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaConsulta.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		primaryStage.show();
	}

	public static void telaProntuario() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaProntuario.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		primaryStage.show();
	}

	public static void telaListaMedico() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/ListaMedico.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		primaryStage.show();
	}
	
	public static void telaListaPaciente() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/ListaPaciente.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		primaryStage.show();
	}
	
	public static void telaListaConsulta() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/ListaConsulta.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		primaryStage.show();
	}
	
	public static void telaListaProntuario() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/ListaProntuario.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		primaryStage.show();
	}
}
