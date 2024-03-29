package br.com.leilson;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.leilson.Repository.CategoriaRepository;
import br.com.leilson.Repository.CidadeRepository;
import br.com.leilson.Repository.ClienteRepository;
import br.com.leilson.Repository.EnderecoRepository;
import br.com.leilson.Repository.EstadoRepository;
import br.com.leilson.Repository.ProdutoRepository;
import br.com.leilson.domain.Categoria;
import br.com.leilson.domain.Cidade;
import br.com.leilson.domain.Cliente;
import br.com.leilson.domain.Endereco;
import br.com.leilson.domain.Estado;
import br.com.leilson.domain.Produto;
import br.com.leilson.domain.enums.TipoCliente;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository cartegoriaRepositoy;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteRepository  clienteRepository;

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

		Estado est1 = new Estado(null, "Rio de Janeiro");
		Estado est2 = new Estado(null, "Sao Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia",est1);
		Cidade c2 = new Cidade(null, "Sao Paulo",est2);
		Cidade c3 = new Cidade(null, "Campinas",est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2,c3));
		
		Cliente cliente = new Cliente(null,"Maria Silva","maria@gmail.com","36378912377", TipoCliente.PESSOAFISICA);
		
		cliente.getTelefones().addAll(Arrays.asList("27363323","93838393"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apt 203", "Jardin", "38280834", c1, cliente);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38770112", c2, cliente);
		cliente.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.save(cliente);
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
	}
	
}
