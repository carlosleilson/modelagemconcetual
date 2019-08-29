package br.com.leilson.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.leilson.domain.Cliente;


@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Integer>{

}
