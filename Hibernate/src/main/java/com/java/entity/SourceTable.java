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
@Table(name = "m_datasource")
public class SourceTable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "source_id", nullable = false)
	private int sourceId;
	@Column(name="sourceofdata",unique = true,nullable = false,length=20)
	private String sourceofdata;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "state_sourcemapping", joinColumns = @JoinColumn(name = "source_id"), inverseJoinColumns = @JoinColumn(name = "state_code"))
	List<StateTable> liststate;

	
	public List<StateTable> getListstate() {
		return liststate;
	}

	public void setListstate(List<StateTable> liststate) {
		this.liststate = liststate;
	}

	  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	  @JoinTable(name = "source_docmapping", joinColumns = @JoinColumn(name =
	  "source_id"), inverseJoinColumns = @JoinColumn(name = "doc_id"))
	  List<DocTable> listdoc;
	public int getSourceId() {
		return sourceId;
	}

	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}

	public String getSourceofdata() {
		return sourceofdata;
	}

	public void setSourceofdata(String sourceofdata) {
		this.sourceofdata = sourceofdata;
	}

	public List<DocTable> getListdoc() {
		return listdoc;
	}

	public void setListdoc(List<DocTable> listdoc) {
		this.listdoc = listdoc;
	}

	@Override
	public String toString() {
		return "AppTable [sourceId=" + sourceId + ", sourceofdata=" + sourceofdata + ", liststate=" + liststate + "]";
	}

	

	

}
