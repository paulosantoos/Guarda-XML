package br.com.guardaxml.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="empresa")
@NamedQueries({ @NamedQuery(name = "Empresa.listar", query = "SELECT empresa FROM EmpresaDomain empresa")})
public class EmpresaDomain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="emp_id")
	private int emp_id;
	
	@Column(name="emp_rsocial", length=50, nullable = false)
	private String emp_rsocial;
	
	@Column(name="emp_fant")
	private String emp_fantasia;
	
	@Column(name="emp_cnpj", length=50, nullable = false)
	private String emp_cnpj;
	
	@Column(name="emp_endereco")
	private String emp_endereco;
	
	@Column(name="emp_telefone")
	private String emp_telefone;
	
	@Column(name="emp_numero")
	private String emp_numero;
	
	@Column(name="emp_bairro")
	private String emp_bairro;
	
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "emp_cidade", referencedColumnName = "cid_id", nullable = false) 
	private CidadeDomain emp_cidade;

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_rsocial() {
		return emp_rsocial;
	}

	public void setEmp_rsocial(String emp_rsocial) {
		this.emp_rsocial = emp_rsocial;
	}

	public String getEmp_fantasia() {
		return emp_fantasia;
	}

	public void setEmp_fantasia(String emp_fantasia) {
		this.emp_fantasia = emp_fantasia;
	}

	public String getEmp_cnpj() {
		return emp_cnpj;
	}

	public void setEmp_cnpj(String emp_cnpj) {
		this.emp_cnpj = emp_cnpj;
	}

	public String getEmp_endereco() {
		return emp_endereco;
	}

	public void setEmp_endereco(String emp_endereco) {
		this.emp_endereco = emp_endereco;
	}

	public String getEmp_telefone() {
		return emp_telefone;
	}

	public void setEmp_telefone(String emp_telefone) {
		this.emp_telefone = emp_telefone;
	}

	public String getEmp_numero() {
		return emp_numero;
	}

	public void setEmp_numero(String emp_numero) {
		this.emp_numero = emp_numero;
	}

	public String getEmp_bairro() {
		return emp_bairro;
	}

	public void setEmp_bairro(String emp_bairro) {
		this.emp_bairro = emp_bairro;
	}

	public CidadeDomain getEmp_cidade() {
		return emp_cidade;
	}

	public void setEmp_cidade(CidadeDomain emp_cidade) {
		this.emp_cidade = emp_cidade;
	}

	
	
}
