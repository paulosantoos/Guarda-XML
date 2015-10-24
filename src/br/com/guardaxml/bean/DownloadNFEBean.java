package br.com.guardaxml.bean;

import java.io.InputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
public class DownloadNFEBean {

	private StreamedContent file;

	public DownloadNFEBean() {
		InputStream stream = ((ServletContext) FacesContext
				.getCurrentInstance().getExternalContext().getContext())
				.getResourceAsStream("/resources/files/nfe/fundo.png");
		file = new DefaultStreamedContent(stream, "image/png",
				"downloaded_optimus.png");
	}

	public StreamedContent getFile() {
		return file;
	}
}