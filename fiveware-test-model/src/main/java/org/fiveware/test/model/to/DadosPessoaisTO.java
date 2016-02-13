package org.fiveware.test.model.to;

import java.io.Serializable;
import org.fiveware.test.enumerated.EstadoCivil;
import org.fiveware.test.enumerated.Sexo;

public class DadosPessoaisTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private EstadoCivil estadoCivil;

	private String nome;

	private Boolean possuiImovel;

	private Sexo sexo;

	private String telefone;

	public DadosPessoaisTO() {
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