package com.java.dao;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java.entity.SourceTable;
import com.java.entity.DocTable;
import com.java.entity.StateTable;
import com.java.model.RequestDocdata;


@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			


	@SuppressWarnings("unused")
	@Override
	public String insertdata(RequestDocdata request) {
		
		
		SourceTable source=null;
		DocTable doc=null;
		StateTable statenew=null;
		Session currentSession = sessionFactory.getCurrentSession();
		
		Criteria cr =null;
		
		List<SourceTable> sourcetable=new ArrayList<>();
		List<StateTable> statetable1=new ArrayList<StateTable>();
		try
		{
			
		 source=new SourceTable();
		 doc=new DocTable();
	     statenew=new StateTable();
		Session currentSession1 = sessionFactory.getCurrentSession();
		
		StateTable state =currentSession1.get(StateTable.class, request.getStatecode());
		
		
		 //source=currentSession2.get(SourceTable.class, request.getDatasource());
		  cr = currentSession.createCriteria(DocTable.class);
			cr.add(Restrictions.eq("docname", request.getDocumentname()));
			List<DocTable> docdata = cr.list();
			cr = currentSession.createCriteria(SourceTable.class);
			cr.add(Restrictions.eq("sourceofdata", request.getDatasource()));
			List<SourceTable> sourcedata = cr.list();
		
			
		
		if(docdata.isEmpty())
		{
			doc.setDocname(request.getDocumentname());
			currentSession.save(doc);
		}
		
		if(sourcedata.isEmpty())
		{
			source.setSourceofdata(request.getDatasource());
			cr = currentSession.createCriteria(DocTable.class);
			cr.add(Restrictions.eq("docname", request.getDocumentname()));
			List<DocTable> docdata1 = cr.list();
			source.setListdoc(docdata1);
			currentSession.save(
);
			
		}
		else
		{
			Boolean nodoc=false;
			for(int i=0;i<sourcedata.get(0).getListdoc().size();i++)
			{
				if(request.getDocumentname().equals(sourcedata.get(0).getListdoc().get(i).getDocname()))
				{
					nodoc=true;
				}
			}
			if(!nodoc) {
				cr = currentSession.createCriteria(DocTable.class);
				cr.add(Restrictions.eq("docname", request.getDocumentname()));
				List<DocTable> docdata1 = cr.list();
				if(sourcedata.get(0).getListdoc()==null) {
					sourcedata.get(0).setListdoc(new ArrayList<>());
					sourcedata.get(0).getListdoc().addAll(docdata1);
				}else {
					sourcedata.get(0).getListdoc().addAll(docdata1);
				}
				currentSession.save(sourcedata);
			}
		}
		if(state==null)
		{
			statenew.setState_code(request.getStatecode());
			cr = currentSession.createCriteria(SourceTable.class);
			cr.add(Restrictions.eq("sourceofdata", request.getDatasource()));
			List<SourceTable> sourcedata1 = cr.list();
			statenew.setListsource(sourcedata1);
			currentSession.save(statenew);
		}
		else
		{
			boolean nosource=false;
			//System.out.println("state.getListsource().get(0).getSourceofdata()"+state.getListsource().get(0).getSourceofdata());
			for(int i=0;i<state.getListsource().size();i++) {
				
				if(request.getDatasource().equals(state.getListsource().get(i).getSourceofdata()))
				{
					nosource=true;
				}	
			}	
			
			if(!nosource)
			{
			cr = currentSession.createCriteria(SourceTable.class);
			cr.add(Restrictions.eq("sourceofdata", request.getDatasource()));
			List<SourceTable> sourcedata1 = cr.list();
		
			if(state.getListsource()==null)
			{
				state.setListsource(new ArrayList<>());
				state.getListsource().addAll(sourcedata1);
			}
			else
			{
				state.getListsource().addAll(sourcedata1);
			}
			currentSession.save(state);
			}
			}
			
		
		//System.out.println("statedata : {} "+ ); 
		
		
			
		}
		catch(Exception e)
		{
			System.out.println("already exist"+ e.getMessage());
			return null;
		}
		return null;
	}



	
}


