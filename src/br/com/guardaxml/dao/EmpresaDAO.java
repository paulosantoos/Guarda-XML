package br.com.guardaxml.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.guardaxml.domain.EmpresaDomain;
import br.com.guardaxml.util.HibernateUtil;

public class EmpresaDAO {
	
	@SuppressWarnings("unchecked")
	public List<EmpresaDomain> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<EmpresaDomain> listEmpresa = null;

		try {
			Query consulta = sessao.getNamedQuery("Empresa.listar");
			listEmpresa = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return listEmpresa;
	}

}
