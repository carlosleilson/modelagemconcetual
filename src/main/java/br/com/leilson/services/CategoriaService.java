package br.com.leilson.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leilson.Repository.CategoriaRepository;
import br.com.leilson.domain.Categoria;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscarPorId(Integer id) {
		Optional<Categoria> categoriaTmp = repo.findById(id);
		return categoriaTmp.orElse(null);
	}
}
