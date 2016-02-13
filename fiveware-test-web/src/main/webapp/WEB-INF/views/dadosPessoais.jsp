<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.12.0.min.js"></script>
<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
<script type="text/javascript">
	
	$().ready(function(){
		$("#formCadastroDadosPessoais").hide();
		
		$("#cadastrarDadosPessoais").click(function(e){
			e.preventDefault();
			$("#formCadastroDadosPessoais").show();
			$("#tabelaDadosPessoais").hide();
			$("#naoTemDados").hide();
			$("#cadastrarDadosPessoais").hide();
		});
		
		$("#enviar").click(function(e){
			e.preventDefault();
			if(coletaDados()){
				$("#formCadastroDadosPessoais").hide();
				$("#tabelaDadosPessoais").show();
				$("#naoTemDados").hide();
				$("#cadastrarDadosPessoais").show();	
			};
		});
	});
	
	function coletaDados(){
		var nome = $("#nome").val();
		var sexo;
		if(!$("input[name=sexo]:checked").val()){
			alert("Selecione uma opção de sexo");
			return false;
		} else {
			sexo = $("input[name=sexo]:checked", "#formCadastroDadosPessoais").val();	
		}
		 
		var estadoCivil = $("#estadoCivil option:selected").val();
		var telefone = $("#telefone").val();
		var possuiImovel = false;
		if($("#possuiImovel").is(":checked")){
			possuiImovel = true;
		}
		var dados = '{ "nome":"' + nome + '", "sexo":"' + sexo + '", "estadoCivil":"' + estadoCivil + '", "telefone":"' + telefone + '", "possuiImovel":' + possuiImovel + '}';
		console.log(dados);
		sendAjax(dados);
		return true;
	}
	
	function sendAjax(dados){
		$.ajax({
			url: "/fiveware-test-web/salvar-dados-pessoais",
			type: "POST",
			dataType: 'JSON',
			data: dados,
			Accept: 'application/json',
			contentType: 'application/json',
			success: function(data){
				alert("Dados pessoais cadastrados com sucesso! \nID: " + data.id + "\nNome: " + data.nome + "\nSexo: " + data.sexo + "\nEstado Civil: " + data.estadoCivil + "\nTelefone: " + data.telefone);
			},
			error: function(data, status, err){
				alert("error: "+data+" status: "+status+" err:"+err);
			}
		});
	};
</script>
<style type="text/css">
div {
	position: fixed;
	top: 50%;
	left: 50%;
	margin-top: -100px;
	margin-left: -200px;
}
</style>
<title>Cadastro</title>
</head>
<body>
	<div>
		<form id="formCadastroDadosPessoais" class="pure-form pure-form-stacked">
			<fieldset>
				<legend>Cadastro de Dados Pessoais</legend>

				<label for="nome">Nome</label>
				 <input id="nome" name="nome" type="text" placeholder="Nome">
				 
				 <label for="sexo" class="pure-radio">
				 	<c:forEach items="${sexos}" var="sexo">
						<input id="sexo" name="sexo" type="radio" value="${sexo}"> ${sexo.sexo}	
        			</c:forEach>
				</label>
				<label for="estadoCivil">State</label>
				<select id="estadoCivil" name="estadoCivil">
					<c:forEach items="${estadosCivis}" var="estadoCivil">
						<option value="${estadoCivil}">${estadoCivil.estadoCivil}</option>
					</c:forEach>
				</select>
				
				<label for="telefone">Telefone</label>
				<input id="telefone" name="telefone" type="text" placeholder="Telefone">
				
				<label for="possuiImovel" class="pure-checkbox">
					<input id="possuiImovel" name="possuiImovel" type="checkbox"> Possui Imóvel?
				</label>

				<button id="enviar" type="button" class="pure-button pure-button-primary">Enviar</button>
			</fieldset>
		</form>

		<c:if test="${fn:length(dadosPessoais) > 0 }">
			<table id="tabelaDadosPessoais" class="pure-table">
				<thead>
					<tr>
						<th>Nome</th>
						<th>Sexo</th>
						<th>Estado Civil</th>
						<th>Telefone</th>
						<th>Possui Imóvel</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${dadosPessoais}" var="dadoPessoal">
						<tr>
							<td>${dadoPessoal.nome}</td>
							<td>${dadoPessoal.sexo.sexo}</td>
							<td>${dadoPessoal.estadoCivil.estadoCivil}</td>
							<td>${dadoPessoal.telefone}</td>
							<c:if test="${dadoPessoal.possuiImovel}">
								<td>SIM</td>
							</c:if>

							<c:if test="${not dadoPessoal.possuiImovel}">
								<td>NÃO</td>
							</c:if>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

		<c:if test="${fn:length(dadosPessoais) eq 0 }">
			<div id="naoTemDados">Não há dados pessoais cadastrados ainda no banco de dados</div>
		</c:if>
		
		<br />
		<br />
		<br />

		<form class="pure-form pure-form-stacked">
			<fieldset>
				<button id="cadastrarDadosPessoais" type="button" class="pure-button pure-button-primary">Cadastrar Novos Dados</button>
			</fieldset>
		</form>
	</div>
</body>
</html>
