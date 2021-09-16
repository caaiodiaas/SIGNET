package model.vo;

import java.util.List;

public class MedicoVO extends UsuarioVO{

	private String crm;
	private Long id;
	private float valorConsulta;
	private String especializacao;
	private List<ConsultaVO> consultas;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		if(id==null || id < 0) {
			
		} else {
			this.id = id;	
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
	
	public List<ConsultaVO> getConsultas() {
		return consultas;
	}
	public void setConsultas(List<ConsultaVO> consulta) {
		this.consultas = consulta;
	}
	
	
	
	public String getEspecializacao() {
		return especializacao;
	}
	public void setEspecializacao(String especializacao) {
		if(especializacao == null || especializacao.equals("")) {
			
		} else {
			this.especializacao = especializacao;
		}
	}
	
	public int getTipoUsuario() {
        return super.getTipoUsuario();
    }

    public void setTipoUsuario(int tipoUsuario) {
        if(tipoUsuario != 1){

        }else {
            super.setTipoUsuario(tipoUsuario);
        }
    }
	
}