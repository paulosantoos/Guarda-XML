package br.com.guardaxml.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "uf")
public class EstadoDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "uf_id")
	private String uf_id;

	@Column(name = "uf_nome", length = 50, nullable = false)
	private String nome;

	public String getUf_id() {
		return uf_id;
	}

	public void setUf_id(String uf_id) {
		this.uf_id = uf_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "EstadoDomain [uf_id=" + uf_id + ", nome=" + nome + "]";
	}
	
	

}
