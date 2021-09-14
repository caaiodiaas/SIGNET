package model.vo;

public class MedicoVO{

	private PessoaVO dados;
	private String crm;
	private float valorConsulta;
	private ConsultaVO consultas[];
	
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
}