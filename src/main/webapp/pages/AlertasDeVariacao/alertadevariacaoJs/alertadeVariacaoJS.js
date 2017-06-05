/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function incluirCadastro(data){
    
    //refazer o código abaixo usando template mustache.
    //o código deverá ficar mais simples e limpo usando o template
    var newRow = '<tr><td>'+ data.RestResponse.result.ip + '</td>'+
        '<td class="hidden-xs hidden-sm">'+ data.RestResponse.result.ip +'</td>'+
        '<td>'+ data.RestResponse.result.Ativo +'</td>' +
        '<td>'+ data.RestResponse.result.CotacaoAtual +'</td>' +
        '<td>'+ data.RestResponse.result.ValorMaximo +'</td>' +
        '<td>'+ data.RestResponse.result.ValorMinimo +'</td>' +
        '<td><button type="button" onclick="removerIP(this)" class="btn btn-xs btn-danger">'+
            '<span class="glyphicon glyphicon-trash"></span>'+
            '</button>'+
        '</td>'+
    '</tr>';
    $('#tblIPs').append(newRow);
    $('#txtIP').prop('disabled', false);
    $('#txtIP').val('');
    $('#btnIP').prop('disabled', false);
}
function removerCadastro(ref){
    $(ref).closest('tr').remove();    
}