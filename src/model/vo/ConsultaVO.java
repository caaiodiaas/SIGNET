package model.vo;

public class ConsultaVO {
	
	private String data;
	private String horario;
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
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		if(data == null || data.equals("")) {
			
		} else {
			this.data = data;
		}
	}
	
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		if(horario == null || horario.equals("")) {
			
		} else {
			this.horario = horario;
		}
	}
}