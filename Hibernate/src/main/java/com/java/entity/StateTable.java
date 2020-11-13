package com.java.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "h_state")
public class StateTable {

	@Id
	@Column(name = "state_code")
	private int state_code;
	@Column(name = "state_name_english", length = 50)
	private String state_name_english;
	

	
	 /* @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	  @JoinTable(name = "state_sourcemapping", joinColumns = @JoinColumn(name =
	  "state_code"), inverseJoinColumns = @JoinColumn(name = "source_id"))
	  List<ConsentTable> liststatetable;*/
	 
	/*
	 * @ManyToMany(fetch = FetchType.LAZY, mappedBy = "pk.StateTable",
	 * cascade=CascadeType.ALL) List<ConsentTable> liststatetable;
	 */
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "state_sourcemapping", joinColumns = @JoinColumn(name = "state_code"), inverseJoinColumns = @JoinColumn(name = "source_id"))
	List<SourceTable> listsource;

	public int getState_code() {
		return state_code;
	}

	public void setState_code(int state_code) {
		this.state_code = state_code;
	}

	

	

	public String getState_name_english() {
		return state_name_english;
	}

	public void setState_name_english(String state_name_english) {
		this.state_name_english = state_name_english;
	}

	
	

	public List<SourceTable> getListsource() {
		return listsource;
	}

	public void setListsource(List<SourceTable> listsource) {
		this.listsource = listsource;
	}

	@Override
	public String toString() {
		return "StateTable [state_code=" + state_code + ", state_name_english=" + state_name_english + ", listsource="
				+ listsource + "]";
	}

	
//	@OneToMany(
//	        mappedBy = "state",
//	        cascade = CascadeType.ALL,
//	        orphanRemoval = true
//	    )
//	    private List<StateConsent> stateconsent = new ArrayList<>();
//	
//	  public List<StateConsent> getStateconsent() {
//		return stateconsent;
//	}
//	public void setStateconsent(List<StateConsent> stateconsent) {
//		this.stateconsent = stateconsent;
//	}
//	public void addConsent(ConsentTable consent) {
//		  StateConsent stateconsentobj = new StateConsent(this, consent);
//		  stateconsent.add(stateconsentobj);
//		  consent.getStateconsent().add(stateconsentobj);
//	    }
//	 
//	    public void removeConsent(ConsentTable consent) {
//	        for (Iterator<StateConsent> iterator = stateconsent.iterator();
//	             iterator.hasNext(); ) {
//	        	StateConsent stateConsentobj = iterator.next();
//	 
//	            if (stateConsentobj.getState().equals(this) &&
//	            		stateConsentobj.getConsent().equals(consent)) {
//	                iterator.remove();
//	                stateConsentobj.getConsent().getStateconsent().remove(stateConsentobj);
//	                stateConsentobj.setState(null);
//	                stateConsentobj.setConsent(null);
//	            }
//	        }
//	    }
	
}
