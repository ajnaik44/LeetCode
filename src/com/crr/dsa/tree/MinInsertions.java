package com.crr.dsa.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MinInsertions {
	public int minInsertions(String s) {
        Stack<Character> stack = new Stack<Character>();

        for(char c: s.toCharArray())
        {
            if(!stack.isEmpty() &&  stack.peek()==')' &&  c==')')
            {
                stack.pop();
                if(!stack.isEmpty() && stack.peek()=='(')
                {
                    stack.pop();
                   
                }else{
                    stack.push(c);
                    stack.push(c);
                }
            }else{
                stack.push(c);
            }
        }
        Queue<Character> queue = new   LinkedList<Character>();
        for(char c: stack)queue.add(c);
        
        int answer = 0;
        while (!queue.isEmpty() ) {
            char prev = queue.poll() ;
            if(prev=='(' && !queue.isEmpty() && queue.peek()==')')
            {
                answer++;
                queue.poll();
            }
            else if (prev=='(' && !queue.isEmpty() && queue.peek()!=')')
            {
                answer+=2;
            }
            else if (prev=='(' && queue.isEmpty())
            {
                answer+=2;
            }
            
            else  if(prev==')' && !queue.isEmpty() && queue.peek()==')')
            {
                 answer++;
                 queue.poll();
            } 
            else  if(prev==')' && !queue.isEmpty() && queue.peek()!=')')
            {
                 answer+=2;
               
            } 
             else  if(prev==')' && queue.isEmpty())
            {
                answer+=2;
              
            }  
                      
            
        }
       
    return answer;
    }
	public static void main(String[] args) {
		MinInsertions minInsertions = new MinInsertions();
		System.out.println(minInsertions.minInsertions("()())))()"));
	}
}
