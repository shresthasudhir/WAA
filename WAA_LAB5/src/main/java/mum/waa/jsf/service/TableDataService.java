package mum.waa.jsf.service;

import java.util.ArrayList;

import mum.waa.jsf.controller.Name;

public interface TableDataService {
	
	public ArrayList<Name> getNames();
	public void save();
	public void deleteRow(Name nameToDelete);
	public void addName(Name name);

}
