package br.com.guardaxml.domain;

import java.io.Serializable;
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
@Table(name = "xml")
@NamedQueries({
	@NamedQuery(name = "Xml.listaTipo", query = "SELECT xml FROM XMLDomain mxl WHERE xml_tipo = :xml_tipo") })

public class XMLDomain implements Serializable, Comparable<XMLDomain> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4269082692468170549L;

	public XMLDomain() {
		super();
	}

	public XMLDomain(String xml_tipo, Date xml_ano_mes, String xml_descricao) {
		super();
		this.xml_tipo = xml_tipo;
		this.xml_ano_mes = xml_ano_mes;
		this.xml_descricao = xml_descricao;
	}

	@Id
	@Column(name = "xml_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int xml_id;

	@Column(name = "xml_caminho")
	private String xml_caminho;

	@Column(name = "xml_tipo")
	private String xml_tipo;
	
	@Column(name = "xml_descricao")
	private String xml_descricao;
	
	@Temporal(value = TemporalType.DATE)
	@Column(name = "xml_ano_mes")
	private Date xml_ano_mes;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "xml_empresa", referencedColumnName = "emp_id", nullable = false)
	private EmpresaDomain empresa = new EmpresaDomain();

	public int getXml_id() {
		return xml_id;
	}

	public void setXml_id(int xml_id) {
		this.xml_id = xml_id;
	}

	public String getXml_caminho() {
		return xml_caminho;
	}

	public void setXml_caminho(String xml_caminho) {
		this.xml_caminho = xml_caminho;
	}

	public String getXml_tipo() {
		return xml_tipo;
	}

	public void setXml_tipo(String xml_tipo) {
		this.xml_tipo = xml_tipo;
	}

	public EmpresaDomain getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaDomain empresa) {
		this.empresa = empresa;
	}

	
	public Date getXml_ano_mes() {
		return xml_ano_mes;
	}

	public void setXml_ano_mes(Date xml_ano_mes) {
		this.xml_ano_mes = xml_ano_mes;
	}


	public String getXml_descricao() {
		return xml_descricao;
	}

	public void setXml_descricao(String xml_descricao) {
		this.xml_descricao = xml_descricao;
	}

	
	
	
	@Override
	public int compareTo(XMLDomain xml) {
		return this.getXml_descricao().compareTo(xml.getXml_descricao());
	}

	@Override
	public String toString() {
		return "XMLDomain [xml_id=" + xml_id + ", xml_caminho=" + xml_caminho
				+ ", xml_tipo=" + xml_tipo + ", xml_descricao=" + xml_descricao
				+ ", xml_ano_mes=" + xml_ano_mes + ", empresa=" + empresa + "]";
	}

	

}
