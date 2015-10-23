package br.com.guardaxml.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(name = "cidade")

public class CidadeDomain {

		@Id //DEFINE QUE É A CHAVE PRIMARIA
		@GeneratedValue(strategy = GenerationType.AUTO) //DEFINE QUE O VALOR SERÁ GERADO AUTOMATICAMENTE
		@Column(name = "cid_id") //DEFINE A COLUNA CORRESPONDENTE NO BANCO DE DADOS
		private Integer cid_id;

		@Column(name = "cid_nome", length = 50, nullable = false)
		private String cid_nome;
		
		@ManyToOne(fetch = FetchType.EAGER) //DEFINE A CHAVE ESTRANGEIRA, FETCH.EAGER, SIGNIFICA QUE QUANDO CHAMAR A CLASSE CIDADE, CARREGARA TBM OS DADOS DO ESTADO
		@JoinColumn(name = "cid_uf", referencedColumnName = "uf_id", nullable = false) //DEFINE QUAIS OS CAMPOS DAS TABELAS, NULLABLE = FALSE SINIFICA QUE NÃO PODE SER NULO
		private EstadoDomain estado;

		public Integer getCid_id() {
			return cid_id;
		}

		public void setCid_id(Integer cid_id) {
			this.cid_id = cid_id;
		}

		public String getCid_nome() {
			return cid_nome;
		}

		public void setCid_nome(String cid_nome) {
			this.cid_nome = cid_nome;
		}

		public EstadoDomain getEstado() {
			return estado;
		}

		public void setEstado(EstadoDomain estado) {
			this.estado = estado;
		}

		@Override
		public String toString() {
			return "CidadeDomain [cid_id=" + cid_id + ", cid_nome=" + cid_nome
					+ "]";
		}
		
		
		

		

	
}
