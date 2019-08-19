package br.com.leilson.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.leilson.domain.Produto;

@Repository
public interface ProdutoRepository  extends JpaRepository<Produto, Integer>{

}
