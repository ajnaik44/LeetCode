package com.crr.dsa.crackingtheinterview;

public class NumArray {
    int [] tree;
    int n;
    public NumArray(int[] nums) {
        if(nums.length>0)
        {
            n =  nums.length;
            tree = new int[n*2];
            buildTree(nums);
        }
    }
    
    private void buildTree(int [] nums)
    {
        for( int i=n,j=0 ; i < 2 * n ; i++,j++ )
        {
            tree [i] =  nums[j];
        }
        for(int i =  n-1 ; i > 0 ; i-- )
        {
            tree [i] =  tree[ i * 2 ] + tree[ i * 2 + 1 ];
        }
    }
    public void update(int pos, int val) {
      pos+=n;
      tree[pos] = val;
      
      while(pos>0)
      {
    	  int left = pos;
    	  int right = pos;
    	  if(pos%2==0)
    	  {
    		  right =  pos+1;
    	  }
    	  else {
    		  left =  pos-1;
    	  }
    	  tree [ pos/2 ] =  tree[left] +  tree[right];
    	  pos/=2;
      }

    }
    
    public int sumRange(int left, int right) {
     left+=n;
     right+=n;
     int sum=0;
     while(left<= right)
     {
    	 if(left %2==1)
    	 {
    		 sum+=tree[left];
    		 left++;
    	 }
    	 if(right  % 2 == 0 )
    	 {
    		 sum +=  tree[right];
    		 right--;
    	 }
    	 left/=2;
    	 right/=2;
     }
    	return sum;
    }
    
    
    public static void main(String[] args) {
    	int nums[] = {1,3,5};
		NumArray array = new NumArray(nums);
		array.update(1, 2);
		array.sumRange(0, 2);
	}
    
}