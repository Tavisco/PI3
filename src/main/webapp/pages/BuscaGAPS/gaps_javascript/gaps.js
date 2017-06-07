
/* global Mustache*/
function encontrarGaps() {
    var dataInicial = $('#dataInicial').val();
    var dataFinal = $('#dataFinal').val();
    var caminho = "http://localhost:8080/api/gaps/" + formatarData(dataInicial) + "/" + formatarData(dataFinal) + "/json";
    $.getJSON(caminho, function (arq) {
        var template = $('#template').html();
        var html = Mustache.to_html(template, arq);
        $('#tabela').html(html);
        $('#example').DataTable();
    })
            .fail(function () {
                var erro = console.log("Erro ao carregar tabela !");
                insertMessege(erro);
            });
    $('#dataInicial').val("");
    $('#dataFinal').val("");
    console.log("Iniciando busca...");
}

function formatarData(dataFormatada) {
    dataFormatada = new Date(dataFormatada);
    return dataFormatada.getFullYear() + "-" + (dataFormatada.getMonth() + 1) + "-" + dataFormatada.getDate();
}