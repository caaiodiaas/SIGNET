package model.vo;

import java.util.Calendar;

public class ProntuarioVO {

	private Calendar data;
	private String observacoes;
	private PacienteVO paciente;
	private MedicoVO medico;
	
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		if(data == null){
			
		}else {
				this.data = data;
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
			if(paciente.getDados() == null) {
				
			}else {
				if(paciente.getDados().getNome().equals("") || paciente.getDados().getCpf().equals("")){
					
				}else {
					this.paciente = paciente;
				}
			}
		}
	}
	
	
	public MedicoVO getMedico() {
		return medico;
	}
	public void setMedico(MedicoVO medico) {
		if(medico == null) {
			
		}else {
			if(medico.getDados() == null) {
				
			}else {
				if(medico.getDados().getNome().equals("") || medico.getDados().getCpf().equals("")){
					
				}else {
					this.medico = medico;
				}
			}
		}
	}
}