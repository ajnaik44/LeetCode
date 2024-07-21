package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumSwap {
	public static void main(String[] args) {
		MaximumSwap maximumSwap = new MaximumSwap();
		System.out.println(maximumSwap.findMax(2736));
		int[][] matrix = {
			    {1, 2, 3},
			    {4, 5, 6},
			    {7, 8, 9}
			};
		maximumSwap.findDiagonalOrder(matrix);
	}
	public int maximumSwap(int num) {
        char[] A = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < A.length; i++) {
            last[A[i] - '0'] = i;
        }

        for (int i = 0; i < A.length; i++) {
            for (int d = 9; d > A[i] - '0'; d--) {
                if (last[d] > i) {
                    char tmp = A[i];
                    A[i] = A[last[d]];
                    A[last[d]] = tmp;
                    return Integer.valueOf(new String(A));
                }
            }
        }
        return num;
    }
public int[] findDiagonalOrder(int[][] mat) {
        
        List<Integer> answer =  new ArrayList<>(mat.length *  mat[0].length);
        boolean flag = true;
        int col=0;
        int row=0;
        
        for(;row<mat.length;)
        {
            List<Integer> list =  new ArrayList<>();
           
            for(;col<mat[0].length;)
            {
            	
                int r=row,c=col;
                col++;
                while(c>=0 &&  c< mat[0].length &&  r>=0 &&  r< mat.length)
                {
                    list.add(mat[r][c]);
                    r++;c--;
                }
                if(col>mat[0].length-1) {
                	row++;
                	col = mat[0].length-1;
                }
                break;
                
               
            }
            if(list.size()>1 &&  flag)
            {
                Collections.reverse(list);
            }
            answer.addAll(list);
            flag = !flag;
        }
   int[] result = answer.stream().mapToInt(Integer::intValue).toArray();
   return result;
    }

    public int findMax(int num)
    {
        StringBuilder s =  new StringBuilder(num+"");
       
        int [][] array=  new int[s.length()][2];
        for(int i=0;i<s.length();i++)
        {
        	array[i][0] =  Integer.parseInt(s.charAt(i)+"");
        	array[i][1]=i;
        	
        }
        Arrays.sort(array,(a,b) -> (b[0]-a[0]));
        
        for(int i=0;i<s.length();i++)
        {
        	int number = array[i][0];
        	if(number== Integer.parseInt(s.charAt(i)+"")) continue;
        	
        	int j=i+1;
        	while(Integer.parseInt(s.charAt(j)+"")!=number)
        	{
        		j++;
        	}
        	
        	int temp = Integer.parseInt( s.charAt(i)+"");
        	s.deleteCharAt(i);
        	s.insert(i, number);
        	s.deleteCharAt(j);
        	s.insert(j, temp);
        	return Integer.parseInt(s.toString());
        	
        	
        }
       return 0;



    }
}
