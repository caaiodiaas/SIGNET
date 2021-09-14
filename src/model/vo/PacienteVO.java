package model.vo;

public class PacienteVO{
	
	private PessoaVO dados;
	private Long id;
	private ProntuarioVO prontuario[];
	private ConsultaVO consulta[];
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		if(id==null || id < 0) {
			
		} else {
			this.id = id;	
		}
	}
	
	public PessoaVO getDados() {
		return dados;
	}
	public void setDados(PessoaVO dados) {
		if(dados == null) {
			
		}else {
			if(dados.getNome().equals("") || dados.getCpf().equals("") || dados.getLogin().getTipoUsuario() != 2) {
				
			}else {
				this.dados = dados;
			}
		}
	}
	
	// Não precisa necessariamente ter um prontuário
	public ProntuarioVO[] getProntuario() {
		return prontuario;
	}
	public void setProntuario(ProntuarioVO[] prontuario) {
		this.prontuario = prontuario;
	}
	
	// Não precisa necessariamente ter consultas
	public ConsultaVO[] getConsulta() {
		return consulta;
	}
	public void setConsulta(ConsultaVO[] consulta) {
		this.consulta = consulta;
	}
}