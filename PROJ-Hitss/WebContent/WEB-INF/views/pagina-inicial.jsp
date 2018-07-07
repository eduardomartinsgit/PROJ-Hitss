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
		</script>	
	</head>
	<body>
		<div class="container">
			<table id="tabela_produtos" class="table table-striped table-bordered">
			    <thead>
			        <tr>
			            <th>Nome</th>
			            <th>Preço</th>
			            <th>Quantidade</th>
			            <th style=""></th>
			        </tr>
			    </thead>
			    <tbody>
		        <c:forEach var="produto" items="${produtos}">
			        <tr>
			            <td>${produto.nome }</td>
			            <td>${produto.preco }</td>
			            <td>${produto.quantidade }</td>
			            <td><button type="button" class="btn btn-outline-danger btn-sm">Remover</button></td>
			        </tr>
		        </c:forEach>		        		    
			    </tbody>
			</table>		
			<button type="button" class="btn btn-outline-success btn-sm">Incluir Produto</button>
		</div>
	</body>
</html>