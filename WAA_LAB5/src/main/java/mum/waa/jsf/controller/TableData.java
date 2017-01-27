package mum.waa.jsf.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import javax.inject.Inject;
import javax.inject.Named;

import mum.waa.jsf.service.TableDataService;

// or import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped;
// or import javax.faces.bean.SessionScoped;

@Named // or @ManagedBean
@SessionScoped
public class TableData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	TableDataService tableDataService;
	
	Name name = new Name();

	public Name getName() {
		return this.name;
	}

	public ArrayList<Name> getNames() {
		return tableDataService.getNames();
	}

	public String save() {
		tableDataService.save();
		return null;
	}

	public String deleteRow(Name nameToDelete) {
		tableDataService.deleteRow(nameToDelete);
		return null;
	}

	public String addName() {

		tableDataService.addName(this.name);

		name = new Name();

		return "index";
	}
}