package mum.waa.jsf.controller;

import java.io.Serializable;

//import javax.enterprise.context.SessionScoped;
//import javax.inject.Named;
//
//@Named
//@SessionScoped
public class Name implements Serializable {
   private String first;
   private String last;
   private boolean editable;
   
   public Name(){
	   
   }

   public Name(String first, String last) {
      this.first = first;
      this.last = last;
   }

   public void setFirst(String newValue) { first = newValue; }
   public String getFirst() { return first; }

   public void setLast(String newValue) { last = newValue; }     
   public String getLast() { return last; }
   
   public boolean isEditable() { return editable; }
   public void setEditable(boolean newValue) { editable = newValue; }
}