package model.vo;

public class AdministradorVO{
	
	private PessoaVO dados;
	

	public PessoaVO getDados() {
		return dados;
	}
	
	
	public void setDados(PessoaVO dados) {
		if(dados == null) {
			
		}else {
			if(dados.getNome().equals("") || dados.getCpf().equals("") || dados.getLogin().getTipoUsuario() != 0) {
				
			}else {
				this.dados = dados;
			}
		}
	}
}