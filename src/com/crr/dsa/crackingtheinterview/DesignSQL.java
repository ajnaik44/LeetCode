package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesignSQL {
	Map<String,Table> data = new HashMap<String,Table>();
	
	class Table{
		String name;
		int  id=0;
		Integer columns = null;
		
		 HashMap<Integer, ArrayList<String>> record =  null;
		
		
		int getNextRowId()
		{
			id++;
			return id;
		}
		public Table(String name,Integer columns) {
			// TODO Auto-generated constructor stub
			this.name =  name;
			this.columns = columns;
			record =  new HashMap<Integer,ArrayList<String>>();
		}
		
	}
	
	  public DesignSQL(List<String> names, List<Integer> columns) {
		  
		 for(int i =0; i<names.size();i++ )
		 {
			 Table table =  new Table(names.get(i),columns.get(i));
			 data.put(names.get(i), table);
		 }
	        
	    }
	    
	    public void insertRow(String name, List<String> row) {
	      Table table =   data.get(name);
	      if(table.columns==row.size())
	      {
	    	  int rowId=  table.getNextRowId();
	    	
	    	  table.record.put(rowId, (ArrayList<String>) row);
	    	  
	      }
	    }
	    
	    public void deleteRow(String name, int rowId) {
	        Table table =  data.get(name);
	        if(table.record.get(rowId)!=null) {
	        	table.record.put(rowId, null);
	        }
	    }
	    
	    public String selectCell(String name, int rowId, int columnId) {
	        Table table =  data.get(name);
	       return table.record.get(rowId).get(columnId);
	    }
}
