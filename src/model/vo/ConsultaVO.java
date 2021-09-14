package model.vo;

import java.util.Calendar;

public class ConsultaVO {
	
	private Calendar data;
	private Calendar horario;
	private int status;
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
	
	
	public Calendar getHorario() {
		return horario;
	}
	public void setHorario(Calendar horario) {
		if(horario == null){
			
		}else {
				this.horario = horario;
		}
	}
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		if(status != 0 || status != 1 || status != 2){

		}else {
			this.status = status;
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