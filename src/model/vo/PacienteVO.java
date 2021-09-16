package model.vo;

public class PacienteVO extends PessoaVO{
	
<<<<<<< Updated upstream
	private PessoaVO dados;
	private ProntuarioVO prontuario[];
	private ConsultaVO consulta[];
	
	public PessoaVO getDados() {
		return dados;
=======
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
>>>>>>> Stashed changes
	}

	public void setTipoUsuario(int tipoUsuario) {
		if(tipoUsuario != 2){
			
		}else {
<<<<<<< Updated upstream
			if(dados.getNome().equals("") || dados.getCpf().equals("")) {
				
			}else {
				this.dados = dados;
			}
=======
			super.setTipoUsuario(tipoUsuario);
>>>>>>> Stashed changes
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