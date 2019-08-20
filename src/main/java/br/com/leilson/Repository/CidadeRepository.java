/**
 * 
 */
package br.com.leilson.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.leilson.domain.Cidade;

/**
 * @author leilson
 *
 */
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
