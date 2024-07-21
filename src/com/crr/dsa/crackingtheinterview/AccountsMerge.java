package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class AccountsMerge {
	
	
	class DSU {
	    int representative [];
	    int size [];
	    
	    DSU(int sz) {
	        representative = new int[sz];
	        size = new int[sz];
	        
	        for (int i = 0; i < sz; ++i) {
	            // Initially each group is its own representative
	            representative[i] = i;
	            // Intialize the size of all groups to 1
	            size[i] = 1;
	        }
	    }
	    
	    // Finds the representative of group x
	    public int findRepresentative(int x) {
	        if (x == representative[x]) {
	            return x;
	        }
	        
	        // This is path compression
	        return representative[x] = findRepresentative(representative[x]);
	    }
	    
	    // Unite the group that contains "a" with the group that contains "b"
	    public void unionBySize(int a, int b) {
	        int representativeA = findRepresentative(a);
	        int representativeB = findRepresentative(b);
	        
	        // If nodes a and b already belong to the same group, do nothing.
	        if (representativeA == representativeB) {
	            return;
	        }
	        
	        // Union by size: point the representative of the smaller
	        // group to the representative of the larger group.
	        if (size[representativeA] >= size[representativeB]) {
	            size[representativeA] += size[representativeB];
	            representative[representativeB] = representativeA;
	        } else {
	            size[representativeB] += size[representativeA];
	            representative[representativeA] = representativeB;
	        }
	    }
	}

	    public List<List<String>> accountsMergeDSU(List<List<String>> accountList) {
	        int accountListSize = accountList.size();
	        DSU dsu = new DSU(accountListSize);
	        
	        // Maps email to their component index
	        Map<String, Integer> emailGroup = new HashMap<>();
	        
	        for (int i = 0; i < accountListSize; i++) {
	            int accountSize = accountList.get(i).size();
	            
	            for (int j = 1; j < accountSize; j++) {
	                String email = accountList.get(i).get(j);
	                String accountName = accountList.get(i).get(0);
	                
	                // If this is the first time seeing this email then
	                // assign component group as the account index
	                if (!emailGroup.containsKey(email)) {
	                    emailGroup.put(email, i);
	                } else {
	                    // If we have seen this email before then union this
	                    // group with the previous group of the email
	                    dsu.unionBySize(i, emailGroup.get(email));
	                }
	            }
	        }
	        
	        // Store emails corresponding to the component's representative
	        Map<Integer, List<String>> components = new HashMap<Integer, List<String>>();
	        for (String email : emailGroup.keySet()) {
	            int group = emailGroup.get(email);
	            int groupRep = dsu.findRepresentative(group);
	            
	            if (!components.containsKey(groupRep)) {
	                components.put(groupRep, new ArrayList<String>());
	            }
	            
	            components.get(groupRep).add(email);
	        }
	        
	        // Sort the components and add the account name
	        List<List<String>> mergedAccounts = new ArrayList<>();
	        for (int group : components.keySet()) {
	            List<String> component = components.get(group);
	            Collections.sort(component); 
	            component.add(0, accountList.get(group).get(0));
	            mergedAccounts.add(component);
	        }
	        
	        return mergedAccounts;
	    }
	
	    HashSet<String> visited = new HashSet<>();
	    Map<String, List<String>> graph = new HashMap<String, List<String>>();
	    
	    public void DFS(ArrayList<String> list,String email)
	    {
	    	if(visited.contains(email))
	    		return;
	    	visited.add(email);
	    	list.add(email);
	    	if(!graph.containsKey(email))
	    		return;
	    	
	    	for(String tempEmail :  graph.get(email))
	    	{
	    		DFS(list, tempEmail);
	    	}
	    	
	    }
	    public List<List<String>> accountsMergeUsingGraph(List<List<String>> accountList) {
	    	List<List<String>> mergedAccounts = new ArrayList();
	    	
	    	for(List<String> list :  accountList)
	    	{
	    		int size =  list.size();
	    		String emailFirst =  list.get(1);
	    		for(int i=2;i<size;i++)
	    		{
	    			if(!graph.containsKey(emailFirst))
	    				graph.put(emailFirst, new ArrayList<String>());
	    			
	    			graph.get(emailFirst).add(list.get(i));
	    			
	    			if(!graph.containsKey(list.get(i)))
	    				graph.put(list.get(i), new ArrayList<String>());
	    			graph.get(list.get(i)).add(emailFirst);
	    			
	    		}
	    		
	    	}
	    	for(List<String> list :  accountList)
	    	{
	    		String name  = list.get(0);
	    		ArrayList<String> combineList = new ArrayList<String>();
	    	
	    		if(!visited.contains(list.get(1)))
	    		{
	    			
	    			combineList.add(name);
	    			DFS(combineList,list.get(1));
	    			
	    			Collections.sort(combineList.subList(1, combineList.size()));
		    		mergedAccounts.add(combineList);
	    		}
	    		
	    		
	    	
	    	}
	        
	        return mergedAccounts;
	    }
	    public static void main(String[] args) {
	        // Creating some sample account lists
	        List<List<String>> accountList = new ArrayList<>();
	        List<String> account1 = new ArrayList<>();
	        account1.add("John");
	        account1.add("john@example.com");
	        account1.add("john1@example.com");
	        account1.add("john2@example.com");

	        List<String> account2 = new ArrayList<>();
	        account2.add("Jane");
	        account2.add("jane@example.com");
	        account2.add("jane1@example.com");

	        List<String> account3 = new ArrayList<>();
	        account3.add("Doe");
	        account3.add("doe@example.com");
	        account3.add("doe1@example.com");
	        account3.add("john@example.com"); // This email is already in account1

	        accountList.add(account1);
	        accountList.add(account2);
	        accountList.add(account3);

	        // Creating an instance of AccountsMerge
	        AccountsMerge merger = new AccountsMerge();

	        // Merging the accounts
	        List<List<String>> mergedAccounts = merger.accountsMergeUsingGraph(accountList);

	        // Displaying the merged accounts
	        for (List<String> mergedAccount : mergedAccounts) {
	            System.out.println("Merged Account:");
	            for (String item : mergedAccount) {
	                System.out.println(item);
	            }
	            System.out.println();
	        }
	    }
	
}
