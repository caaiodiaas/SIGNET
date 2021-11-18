package model.vo;

public class ProntuarioVO {

	private String data;
	private String observacoes;
	private String paciente;
	private String medico;
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
	
	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		if (paciente == null) {

		} else {
			if (paciente.equals("")) {

			} else {
				this.paciente = paciente;
			}
		}
	}

	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		if (medico == null) {

		} else {
			if (medico.equals("")) {

			} else {
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