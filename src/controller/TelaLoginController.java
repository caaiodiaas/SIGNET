package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.bo.UsuarioBO;
import model.vo.UsuarioVO;
import view.Telas;

public class TelaLoginController extends Telas{

    @FXML private TextField login;
    @FXML private PasswordField senha;
    @FXML private Label erroAut;

    UsuarioBO usuBO = new UsuarioBO();
    
    public void autenticar(ActionEvent event) throws Exception{
        UsuarioVO vo = new UsuarioVO();
        vo.setLogin(login.getText());
        vo.setSenha(senha.getText());
        
        try {
        	UsuarioVO autenticado = usuBO.buscarPorLogin(vo);            
            if (autenticado.getLogin().equals(vo.getLogin()) && autenticado.getSenha().equals(vo.getSenha())){
            	System.out.println(autenticado.getTipoUsuario());
                if(autenticado.getTipoUsuario() == 0){
                	 // Abrir menu do Administrador
                    telaAdministrador();
                }else{
                    if(autenticado.getTipoUsuario() == 1){
                        // Abrir menu do Médico
                        telaMedico();

                    }else{
                            // Abrir menu do Paciente
                            telaPaciente();
                    }
                }
            }else {
            	 erroAut.setVisible(true);
            }
        } catch (Exception e) {
            erroAut.setVisible(true);
        }


    }
    


}
