package br.com.guardaxml.domain;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "usuario")
@NamedQueries({ 
	@NamedQuery(name = "UsuarioDomain.listar", query = "SELECT usuarioDomain FROM UsuarioDomain usuarioDomain"),
	@NamedQuery(name = "UsuarioDomain.autenticar", query = "SELECT usuarioDomain FROM UsuarioDomain usuarioDomain WHERE usuarioDomain.usu_email = :usu_email AND usuarioDomain.usu_senha = :usu_senha") })
public class UsuarioDomain {

	@Id
	@Column(name = "usu_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int usu_id;

	@Column(name = "usu_nome", length = 50, nullable = false)
	private String usu_nome;

	@Column(name = "usu_senha", length = 50, nullable = false)
	private String usu_senha;
	
	@Column(name = "usu_email", length = 50, nullable = false, unique = true)
	private String usu_email;
	
	@Temporal(value = TemporalType.DATE)
	@Column(name = "usu_dtcadastro")
	private Date usu_dtcadastro;
	
	@Temporal(value = TemporalType.DATE)
	@Column(name = "usu_dtalteracao")
	private Date usu_dtalteracao;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "usu_empresa", referencedColumnName = "emp_id", nullable = false)
	private EmpresaDomain empresa = new EmpresaDomain();

	public int getUsu_id() {
		return usu_id;
	}

	public void setUsu_id(int usu_id) {
		this.usu_id = usu_id;
	}

	public String getUsu_nome() {
		return usu_nome;
	}

	public void setUsu_nome(String usu_nome) {
		this.usu_nome = usu_nome;
	}

	public String getUsu_senha() {
		return usu_senha;
	}

	public void setUsu_senha(String usu_senha) {
		this.usu_senha = usu_senha;
	}

	public EmpresaDomain getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaDomain empresa) {
		this.empresa = empresa;
	}

	public String getUsu_email() {
		return usu_email;
	}

	public void setUsu_email(String usu_email) {
		this.usu_email = usu_email;
	}
	

	public Date getUsu_dtcadastro() {
		return usu_dtcadastro;
	}

	public void setUsu_dtcadastro(Date usu_dtcadastro) {
		this.usu_dtcadastro = usu_dtcadastro;
	}

	public Date getUsu_dtalteracao() {
		return usu_dtalteracao;
	}

	public void setUsu_dtalteracao(Date usu_dtalteracao) {
		this.usu_dtalteracao = usu_dtalteracao;
	}

	@Override
	public String toString() {
		return "UsuarioDomain [usu_id=" + usu_id + ", usu_nome=" + usu_nome
				+ ", usu_senha=" + usu_senha + ", usu_email=" + usu_email
				+ ", usu_dtcadastro=" + usu_dtcadastro + ", usu_dtalteracao="
				+ usu_dtalteracao + ", empresa=" + empresa + "]";
	}

	

	

}
