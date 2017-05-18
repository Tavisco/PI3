//teste

/* global Mustache*/
function buscarTendencias() {
    var dataI = $('#dataI').val();
    var dataF = $('#dataF').val();
//    var url = "http://localhost:8080/api/tendencia/" + formatDate(dataI) + "/" + formatDate(dataF) + "/json";
    var url = "http://localhost:8080/api/tendencia/2017-4-1/2017-4-30/json";
    $.getJSON(url, function (arq) {
        
//        var template = $({url: "../modelagem-tendencia/template.mst", dataType: 'text'});
//        console.log(template);
        var template = $('#template').html();
        var html = Mustache.to_html(template, arq);
        console.log("aquii");
        console.log(html);
        $('#tblTendencias').html(html);
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

function formatDate(data) {
    data = new Date(data);
    return data.getFullYear() + "-" + (data.getMonth() + 1) + "-" + data.getDate();
}

$(function () {
    $(".datepicker").datepicker();
    $('#example').DataTable();
});