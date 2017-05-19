//teste
//    var url = "http://localhost:8080/api/tendencia/2017-4-1/2017-4-30/json";

/* global Mustache*/
function buscarTendencias() {
    var dataI = $('#dataI').val();
    var dataF = $('#dataF').val();
    var url = "http://localhost:8080/api/tendencia/" + formatDate(dataI) + "/" + formatDate(dataF) + "/json";
    $.getJSON(url, function (arq) {
        var template = $('#template').html();
        var html = Mustache.to_html(template, arq);
        $('#tabela').html(html);
        $('#example').DataTable();
    })
            .fail(function () {
                var error = console.log("Error ao carregar tabela!");
                insertMessege(error);
            });
    $('#dataI').val("");
    $('#dataF').val("");
    console.log("Busca em processo!");
}

function insertMessege(mensagem) {
    $("#mensagem").html(mensagem).css("display", "block");
}

function formatDate(data) {
    data = new Date(data);
    return data.getFullYear() + "-" + (data.getMonth() + 1) + "-" + data.getDate();
}

$(function () {
    $(".datepicker").datepicker();
    $("#inicial").DataTable();
});