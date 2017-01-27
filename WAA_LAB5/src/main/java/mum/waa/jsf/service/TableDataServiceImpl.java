package mum.waa.jsf.service;

import java.io.Serializable;
import java.util.ArrayList;

import javax.inject.Inject;

import mum.waa.jsf.controller.Name;
import mum.waa.jsf.repository.TableDataRepository;

public class TableDataServiceImpl implements TableDataService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private TableDataRepository tableDataRepository;

	public ArrayList<Name> getNames() {
		return tableDataRepository.getNames();
	}
	
	public void save(){
		tableDataRepository.save();	
	}

	public void deleteRow(Name nameToDelete) {
		tableDataRepository.deleteRow(nameToDelete);
		
	}

	public void addName(Name name) {

		tableDataRepository.addName(name);
		
		
	}
	
	

}
