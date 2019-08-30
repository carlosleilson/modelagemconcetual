package br.com.leilson.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leilson.Repository.ClienteRepository;
import br.com.leilson.domain.Cliente;
import br.com.leilson.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscarPorId(Integer id) {
		Optional<Cliente> categoriaTmp = repo.findById(id);
		return categoriaTmp.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
}
