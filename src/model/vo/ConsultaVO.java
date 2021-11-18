package model.vo;

public class ConsultaVO {

	private String data;
	private String horario;
	private String status;
	private Long id;
	private String paciente;
	private String medico;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if (id == null || id < 0) {

		} else {
			this.id = id;
		}
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		if (status == null) {

		} else {
			if (status.equals("")) {

			} else {
				this.status = status;
			}
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
		if (data == null || data.equals("")) {

		} else {
			this.data = data;
		}
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		if (horario == null || horario.equals("")) {

		} else {
			this.horario = horario;
		}
	}
}