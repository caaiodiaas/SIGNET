package model.vo;

public class MedicoVO{

	private PessoaVO dados;
	private String crm;
	private Long id;
	private float valorConsulta;
	private String especializacao;
	private ConsultaVO consultas[];
	
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
			if(dados.getNome().equals("") || dados.getCpf().equals("") || dados.getLogin().getTipoUsuario() != 1) {
				
			}else {
				this.dados = dados;
			}
		}
	}
	
	
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		if(crm == null || crm.equals("") || crm.length() < 7){
			
		}else {
				this.crm = crm;
		}
	}
	
	
	public float getValorConsulta() {
		return valorConsulta;
	}
	public void setValorConsulta(float valorConsulta) {
		if(valorConsulta < 0) {

		}else {
			this.valorConsulta = valorConsulta;
		}		
	}
	
	// Não precisa necessariamente ter consultas
	public ConsultaVO[] getConsultas() {
		return consultas;
	}
	public void setConsultas(ConsultaVO[] consultas) {
		this.consultas = consultas;
	}
	
	public String getEspecializacao() {
		return especializacao;
	}
	public void setEspecializacao(String especializacao) {
		if(especializacao == null || especializacao.equals("")) {
			
		} else {
			this.especializacao = especializacao;
		}
	}
	
	
}