package br.com.leilson;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.leilson.Repository.CategoriaRepository;
import br.com.leilson.Repository.ProdutoRepository;
import br.com.leilson.domain.Categoria;
import br.com.leilson.domain.Produto;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository cartegoriaRepositoy;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cate1 = new Categoria(null, "Informatica");
		Categoria cate2 = new Categoria(null, "Escritorio");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impresora", 800.00);
		Produto p3 = new Produto(null, "mouse", 80.00);
		
		cate1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cate2.getProdutos().add(p2);
		
		p1.getCategorias().add(cate1);
		p2.getCategorias().addAll(Arrays.asList(cate1,cate2));
		p3.getCategorias().add(cate1);
		
		cartegoriaRepositoy.saveAll(Arrays.asList(cate1,cate2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
	}
	
}
