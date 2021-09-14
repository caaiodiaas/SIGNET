  
// Criado por Caio Dias e George Felipe.
package model.vo;

public class PacienteVO {
	
	private PessoaVO dados;
	private ProntuarioVO prontuario[];
	private ConsultaVO consulta[];
	
	public PessoaVO getDados() {
		return dados;
	}
	public void setDados(PessoaVO dados) {
		if(dados == null) {
			
		}else {
			if(dados.getNome().equals("") || dados.getCpf().equals("")) {
				
			}else {
				this.dados = dados;
			}
		}
	}
	
	// N�o precisa necessariamente ter um prontu�rio
	public ProntuarioVO[] getProntuario() {
		return prontuario;
	}
	public void setProntuario(ProntuarioVO[] prontuario) {
		this.prontuario = prontuario;
	}
	
	// N�o precisa necessariamente ter consultas
	public ConsultaVO[] getConsulta() {
		return consulta;
	}
	public void setConsulta(ConsultaVO[] consulta) {
		this.consulta = consulta;
	}
}