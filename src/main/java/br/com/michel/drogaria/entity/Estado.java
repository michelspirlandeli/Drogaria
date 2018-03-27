package br.com.michel.drogaria.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity//vai gerar uma tabela
public class Estado extends GenericDomain {
	@Column(length=2, nullable = false)//significa not null campo obrigatorio
	private String sigla;
	@Column(length = 50, nullable = false)
	private String nome;

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
