
/* global Mustache*/
function buscarTendencias() {
    var dataI = $('#dataI').val();
    var dataF = $('#dataF').val();
    var url = "http://localhost:8080/api/tendencia/" + formatDate(dataI) + "/" + formatDate(dataF) + "/json";
    $.getJSON(url, function (arq) {
//        var template = $('#template').html();
//        console.log($('#template').html());
        console.log("CHEGOU aqui");
        console.log(html);
        console.log(arq);
        json = "dados:"+JSON.stringify(arq);
        console.log(json);
        var template = "<tr><td class='hidden-xs'>{{ dados.codigoAcao }}</td><td>{{ nomeAcao }}</td><td>{{ data }}</td><td>{{ estadoNoPeriodo }}</td></tr>";
        var html = Mustache.render(template, JSON.parse(json));
        $('#teste').append(html);
    })
            .fail(function () {
                var error = console.log("Error ao carregar tabela!");
                insertMessege(error);
            });
    $('#dataI').val("");
    $('#dataF').val("");
    console.log(url);
}

function insertMessege(mensagem) {
    $("#mensagem").html(mensagem).css("display", "block");
}

$(function () {
    $(".datepicker").datepicker();
    $('#example').DataTable();
});

function formatDate(data) {
    data = new Date(data);
    return data.getFullYear() + "-" + (data.getMonth() + 1) + "-" + data.getDate();
}