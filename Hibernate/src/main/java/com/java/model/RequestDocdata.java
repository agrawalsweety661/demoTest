package com.java.model;



public class RequestDocdata {
	private int statecode;
	private String datasource;
	private String documentname;
	private boolean isactive;
	private String createdby;
	public int getStatecode() {
		return statecode;
	}
	public void setStatecode(int statecode) {
		this.statecode = statecode;
	}
	public String getDatasource() {
		return datasource;
	}
	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}
	public String getDocumentname() {
		return documentname;
	}
	public void setDocumentname(String documentname) {
		this.documentname = documentname;
	}
	public boolean isIsactive() {
		return isactive;
	}
	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	

}
