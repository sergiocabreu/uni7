$(function() {
	VeiculosProxy.selecionarTodos().done(buscarOk);
});
function buscarOk(veiculos) {
	
	var body = document.getElementsByTagName("tbody")[0];
	
	$(body).empty();
	
	if (veiculos) {
		
		for (var i = 0; i < veiculos.length; i++) {
			
			var veiculo = veiculos[i];
			
			var row = document.createElement('tr');
			
			var cellId = document.createElement('td');
			var textId = document.createTextNode(veiculo.id);
			cellId.appendChild(textId);
			
			var cellPlaca = document.createElement('td');
			var textPlaca = document.createTextNode(veiculo.placa);
			var linkPlaca = document.createElement('a');
			linkPlaca.setAttribute("href","veiculos-editar.html?id=" + veiculo.id);
			linkPlaca.appendChild(textPlaca);
			cellPlaca.appendChild(linkPlaca);
			
			var cellProprietario = document.createElement('td');
			var textProprietario = document.createTextNode(veiculo.proprietario);
			cellProprietario.appendChild(textProprietario);
			
			var cellEmplacamento = document.createElement('td');
			var textEmplacamento = document.createTextNode(veiculo.emplacamento);
			cellEmplacamento.appendChild(textEmplacamento);
			
			var cellIpva = document.createElement('td');
			var textIpva = document.createTextNode(veiculo.ipva);
			cellIpva.appendChild(textIpva);
			
			row.appendChild(cellId);
			row.appendChild(cellPlaca);
			row.appendChild(cellProprietario);
			row.appendChild(cellEmplacamento);
			row.appendChild(cellIpva);

			
			body.appendChild(row);
		}
	} else {
		var table = document.getElementsByTagName("table")[0];
		var foot = document.createElement('tfoot');
		var emptyRow = document.createElement('tr');
		var emptyCell = document.createElement('td');
		var noRegisterText = document
				.createTextNode("Nenhum registro encontrado!");
		emptyCell.appendChild(noRegisterText);
		emptyCell.setAttribute("colspan", 4);
		emptyRow.appendChild(emptyCell);
		foot.appendChild(emptyRow);
		table.appendChild(foot);
	}
}