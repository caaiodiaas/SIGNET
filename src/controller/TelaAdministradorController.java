package controller;

import javafx.event.ActionEvent;
import view.Telas;

public class TelaAdministradorController extends Telas{
    
    public void encerrarSessao(ActionEvent event){
        try {
            // Abrir TelaLogin
            telaLogin();

        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    public void abrirRelatorios(){
    
    };

    public void abrirConsultas(){
    	try {
            // Abrir TelaLogin
    		telaListaConsulta();

        } catch (Exception e) {
            //TODO: handle exception
        }
    };

    public void abrirMedicos(){
    	try {
            // Abrir TelaLogin
            telaListaMedico();

        } catch (Exception e) {
            //TODO: handle exception
        }
    };

    public void abrirPacientes(){
    	try {
            // Abrir TelaLogin
            telaListaPaciente();

        } catch (Exception e) {
            //TODO: handle exception
        }
    };

}
