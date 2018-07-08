<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Página Inicial - Gerenciamento de Produtos</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>	
		<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.17/angular.min.js"></script>		
		<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
  
		<script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.3.1.js"></script>
		<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
		<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>
		<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.1/css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">
		
		<script>
			$(document).ready( function () {
				
			    $('#tabela_produtos').DataTable({
			    	
			        searching: false,
			        ordering:  true,
			        responsive: true,
			        language: {
					            "decimal":        "",
					            "emptyTable":     "Sem dados disponíveis na tabela",
					            "info":           "Total de produtos: _TOTAL_ ",
					            "infoEmpty":      "Total de produtos: 0",
					            "infoFiltered":   "(filtered from _MAX_ total entries)",
					            "infoPostFix":    "",
					            "thousands":      ",",
					            "lengthMenu":     "Visualize _MENU_ produtos",
					            "loadingRecords": "Carregando...",
					            "processing":     "Processando...",
					            "search":         "Buscar:",
					            "zeroRecords":    "Nenhum registro correspondente encontrado.",
					            "paginate": {
					                "first":      "Inicio",
					                "last":       "Fim",
					                "next":       "Próximo",
					                "previous":   "Anterior"
					            },
					            "aria": {
					                "sortAscending":  ": Ativar para ordenar coluna ascendente",
					                "sortDescending": ": Ativar para ordenar coluna descendente"
					            }
					        },
			        
			       
			    });
			} );
		    function incluirProduto(){
		    	$.ajax({
	    		  type: "POST",
	    		  url: "rest/produto/incluirProduto?nome=" + $("#inputNomeProduto").val() + "&preco=" + $("#inputPreco").val() + "&quantidade=" + $("#inputQuantidade").val() + "&usuario=" + $("#inputUsuario").val() + "&status=" + $("#inputStatus").val(),
	    		  success: function(){location.reload();},
	    		  error: function(){location.reload();},
	    		});			    	
		    }
		    function abrirAlterarProduto(id, nomeProduto, preco, quantidade, status){
		    	$("#inputNomeProdutoAlterar").val(nomeProduto);
		    	$("#inputPrecoAlterar").val(preco);
		    	$("#inputQuantidadeAlterar").val(quantidade);
		    	$("#inputStatusAlterar").val(status);
		    	$("#inputIdAlterar").val(id);
		    }
		    function alterarProduto(){
		    	$.ajax({
	    		  type: "PUT",
	    		  url: "rest/produto/alterarProduto?nome=" + $("#inputNomeProdutoAlterar").val() + "&preco=" + $("#inputPrecoAlterar").val() + "&quantidade=" + $("#inputQuantidadeAlterar").val() + "&usuario=" + $("#inputUsuarioAlterar").val() + "&status=" + $("#inputStatusAlterar").val() + "&id=" + $("#inputIdAlterar").val(),
	    		  success: function(dados){location.reload();},
	    		  error: function(erro){location.reload();},
	    		});			    	
		    }		    
		    function abrirRemoverProduto(id, nomeProduto, preco){
		    	$("#inputNomeProdutoRemover").val(nomeProduto);
		    	$("#inputPrecoRemover").val(preco);
		    	$("#inputIdRemover").val(id);
		    }
		    function removerProduto(){
		    	$.ajax({
	    		  type: "DELETE",
	    		  url: "rest/produto/removerProduto?&id=" + $("#inputIdRemover").val(),
	    		  success: function(dados){location.reload();},
	    		  error: function(erro){location.reload();},
	    		});			    	
		    }	
		    function abrirComprarProduto(id, nomeProduto, preco, quantidade){
		    	$("#inputNomeProdutoComprar").val(nomeProduto);
		    	$("#inputPrecoComprar").val(preco);
		    	$("#inputIdComprar").val(id);
		    	$("#inputQuantidadeComprar").val(quantidade);

		    	if(quantidade != 0){
			    	for(var i = 1; i <= quantidade; i++){
			    		$("#inputQuantidadeComprador").append("<option value='" + i + "'>" + i + "</option>")
			    	}
		    	} 
		    	
		    }
		    function removerProduto(){
		    	$.ajax({
	    		  type: "DELETE",
	    		  url: "rest/produto/removerProduto?&id=" + $("#inputIdRemover").val(),
	    		  success: function(dados){location.reload();},
	    		  error: function(erro){location.reload();},
	    		});			    	
		    }	
		    function comprarProduto(){
		    	
		    	var idProduto = $("#inputIdComprar").val();
		    	var nomeComprador = $("#inputNomeComprador").val() + " " + $("#inputSobrenomeComprador").val();
		    	var emailComprador = $("#inputEmailComprador").val();
		    	var telefone = $("#inputTelefoneComprador").val();
		    	var cidadeComprador = $("#inputCidadeComprador").val();
		    	var quantidadeComprada = $("#inputQuantidadeComprador").val();
		    	var quantidadeRestante = $("#inputQuantidadeComprar").val() - quantidadeComprada;
		    	
		    	$.ajax({
	    		  type: "POST",
	    		  url: "rest/produto/comprarProduto?idProduto=" +idProduto+ "&nomeComprador=" + nomeComprador + "&emailComprador=" + emailComprador + "&telefoneComprador=" + telefone + "&cidadeComprador=" + cidadeComprador + "&quantidade=" + quantidadeComprada + "&quantidadeRestante=" + quantidadeRestante,
	    		  success: function(){location.reload();},
	    		  error: function(){location.reload();},
	    		});			    	
		    }		    
		</script>	
	</head>
	<body>
		<div class="container">
			<div class="alert alert-primary" role="alert" style="text-align: center; font-weight: bold; margin-top: 5%;">
			  Tabela de produtos ativos no Estoque.
			</div>
			<table id="tabela_produtos" class="table table-striped table-bordered">
			    <thead>
			        <tr>
			            <th>Nome</th>
			            <th>Preço</th>
			            <th>Quantidade</th>
			            <th>Última Atualização</th>
			            <th>Status</th>
			            <th style="width: 270px;"></th>
			        </tr>
			    </thead>
			    <tbody>
		        <c:forEach var="produto" items="${produtos}">
			        <tr>
			            <td>${produto.nome }</td>
			            <td>R$${produto.preco }</td>
			            <td>${produto.quantidade }</td>
			            <td>${produto.data_ultima_alteracao }</td>
			            <td>
			            	<c:if test="${produto.status eq 'A' }">
   				            	Ativo
			            	</c:if>
			            	<c:if test="${produto.status eq 'I' }">
   				            	Inativo
			            	</c:if>		            
			            </td>
			            <td>
			            	<c:if test="${produto.quantidade eq 0 }">
   				            	<button onclick="javascript:abrirComprarProduto('${produto.id }', '${produto.nome}', '${produto.preco }', '${produto.quantidade }');"type="button" style="margin-right: 30px;" class="btn btn-outline-primary btn-sm" data-toggle="modal" data-target="#modalComprar" disabled>Comprar</button>
			            	</c:if>
			            	<c:if test="${produto.quantidade ne 0 }">
   				            	<button onclick="javascript:abrirComprarProduto('${produto.id }', '${produto.nome}', '${produto.preco }', '${produto.quantidade }');"type="button" style="margin-right: 30px;" class="btn btn-outline-primary btn-sm" data-toggle="modal" data-target="#modalComprar">Comprar</button>
			            	</c:if>
			            	<button onclick="javascript:abrirAlterarProduto('${produto.id }','${produto.nome}', '${produto.preco}', '${produto.quantidade }', '${produto.status }');" type="button" style="margin-right: 30px;" class="btn btn-outline-warning btn-sm" data-toggle="modal" data-target="#modalAlterar">Alterar</button>
			            	<button onclick="javascript:abrirRemoverProduto('${produto.id }', '${produto.nome}', '${produto.preco }');"type="button" class="btn btn-outline-danger btn-sm" data-toggle="modal" data-target="#modalRemover">Remover</button>
			            </td>
			        </tr>
		        </c:forEach>		        		    
			    </tbody>
			</table>		
			<button style="margin-bottom: 5%;" type="button" class="btn btn-outline-success btn-sm" data-toggle="modal" data-target="#modalIncluir">Incluir Produto</button>
		</div>
	</body>
	<c:import url="modal-acoes.jsp" />
</html>