package br.com.guardaxml.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.codec.digest.DigestUtils;

import br.com.guardaxml.dao.EmpresaDAO;
import br.com.guardaxml.dao.UsuarioDAO;
import br.com.guardaxml.domain.EmpresaDomain;
import br.com.guardaxml.domain.UsuarioDomain;
import br.com.guardaxml.util.JSFUtil;


@ManagedBean(name = "MBUsuario")
@ViewScoped
public class UsuarioBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8297030939822182549L;
	private UsuarioDomain usuario;
	private List<UsuarioDomain> listUsuario;
	private List<UsuarioDomain> listUsuarioFiltrado;
	private List<EmpresaDomain> comboEmpresas;
	@SuppressWarnings("unused")
	private String acao;
	
	
	
	
	public List<UsuarioDomain> getListUsuario() {
		return listUsuario;
	}

	public void setListUsuario(List<UsuarioDomain> listUsuario) {
		this.listUsuario = listUsuario;
	}

	public List<UsuarioDomain> getListUsuarioFiltrado() {
		return listUsuarioFiltrado;
	}

	public void setListUsuarioFiltrado(List<UsuarioDomain> listUsuarioFiltrado) {
		this.listUsuarioFiltrado = listUsuarioFiltrado;
	}

	public List<EmpresaDomain> getComboEmpresas() {
		return comboEmpresas;
	}

	public void setComboEmpresas(List<EmpresaDomain> comboEmpresas) {
		this.comboEmpresas = comboEmpresas;
	}

	public void setUsuario(UsuarioDomain usuario) {
		this.usuario = usuario;
	}

	public String getAcao() {
		return acao = "Novo";
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public UsuarioDomain getUsuario(){
		if(usuario == null){
			usuario = new UsuarioDomain();
		}
		return usuario;
	}

	public void novo(){
		usuario = new UsuarioDomain();
	}
	
	public void saveOrUpdate() {
		try {
			//QUANDO MANDA SALVAR ELE PEGA A SENHA DIGITADA E GERA UM MD5 DELA
			UsuarioDAO dao = new UsuarioDAO();
			usuario.setUsu_senha(DigestUtils.md5Hex((usuario.getUsu_senha())));
			usuario.setUsu_dtcadastro(new Date());
			dao.saveOrUpdate(usuario);

			usuario = new UsuarioDomain();

			listUsuario = dao.listar();

			JSFUtil.adicionarMensagemSucesso("Usuário salvo com sucesso!");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}

	public void limparCampos(String frmPnl) {
		usuario = new UsuarioDomain();
		JSFUtil.limparCampos("frmPnl");
	}

	public void carregarEmpresa(){
		try {
			EmpresaDAO dao = new EmpresaDAO();
			comboEmpresas = dao.listar();
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
	

}
