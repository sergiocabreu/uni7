$(function() {
	
	var id = obterParametroDaUrlPorNome('id');
	
	if (id) {
		VeiculosProxy.selecionar(id).done(obterOk).fail(tratarErro);
	}
	
	$("#salvar").click(function(event) {
		var veiculo = {
			id : $("#id").val(),
			placa : $("#placa").val(),
			proprietario : $("#proprietario").val(),
			emplacamento : $("#emplacamento").val(),
			ipva : $("#ipva").val()
		};

		if (veiculo.id) {
			VeiculosProxy.atualizar(veiculo.id, veiculo).done(atualizarOk).fail(tratarErro);
		} else {
			VeiculosProxy.inserir(veiculo).done(inserirOk).fail(tratarErro);
		}
	});
	
	$("#excluir").click(function(event) {
		var id = $("#id").val();
		VeiculosProxy.excluir(id).done(excluirOk).fail(tratarErro);
		});	
});


function excluirOk(data, textStatus, jqXHR) {
	$("#id").val(null);
	$("#placa").val(null);
	$("#proprietario").val(null);
	$("#emplacamento").val(null);
	$("#global-message").addClass("alert-success")
	.text("Usuário excluído com sucesso.")
	.show();
	}

function inserirOk(data, textStatus, jqXHR) {
	$("#id").val(data);
	$("#global-message").addClass("alert-success").text(
			"Veículo com id = " + data + " criado com sucesso.").show();
}

function atualizarOk(data, textStatus, jqXHR) {
	$("#global-message").addClass("alert-success").text("Veículo atualizado com sucesso.").show();
}

function obterOk(data) {
	$("#id").val(data.id);
	$("#placa").val(data.placa);
	$("#proprietario").val(data.proprietario);
	$("#emplacamento").val(data.emplacamento);
	$("#ipva").val(data.ipva);
}

function tratarErro(request) {
	switch (request.status) {	
		case 404:
			$("#global-message").addClass("alert-danger").text("O registro solicitado não foi encontrado!").show();
			break;
	
		default:
			$("#global-message").addClass("alert-danger").text("Erro inesperado.").show();
			break;
	}
}

function obterParametroDaUrlPorNome(name) {
	name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
	var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"), results = regex.exec(location.search);
	return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g," "));
}