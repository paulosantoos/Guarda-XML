package br.com.guardaxml.bean;

import java.io.InputStream;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.TreeNode;

@ManagedBean(name = "downloadNFEBean")
@ViewScoped
public class DownloadNFEBean {
	private TreeNode root;
	private StreamedContent file;
	private TreeNode[] selectedNodes;

	@ManagedProperty("#{xmlService}")
	private XMLService service;

	@PostConstruct
	public void init() {
		root = service.createCheckboxDocuments();
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public StreamedContent getFile() {
		return file;
	}

	public void setFile(StreamedContent file) {
		this.file = file;
	}

	public TreeNode[] getSelectedNodes() {
		return selectedNodes;
	}

	public void setSelectedNodes(TreeNode[] selectedNodes) {
		this.selectedNodes = selectedNodes;
	}

	public XMLService getService() {
		return service;
	}

	public void setService(XMLService service) {
		this.service = service;
	}

	public DownloadNFEBean() {
		InputStream stream = ((ServletContext) FacesContext
				.getCurrentInstance().getExternalContext().getContext())
				.getResourceAsStream("/resources/files/nfe/fundo.png");
		file = new DefaultStreamedContent(stream, "image/png",
				"downloaded_optimus.png");
	}

}