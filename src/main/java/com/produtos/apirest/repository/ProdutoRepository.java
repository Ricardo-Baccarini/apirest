package com.produtos.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.apirest.models.Produto;

// Passa a entidade e o tipo do Id // Faz isso para utilizar as persistencias do bando de dados, como save, delete, findall, findbyid, etc.
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	Produto findById(long id);

}
