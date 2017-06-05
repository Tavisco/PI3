/* global Mustache*/

function encontrarGaps() {
    var dataInicial = $('#dataIicial').val();
    var dataFinal = $('#dataFinal').val();
    var url = "http://localhost:8080/api/gaps/" + formatarDate(dataInicial) + "/" + formatarDate(dataFinal) + "/json";
    $.getJSON(url, function (arq) {
        var template = $('#template').html();
        var html = Mustache.to_html(template, arq);
        $('#tabela').html(html);
        $('#example').DataTable();
    })
            .fail(function () {
                var erro = console.log("Erro ao carregar tabela!");
                insertMessege(erro);
            });
    $('#dataI').val("");
    $('#dataF').val("");
    console.log("Iniciando busca...");
}

function formatarDate(dataFormatada) {
    dataFormatada = new Date(dataFormatada);
    return dataFormatada.getFullYear() + "-" + (dataFormatada.getMonth() + 1) + "-" + dataFormatada.getDate();
}


