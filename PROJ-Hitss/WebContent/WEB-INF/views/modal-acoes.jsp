	<!-- Modal Incluir Produto-->
	<div class="modal fade" id="modalIncluir" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-centered" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalCenterTitle">Incluir Produto</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        Preencha os campos abaixo para incluir um novo produto no estoque <br />
			<form style="margin-top: 30px;">
			  <div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="inputNomeProduto">Nome do Produto</label>
			      <input type="text" class="form-control" id="inputNomeProduto" placeholder="Produto: Computador" maxlength="100">
			    </div>
			    <div class="form-group col-md-6">
			      <label for="inputPreco">Preço</label>
			      <input type="text" class="form-control" id="inputPreco" placeholder="Preço: 29.90" maxlength="5">
			    </div>
			  </div>			
			  <div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="inputQuantidade">Quantidade</label>
			      <input type="email" class="form-control" id="inputQuantidade" placeholder="Quantidade: 10" pattern="[0-9]+$" maxlength="5">
			    </div>
			    <div class="form-group col-md-6">
			      <label for="inputUsuario">Usuário</label>
			      <input type="text" class="form-control" id="inputUsuario" placeholder="Usuário: Eduardo" required="required" name="numbers" pattern="[0-9]+$" maxlength="20">
			    </div>			    
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-12">
			      <label for="inputStatus">Status</label>
			      <select id="inputStatus" class="form-control">
			        <option selected>Selecione...</option>
			        <option value="A">Ativo</option>
			        <option value="I">Inativo</option>
			      </select>
			    </div>
			  </div>
			</form>	        
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
	        <button type="button" class="btn btn-success" onclick="javascript:incluirProduto();">Incluir</button>
	      </div>
	    </div>
	  </div>
	</div>		
	
	<!-- Modal Compra-->
	<div class="modal fade" id="modalComprar" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-centered" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalCenterTitle">Realizar Compra</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        Preencha os dados abaixo para realizar a compra. <br />
			<form style="margin-top: 30px;">
				<div class="form-row">
				  <div class="form-group col-md-2">
				    <label for="inputIdComprar">ID</label>
				    <input type="text" class="form-control" id="inputIdComprar" disabled>
				  </div>			  
			    <div class="form-group col-md-6">
			      <label for="inputNomeProdutoAlterar">Nome do Produto</label>
			      <input type="text" class="form-control" id="inputNomeProdutoComprar" maxlength="100" disabled>
			    </div>
			    <div class="form-group col-md-2">
			      <label for="inputPrecoComprar">Preço</label>
			      <input type="text" class="form-control" id="inputPrecoComprar" disabled>
			    </div>
			    <div class="form-group col-md-2">
			      <label for="inputQuantidadeComprar">Estoque</label>
			      <input type="text" class="form-control" id="inputQuantidadeComprar" disabled>
			    </div>			    
			  </div>			
			  <div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="inputNomeComprador">Nome</label>
			      <input type="text" class="form-control" id="inputNomeComprador" placeholder="Nome">
			    </div>
			    <div class="form-group col-md-6">
			      <label for="inputSobrenomeComprador">Sobrenome</label>
			      <input type="text" class="form-control" id="inputSobrenomeComprador" placeholder="Sobrenome">
			    </div>
			  </div>			
			  <div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="inputEmailComprador">Email</label>
			      <input type="email" class="form-control" id="inputEmailComprador" placeholder="Email">
			    </div>
			    <div class="form-group col-md-6">
			      <label for="inputTelefoneComprador">Telefone</label>
			      <input type="text" class="form-control" id="inputTelefoneComprador" placeholder="Telefone" required="required" name="numbers" pattern="[0-9]+$" >
			    </div>			    
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="inputCidadeComprador">Cidade</label>
			      <input type="text" class="form-control" id="inputCidadeComprador" pattern="[a-z\s]+$">
			    </div>
			    <div class="form-group col-md-6">
			      <label for="inputQuantidadeComprador">Quantidade</label>
			      <select id="inputQuantidadeComprador" class="form-control">
			      </select>
			    </div>
			  </div>
			</form>	        
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
	        <button onclick="javascript:comprarProduto();" type="button" class="btn btn-primary">Comprar</button>
	      </div>
	    </div>
	  </div>
	</div>	
	
	<!-- Modal Alterar-->
	<div class="modal fade" id="modalAlterar" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-centered" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalCenterTitle">Alterar Produto</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        Alteração no Produto
			<form style="margin-top: 30px;">
			  <div class="form-row">
				  <div class="form-group col-md-2">
				    <label for="inputIdAlterar">ID</label>
				    <input type="text" class="form-control" id="inputIdAlterar" disabled>
				  </div>			  
			    <div class="form-group col-md-5">
			      <label for="inputNomeProdutoAlterar">Nome do Produto</label>
			      <input type="text" class="form-control" id="inputNomeProdutoAlterar" placeholder="Produto: Computador" maxlength="100">
			    </div>
			    <div class="form-group col-md-5">
			      <label for="inputPrecoAlterar">Preço</label>
			      <input type="text" class="form-control" id="inputPrecoAlterar" placeholder="Preço: 29.90">
			    </div>
			  </div>			
			  <div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="inputQuantidadeAlterar">Quantidade</label>
			      <input type="email" class="form-control" id="inputQuantidadeAlterar" placeholder="Quantidade: 10" pattern="[0-9]+$" maxlength="4">
			    </div>
			    <div class="form-group col-md-6">
			      <label for="inputUsuarioAlterar">Usuário</label>
			      <input type="text" class="form-control" id="inputUsuarioAlterar" placeholder="Usuário: Eduardo" required="required" name="numbers" pattern="[0-9]+$" maxlength="20">
			    </div>			    
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-12">
			      <label for="inputStatusAlterar">Status</label>
			      <select id="inputStatusAlterar" class="form-control">
			        <option selected>Selecione...</option>
			        <option value="A">Ativo</option>
			        <option value="I">Inativo</option>
			      </select>
			    </div>
			  </div>
			</form>	        
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
	        <button onclick="javascript:alterarProduto();" type="button" class="btn btn-warning">Alterar</button>
	      </div>
	    </div>
	  </div>
	</div>	

	<!-- Modal Remover-->
	<div class="modal fade" id="modalRemover" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-centered" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalCenterTitle">Remover Produto</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        Tem certeza que deseja remover o produto do estoque?
			<form style="margin-top: 30px;">
			  <div class="form-row">
				  <div class="form-group col-md-2">
				    <label for="inputIdRemover">ID</label>
				    <input type="text" class="form-control" id="inputIdRemover" disabled>
				  </div>			  
			    <div class="form-group col-md-5">
			      <label for="inputNomeProdutoRemover">Nome do Produto</label>
			      <input type="text" class="form-control" id="inputNomeProdutoRemover" placeholder="Produto: Computador" maxlength="100" disabled>
			    </div>
			    <div class="form-group col-md-5">
			      <label for="inputPrecoRemover">Preço</label>
			      <input type="text" class="form-control" id="inputPrecoRemover" placeholder="Preço: 29.90" disabled>
			    </div>
			  </div>			
			</form>	        
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
	        <button onclick="javascript:removerProduto();" type="button" class="btn btn-danger">Remover</button>
	      </div>
	    </div>
	  </div>
	</div>