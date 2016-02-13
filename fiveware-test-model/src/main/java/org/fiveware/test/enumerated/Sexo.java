package org.fiveware.test.enumerated;

public enum Sexo {
	M("Masculino"), F("Feminino");

	private String sexo;

	private Sexo(String sexo) {
		this.sexo = sexo;
	}

	public String getSexo() {
		return this.sexo;
	}
}
