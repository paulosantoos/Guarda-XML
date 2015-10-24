package br.com.guardaxml.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.guardaxml.domain.XMLDomain;
import br.com.guardaxml.util.HibernateUtil;

public class XMLDAO {

	public XMLDomain listaTipo(String xml_tipo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		XMLDomain xml = null;

		try {
			Query consulta = sessao.getNamedQuery("Xml.listaTipo");
			consulta.setString("xml_tipo", xml_tipo);
			xml = (XMLDomain) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return xml;
	}

}
