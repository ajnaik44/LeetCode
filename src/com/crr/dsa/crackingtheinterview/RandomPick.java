package com.crr.dsa.crackingtheinterview;

public class RandomPick {
	private int[]  prefixSums;
    int totalSum; 
    public RandomPick(int[] w) {
        this.prefixSums = new int[w.length];

        int preSum=0;
        for(int i=0;i< w.length;i++)
        {
            preSum+=w[i];
            this.prefixSums[i]=preSum;
        }
        this.totalSum=  preSum;
    }
    
    public int pickIndex() {
    	System.out.println(this.totalSum*Math.random());
        double target =  this.totalSum*Math.random();
        int i=0;
        for(;i<this.prefixSums.length;i++)
        {
            if(target<this.prefixSums[i])
                return i;
        }
        return i-1;
    }
    public static void main(String[] args) {
		int []arr = {1,9,15,21};
		RandomPick randomPick = new RandomPick(arr);
		System.out.println(randomPick.pickIndex());
		System.out.println(randomPick.pickIndex());
		System.out.println(randomPick.pickIndex());
		System.out.println(randomPick.pickIndex());
		System.out.println(randomPick.pickIndex());
		System.out.println(randomPick.pickIndex());
		System.out.println(randomPick.pickIndex());
		System.out.println(randomPick.pickIndex());
		System.out.println(randomPick.pickIndex());
	}
}
