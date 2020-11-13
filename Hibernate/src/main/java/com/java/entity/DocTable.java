package com.java.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "m_document")
public class DocTable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "doc_id")
	private int doc_id;

	
	@Column(name="docname",length=200)
	private String docname;
	@Column(name="status")
	private boolean status;
	  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	  @JoinTable(name = "source_docmapping", joinColumns = @JoinColumn(name =
	  "doc_id"), inverseJoinColumns = @JoinColumn(name = "source_id"))
	  List<SourceTable> source;
	 
	/*
	 * @ManyToMany(fetch = FetchType.LAZY, mappedBy = "pk.ConsentTable",
	 * cascade=CascadeType.ALL) List<StateTable> liststate;
	 */
	

	
	public int getDoc_id() {
		return doc_id;
	}

	public String getDocname() {
		return docname;
	}

	public void setDocname(String docname) {
		this.docname = docname;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setDoc_id(int doc_id) {
		this.doc_id = doc_id;
	}

	public List<SourceTable> getSource() {
		return source;
	}

	public void setSource(List<SourceTable> source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "DocTable [doc_id=" + doc_id + ", docname=" + docname + ", status=" + status + ", source=" + source
				+ "]";
	}

	

	
	 


//	@OneToMany(mappedBy = "consent", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<StateConsent> stateconsent = new ArrayList<>();
//
//	public List<StateConsent> getStateconsent() {
//		return stateconsent;
//	}
//
//	public void setStateconsent(List<StateConsent> stateconsent) {
//		this.stateconsent = stateconsent;
//	}

}