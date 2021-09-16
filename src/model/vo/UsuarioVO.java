package model.vo;

public class UsuarioVO extends PessoaVO{
	
	private String login;
	private String senha;
	private int tipoUsuario;//[0]Administrador || [1]Médico || [2]Paciente
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		if(login == null || login.equals("") || login.length() < 2){
		
		}else {
				this.login = login;
		}
	}
	
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		if(senha == null || senha.equals("") || senha.length() < 6){
			
		}else {
				this.senha = senha;
		}
	}

	
	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		if(tipoUsuario != 0 || tipoUsuario != 1 || tipoUsuario != 2){
			
		}else {
			this.tipoUsuario = tipoUsuario;
		}
	}
}