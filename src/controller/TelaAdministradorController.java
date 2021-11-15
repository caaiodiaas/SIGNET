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

    };

    public void abrirMedicos(){

    };

    public void abrirPacientes(){

    };

}
