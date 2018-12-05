package br.com.jogodaforca.vo;

public class AlunoVo {

	private Long codigo = 0L;
	private String nome;
	private Integer serie;
	private Integer idade;
	private Integer ip;
	private Integer porta;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getSerie() {
		return serie;
	}

	public void setSerie(Integer serie) {
		this.serie = serie;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Integer getIp() {
		return ip;
	}

	public void setIp(Integer ip) {
		this.ip = ip;
	}

	public Integer getPorta() {
		return porta;
	}

	public void setPorta(Integer porta) {
		this.porta = porta;
	}

	@Override
	public String toString() {
		return codigo + ":" + nome + ":" + serie + ":" + idade + ":" + ip + ":" + porta + "\r\n";
	}

}
