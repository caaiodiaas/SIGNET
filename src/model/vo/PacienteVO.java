package model.vo;

public class PacienteVO extends PessoaVO{
	
	private Long id;
	private ProntuarioVO prontuarios[];
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
	
	public int getTipoUsuario() {
		return super.getTipoUsuario();
	}

	public void setTipoUsuario(int tipoUsuario) {
		if(tipoUsuario != 2){
      
		}else {
			super.setTipoUsuario(tipoUsuario);
		}
	}
	
	// Não precisa necessariamente ter um prontuário
	public ProntuarioVO[] getProntuarios() {
		return prontuarios;
	}
	public void setProntuarios(ProntuarioVO[] prontuario) {
		this.prontuarios = prontuario;
	}
	
	// Não precisa necessariamente ter consultas
	public ConsultaVO[] getConsultas() {
		return consultas;
	}
	public void setConsultas(ConsultaVO[] consulta) {
		this.consultas = consulta;
	}
}