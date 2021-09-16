package model.vo;

public class ProntuarioVO {

	private String data;
	private String observacoes;
	private PacienteVO paciente;
	private MedicoVO medico;
	private Long id;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		if(id==null || id < 0) {
			
		} else {
			this.id = id;	
		}
	}
	
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		if(observacoes == null || observacoes.equals("")){
			
		}else {
				this.observacoes = observacoes;
		}
	}
	
	public PacienteVO getPaciente() {
		return paciente;
	}
	public void setPaciente(PacienteVO paciente) {
		if(paciente == null) {
			
		}else {
				if(paciente.getNome().equals("") || paciente.getCpf().equals("")){
					
				}else {
					this.paciente = paciente;
				}
			}
		}
	
	
	public MedicoVO getMedico() {
		return medico;
	}
	public void setMedico(MedicoVO medico) {
		if(medico == null) {
			
		}else {
				if(medico.getNome().equals("") || medico.getCpf().equals("")){
					
				}else {
					this.medico = medico;
				}
			}
		}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		if(data == null || data.equals("")) {
			
		} else {
			this.data = data;
		}
	}
	
	
}