
/* global Mustache */
function buscarTendencias() {
    var dataI = $('#dataI').val();
    var dataF = $('#dataF').val();
    var url = "127.0.0.1/api/tendencia/" + dataI + "/" + dataF + "/json";

    $.getJSON(url, function (data) {
        var template = $('#template').html();
        var html = Mustache.to_html(template, data);
        $('#tblTendencias').append(html);
    })
            .fail(function () {
                var error = console.log("Error ao carregar tabela!");
                insertMessege(error, "alert alert-danger");
            });

}

function insertMessege(mensagem, classe) {
    $("#mensagem").removeClass();
    $("#mensagem").html(mensagem).addClass(classe).css("display", "block");
}

$( function() {
    $( ".datepicker" ).datepicker();
  } );