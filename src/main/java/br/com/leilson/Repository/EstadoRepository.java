package br.com.leilson.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.leilson.domain.Estado;


@Repository
public interface EstadoRepository  extends JpaRepository<Estado, Integer>{

}
