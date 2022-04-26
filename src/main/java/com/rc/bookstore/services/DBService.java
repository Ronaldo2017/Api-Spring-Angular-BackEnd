package com.rc.bookstore.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rc.bookstore.domain.Categoria;
import com.rc.bookstore.domain.Livro;
import com.rc.bookstore.repositories.CategoriaRepository;
import com.rc.bookstore.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private LivroRepository livroRepository;

	public void instanciaDB() {
		Categoria cat1 = new Categoria(null, "TI", "Tecnologia da Informação");
		Categoria cat2 = new Categoria(null, "Finanças", "Finanças do Básico ao avançado");
		Categoria cat3 = new Categoria(null, "Investimento", "Comece aqui seus investimentos");
		Livro l1 = new Livro(null, "Clean code", "Juca da silva", "Lorem ipsum", cat1);
		Livro l2 = new Livro(null, "Finanças do Jeito certo", "Silvia Abreu", "Lorem ipsum", cat2);
		Livro l3 = new Livro(null, "Investindo no caminho certo", "João Pedro", "Lorem ipsum", cat3);

		cat1.getLivros().addAll(Arrays.asList(l1));
		cat2.getLivros().addAll(Arrays.asList(l2));
		cat3.getLivros().addAll(Arrays.asList(l3));

		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3));

	}

}
