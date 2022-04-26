package com.rc.bookstore.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import com.rc.bookstore.domain.Categoria;

public class CategoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotNull(message = "Por favor preencha com o NOME")
    @Column(length = 100)
	private String nome;
	
    @NotNull(message = "Por favor preencha com a DESCRIÇÃO")
    @Column(length = 100)
	private String descricao;

	public CategoriaDTO() {
		super();
	}

	public CategoriaDTO(Categoria obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.descricao = obj.getDescricao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
