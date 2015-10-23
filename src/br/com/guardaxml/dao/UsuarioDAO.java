package br.com.guardaxml.dao;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.guardaxml.domain.UsuarioDomain;
import br.com.guardaxml.util.HibernateUtil;


public class UsuarioDAO {

	// METODO PARA AUTENTICAÇÃO
	public UsuarioDomain autenticar(String email, String senha) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		UsuarioDomain UsuarioDomain = null;

		try {
			Query consulta = sessao.getNamedQuery("UsuarioDomain.autenticar");
			consulta.setString("usu_email", email);
			consulta.setString("usu_senha", senha);

			UsuarioDomain = (UsuarioDomain) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return UsuarioDomain;
	}

	// METODO PARA SALVAR OU ATUALIZAR
	public  void saveOrUpdate(UsuarioDomain usuarioDomain){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.saveOrUpdate(usuarioDomain);
			transacao.commit();
			
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}
	}

	// METODO PARA LISTAR TODOS
	@SuppressWarnings("unchecked")
	public List<UsuarioDomain> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<UsuarioDomain> usuarios = null;

		try {
			Query consulta = sessao.getNamedQuery("UsuarioDomain.listar");
			usuarios = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return usuarios;
	}

	
}
