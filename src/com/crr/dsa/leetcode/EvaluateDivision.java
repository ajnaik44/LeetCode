package com.crr.dsa.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {

	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		
	        HashMap<String, HashMap<String, Double>> graph =  new HashMap<>();
	       
	        //build the graph
	        for(int i=0;i<equations.size();i++)
	        {
	        	List<String> equation  =  equations.get(i);
	        	String dividend =  equation.get(0) , divisor =  equation.get(1);
	        	double quotient =  values[i];
	        	if(!graph.containsKey(dividend))
	        	{
	        		graph.put(dividend, new HashMap<String,Double>());
	        	}
	        	if(!graph.containsKey(divisor))
	        	{
	        		graph.put(divisor, new HashMap<String,Double>());
	        	}
	        	graph.get(dividend).put(divisor, quotient);
	        	graph.get(divisor).put(dividend, 1/quotient);
	        	
	        }
	        
	        double results[] =  new double[queries.size()];
	        
	        for(int i=0;i<queries.size();i++)
	        {
	        	List<String> query =  queries.get(i);
	        	
	        	String dividend =  query.get(0), divisor =  query.get(1);
	        	
	        	if(!graph.containsKey(dividend) || !graph.containsKey(divisor))
	        		results[i]=-1.0;
	        	else if(dividend== divisor)
	        		results[i]=-1.0;
	        	else {
	        		HashSet<String> visited =  new HashSet<>();
	        		results[i]=  backtrackEvaluate(graph, dividend, divisor, 1, visited);
	        	}
	        	
	        }
	        return results;
	    }

	private double backtrackEvaluate(HashMap<String, HashMap<String, Double>> graph, String currNode, String targetNode,
			double accProduct, Set<String> visited) {
		visited.add(currNode);
		double ret = -1.0;
		Map<String, Double> neighbors = graph.get(currNode);
		if(neighbors.containsKey(targetNode))
		{
			ret =  accProduct *  neighbors.get(targetNode);
		}else {
			for (Map.Entry<String, Double> pair : neighbors.entrySet()) {
                String nextNode = pair.getKey();
                if (visited.contains(nextNode))
                    continue;
                ret = backtrackEvaluate(graph, nextNode, targetNode,
                        accProduct * pair.getValue(), visited);
                if (ret != -1.0)
                    break;
            }
		}
		  visited.remove(currNode);
	        return ret;
		

	}

	public static void main(String[] args) {
        // Sample usage
		EvaluateDivision calculator = new EvaluateDivision();
        
        List<List<String>> equations = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "c")
               
        );
        
        double[] values = {2.0, 3.0};
        
        List<List<String>> queries = Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("b", "a"),
                Arrays.asList("a", "e"),
                Arrays.asList("a", "a"),
                Arrays.asList("x", "x")
        );
        
        double[] results = calculator.calcEquation(equations, values, queries);
        
        // Display results
        for (double result : results) {
            System.out.println(result);
        }
    }

}
