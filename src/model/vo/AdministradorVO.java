package model.vo;

public class AdministradorVO extends PessoaVO{
	
<<<<<<< Updated upstream
	private PessoaVO dados;

	public PessoaVO getDados() {
		return dados;
=======
	public int getTipoUsuario() {
		return super.getTipoUsuario();
>>>>>>> Stashed changes
	}

	public void setTipoUsuario(int tipoUsuario) {
		if(tipoUsuario != 0){
			
		}else {
<<<<<<< Updated upstream
			if(dados.getNome().equals("") || dados.getCpf().equals("")) {
				
			}else {
				this.dados = dados;
			}
=======
			super.setTipoUsuario(tipoUsuario);
>>>>>>> Stashed changes
		}
	}

}