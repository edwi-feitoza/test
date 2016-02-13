package org.fiveware.test.service;

import java.util.List;
import org.fiveware.test.model.DadosPessoais;

public interface DadosPessoaisService {

	List<DadosPessoais> buscaTodosDadosPessoais();

	DadosPessoais salvaDadosPessoais(DadosPessoais dadosPessoais);
}
