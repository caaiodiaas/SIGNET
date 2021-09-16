package model.vo;

import java.sql.Date;
import java.sql.Time;


public class ConsultaVO {
	
	private Date data;
	private Time horario;
	private int status;
	private Long id;
	private PacienteVO paciente;
	private MedicoVO medico;

	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		if(id==null || id < 0) {
			
		} else {
			this.id = id;	
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
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Time getHorario() {
		return horario;
	}
	public void setHorario(Time horario) {
		this.horario = horario;
	}
	
}