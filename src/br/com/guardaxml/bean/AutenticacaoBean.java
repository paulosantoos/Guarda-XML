package br.com.guardaxml.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.codec.digest.DigestUtils;

import br.com.guardaxml.dao.UsuarioDAO;
import br.com.guardaxml.domain.UsuarioDomain;
import br.com.guardaxml.util.JSFUtil;

@ManagedBean(name = "MBAutenticar")
// INDICA QUE ESSA CLASSE � UM BEAN E DA UM NOME PRA ELE
@SessionScoped
// CRIA UM ESCOPO DE SESS�O PARA ESSA CLASSE, OU SEJA, O OBJETO DESSA CLASSE
// FICA NA MEMORIA ENQUANTO A APLICA��O EST� EM EXECU��O
public class AutenticacaoBean {

	// CRIA UM VARIAVEL DO UsuarioDomain
	private UsuarioDomain usuarioDomainLogado;

	// SE O OBJETO � NULO, ELE D� UM NEW
	public UsuarioDomain getusuarioDomainLogado() {
		if (usuarioDomainLogado == null) {
			usuarioDomainLogado = new UsuarioDomain();
		}
		return usuarioDomainLogado;
	}

	public void setusuarioDomainLogado(UsuarioDomain usuarioDomainLogado) {
		this.usuarioDomainLogado = usuarioDomainLogado;
	}

	// M�TODO PARA AUTENTICA��O QUE � CHAMADO NA TELA
	public String autenticar() {

		// VARIVEL PARA URL
		String entrar = null;

		try {
			UsuarioDAO UsuarioDAO = new UsuarioDAO();

			// CHAMA O METODO DE AUTENTICAR DO DAO E O DigestUtils � PARA GERAR
			// O MD5 DA SENHA
			usuarioDomainLogado = UsuarioDAO.autenticar(
					usuarioDomainLogado.getUsu_email(),
					DigestUtils.md5Hex(usuarioDomainLogado.getUsu_senha()));

			// SE O OBJETO FOR NULO, SIGNIFICA QUE N�O AUTENTICOU
			if (usuarioDomainLogado == null) {
				JSFUtil.adicionarMensagemErro("Nome de usu�rio e/ou senha inv�lidos");
			} else {
				// SE DER CERTO, REDIRECIONA PARA A PAGINA PRINCIPAL
				entrar = "/pages/principal.xhtml?faces-redirect=true";
			}
		} catch (RuntimeException ex) {
			JSFUtil.adicionarMensagemErro("Erro ao tentar autenticar no sistema: "
					+ ex.getMessage());
		}
		return entrar;
	}

	// METODO PARA SAIR DA APLICA��O
	public String sair() {
		// RETORNA PARA A PAGINA DE LOGIN
		usuarioDomainLogado = null;
		return "/pages/autenticacao.xhtml?faces-redirect=true";
	}

	
	public String novoCadastro(){
		return "/pages/usuarioCadastro.xhtml?faces-redirect=true";
	}
}
