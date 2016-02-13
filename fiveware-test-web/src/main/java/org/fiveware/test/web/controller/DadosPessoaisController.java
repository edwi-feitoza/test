package org.fiveware.test.web.controller;

import java.io.IOException;
import java.util.List;
import org.fiveware.test.enumerated.EstadoCivil;
import org.fiveware.test.enumerated.Sexo;
import org.fiveware.test.model.DadosPessoais;
import org.fiveware.test.service.DadosPessoaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DadosPessoaisController {

	@Autowired
	private DadosPessoaisService dadosPessoaisService;

	@RequestMapping(value = "/")
	public String test(Model model) throws IOException {

		List<DadosPessoais> dadosPessoais = this.dadosPessoaisService.buscaTodosDadosPessoais();
		model.addAttribute("estadosCivis", EstadoCivil.values());
		model.addAttribute("sexos", Sexo.values());
		model.addAttribute("dadosPessoais", dadosPessoais);

		return "dadosPessoais";
	}

	@RequestMapping(value = "/salvar-dados-pessoais", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody DadosPessoais post(@RequestBody DadosPessoais dadosPessoais) {
		DadosPessoais dadosPessoaisSalvos = this.dadosPessoaisService.salvaDadosPessoais(dadosPessoais);
		return dadosPessoaisSalvos;
	}
}
