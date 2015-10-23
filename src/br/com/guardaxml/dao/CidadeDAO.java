package br.com.guardaxml.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.guardaxml.domain.CidadeDomain;
import br.com.guardaxml.util.HibernateUtil;



public class CidadeDAO {

	//METODO PARA SALVAR
		public void salvar(CidadeDomain cidade) {
			
			//ABRE A SESS�O DO HIBERNATE
			Session sessao = HibernateUtil.getSessionFactory().openSession();
			Transaction transacao = null;

			try {
				//INICIA A TRANSA��O
				transacao = sessao.beginTransaction();
				//SALVA O OBJETO QUE SER� PASSADO PELO BEAN
				sessao.saveOrUpdate(cidade);
				//CONFIRMA A TRANSA��O
				transacao.commit();
			} catch (RuntimeException ex) {
				
				//SE DER FALHA, A TRANSA��O � DESFEITA
				if (transacao != null) {
					transacao.rollback();
				}
				throw ex;
			} finally {
				//QUANDO TUDO TERMINAR ELE FECHA A SESSAO
				sessao.close();
			}
		}

		@SuppressWarnings("unchecked")
		//METODO LISTAR
		public List<CidadeDomain> listar() {
			Session sessao = HibernateUtil.getSessionFactory().openSession();
			List<CidadeDomain> cidades = null;

			try {
				//AQUI O HIBERNATE PEGA A NAMEDQUERY QUE EST� DECLARADO NO DOMAIN DO OBEJTO
				Query consulta = sessao.getNamedQuery("Cidade.listar");
				//MANDA LISTAR
				cidades = consulta.list();
			} catch (RuntimeException ex) {
				throw ex;
			} finally {
				sessao.close();
			}
			//RETORNA A LISTA
			return cidades;
		}

		//METODO PARA BUSCAR O CODIGO
		public CidadeDomain buscarPorCodigo(Integer codigo) {
			Session sessao = HibernateUtil.getSessionFactory().openSession();
			CidadeDomain cidade = null;

			try {
				Query consulta = sessao.getNamedQuery("Cidade.buscarPorCodigo");
				//AQUI � PASSADO O PARAMETRO PARA A NAMEDQUERY
				consulta.setInteger("codigo", codigo);
				//AQUI BUSCA UM UNICO RESULTADO
				cidade = (CidadeDomain) consulta.uniqueResult();
			} catch (RuntimeException ex) {
				throw ex;
			} finally {
				sessao.close();
			}
			return cidade;
		}

		
		//METODO PARA EXCLUIR
		public void excluir(CidadeDomain cidade) {
			Session sessao = HibernateUtil.getSessionFactory().openSession();
			Transaction transacao = null;

			try {
				transacao = sessao.beginTransaction();
				sessao.delete(cidade);
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

	

		@SuppressWarnings("unchecked")
		public List<CidadeDomain> buscarCidadesPorCodigoEstado(Integer codigo) {
			Session sessao = HibernateUtil.getSessionFactory().openSession();
			List<CidadeDomain> cidades = null;

			try {
				Query consulta = sessao
						.getNamedQuery("Cidade.buscarCidadesPorCodigoEstado");
				consulta.setInteger("codigo", codigo);
				cidades = consulta.list();
			} catch (RuntimeException ex) {
				throw ex;
			} finally {
				sessao.close();
			}
			return cidades;
		}
	
}
