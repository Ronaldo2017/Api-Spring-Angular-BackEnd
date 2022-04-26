package com.rc.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rc.bookstore.domain.Categoria;
import com.rc.bookstore.dto.CategoriaDTO;
import com.rc.bookstore.repositories.CategoriaRepository;
import com.rc.bookstore.services.exceptions.DataIntegrityViolationException;
import com.rc.bookstore.services.exceptions.ObjectNotFounException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria findById(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFounException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));

	}

	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

	public Categoria create(Categoria obj) {
		// se tiver o id, atualiza as informações trazidas = não cria outro registro com
		// o mesmo id
		obj.setId(null);
		return categoriaRepository.save(obj);
	}

	public Categoria update(Integer id, CategoriaDTO objDTO) {
		Categoria obj = findById(id);
		obj.setNome(objDTO.getNome());
		obj.setDescricao(objDTO.getDescricao());
		return categoriaRepository.save(obj);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			categoriaRepository.deleteById(id);
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException(
					"Categoria não pode ser deletado! Possui livros associados.");
		}

	}
}
