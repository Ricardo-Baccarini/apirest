package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController // Notação rest pois a api é rest recebe as requisições HTTP

// uri pardrão para a api
@RequestMapping(value = "/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins="*") // Qualquer dominio acessa essa api. Caso deseja um dominio especifico trocar para "/http:dominio"
public class ProdutoResource {

	// Importa, cria um ponto de injeção dentro do controller.

	@Autowired
	ProdutoRepository produtoRepository;

	// implementa o método get que traz todos os produtos salvos no banco de dados
	// uri do método
	@GetMapping("/produtos")
	@ApiOperation(value="Retorna a lista com todos os produtos")
	public List<Produto> listaProdutos() {
		// utiliza o repository
		return produtoRepository.findAll();
	}

	@GetMapping("/produto/{id}")
	@ApiOperation(value="Retorna apenas um produto de acordo com seu ID")
	public Produto listaProdutosUnico(@PathVariable(value = "id") long id) {
		// utiliza o repository
		return produtoRepository.findById(id);
	}

	@PostMapping("/produto") // nesse caso o produto vem sem Id entao faz insert
	@ApiOperation(value="Salva um produto no banco de dados")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

	@DeleteMapping("/produto")
	@ApiOperation(value="Deleta um produto do banco de dados")
	public void deletaProduto(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
	}

	@PutMapping("/produto") // Put é update o produto vem com o Id por isso nao faz insert
	@ApiOperation(value="Atualiza um produto no banco de dados")
	public Produto atualizaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
}
