package model.vo;

public class PacienteVO extends PessoaVO{
	
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