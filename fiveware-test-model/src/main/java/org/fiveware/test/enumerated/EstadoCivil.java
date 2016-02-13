package org.fiveware.test.enumerated;

public enum EstadoCivil {
	SOL("Solteiro(a)"), CAS("Casado(a)"), DIV("Divorciado(a)"), VIV("Viúvo(a)"), SEP("Separado(a)"), COM(
			"Companheiro(a)");

	private String estadoCivil;

	private EstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getEstadoCivil() {
		return this.estadoCivil;
	}
}
