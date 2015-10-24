package br.com.guardaxml.bean;

import java.util.Date;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.CheckboxTreeNode;
import org.primefaces.model.TreeNode;

import br.com.guardaxml.domain.XMLDomain;

@ManagedBean(name = "xmlService")
@ApplicationScoped
public class XMLService {

	public TreeNode createCheckboxDocuments() {
		TreeNode root = new CheckboxTreeNode(new XMLDomain("Files", new Date(),
				"1"), null);

		TreeNode documents = new CheckboxTreeNode(new XMLDomain("Documents",
				new Date(), "2"), root);

		TreeNode work = new CheckboxTreeNode(new XMLDomain("Work", new Date(),
				"5"), documents);
		TreeNode primefaces = new CheckboxTreeNode(new XMLDomain("PrimeFaces",
				new Date(), "6"), documents);

		// Documents
		@SuppressWarnings("unused")
		TreeNode expenses = new CheckboxTreeNode("document", new XMLDomain(
				"Expenses.doc", new Date(), "7"), work);
		@SuppressWarnings("unused")
		TreeNode resume = new CheckboxTreeNode("document", new XMLDomain(
				"Resume.doc", new Date(), "8"), work);
		@SuppressWarnings("unused")
		TreeNode refdoc = new CheckboxTreeNode("document", new XMLDomain(
				"RefDoc.pages", new Date(), "9"), primefaces);

		return root;
	}

}
