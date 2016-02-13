package org.fiveware.test.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.fiveware.test.enumerated.EstadoCivil;
import org.fiveware.test.enumerated.Sexo;

@Entity
@Table(name = "dados_pessoais")
@NamedQuery(name = "DadosPessoais.findAll", query = "SELECT d FROM DadosPessoais d")
public class DadosPessoais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "estado_civil")
	@Enumerated(EnumType.STRING)
	private EstadoCivil estadoCivil;

	private String nome;

	@Column(name = "possui_imovel", nullable = false, columnDefinition = "TINYINT(1)")
	private Boolean possuiImovel;

	@Enumerated(EnumType.STRING)
	private Sexo sexo;

	private String telefone;

	public DadosPessoais() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EstadoCivil getEstadoCivil() {
		return this.estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getPossuiImovel() {
		return this.possuiImovel;
	}

	public void setPossuiImovel(Boolean possuiImovel) {
		this.possuiImovel = possuiImovel;
	}

	public Sexo getSexo() {
		return this.sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}