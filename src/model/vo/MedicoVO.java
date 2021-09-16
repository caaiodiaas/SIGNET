package model.vo;

public class MedicoVO extends PessoaVO{

	private String crm;
	private float valorConsulta;
	private ConsultaVO consultas[];
	
<<<<<<< Updated upstream
	public PessoaVO getDados() {
		return dados;
=======
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		if(id==null || id < 0) {
			
		} else {
			this.id = id;	
		}
	}
	
	public int getTipoUsuario() {
		return super.getTipoUsuario();
>>>>>>> Stashed changes
	}

	public void setTipoUsuario(int tipoUsuario) {
		if(tipoUsuario != 1){
			
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