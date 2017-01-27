package mum.waa.jsf.repository;

import java.util.ArrayList;

import mum.waa.jsf.controller.Name;

public interface TableDataRepository {
	
	public ArrayList<Name> getNames();
	public void save();
	public void deleteRow(Name nameToDelete);
	public void addName(Name name);
}
