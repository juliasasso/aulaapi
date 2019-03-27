package br.com.ceci.aulaapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ceci.aulaapi.domain.Produto;

public interface ProdutoRepository extends JpaRepository <Produto, Integer> {
	

}
