package model.vo;

public class PessoaVO extends UsuarioVO{
		
	private String nome;
	private String endereco;
	private String cpf;
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome == null || nome.equals("") || nome.length() < 2){
			
		}else {
				this.nome = nome;
		}
	}
	
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		if(endereco == null || endereco.equals("") || endereco.length() < 10){
			
		}else {
				this.endereco = endereco;
		}
	}
	
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		if(cpf == null || cpf.equals("") || cpf.length() < 11){
			
		}else {
				this.cpf = cpf;
		}
}
}