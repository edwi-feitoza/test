package org.fiveware.test.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.fiveware.test.model.DadosPessoais;
import org.fiveware.test.repository.DadosPessoaisRepository;
import org.fiveware.test.service.DadosPessoaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DadosPessoaisDefault implements DadosPessoaisService {

	@Autowired
	private DadosPessoaisRepository dadosPessoaisRepository;

	@Override
	public List<DadosPessoais> buscaTodosDadosPessoais() {
		Iterable<DadosPessoais> iterable = this.dadosPessoaisRepository.findAll();
		Stream<DadosPessoais> stream = StreamSupport.stream(iterable.spliterator(), false);
		List<DadosPessoais> dadosPessoais = stream.collect(Collectors.toList());
		return dadosPessoais;
	}

	@Override
	public DadosPessoais salvaDadosPessoais(DadosPessoais dadosPessoais) {
		DadosPessoais pessoais = this.dadosPessoaisRepository.save(dadosPessoais);
		return pessoais;
	}
}
