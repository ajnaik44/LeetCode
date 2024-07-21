package com.crr.dsa.crackingtheinterview;

public class UnionFindByRank {

	private int[]root;

	private int[]rank;
	public UnionFindByRank(int n)
	{
		root = new int[n];
		rank =  new int[n];
		
		for(int i=0;i<n;i++)
		{
			root[i]=i;
			rank[i]=1;
		}
	}
	
	public int find(int x)
	{
		if(x==root[x])
		{
			return x;
		}
		return root[x] =  find(root[x]);
	}
	public void union(int x,int y)
	{
		int xroot = find(x);
		int yroot =  find(y);
		if(xroot!=yroot)
		{
			if(rank[xroot] >  rank[yroot])
			{
				root[yroot] =  xroot;
			}
			else if(rank[yroot] >  rank[xroot])
			{
				root[xroot] =  yroot;
			}
			else {
				root[yroot] = xroot;
				rank[xroot]+=rank[xroot];
			}
		}
	}
	public boolean isConnected(int x,int y)
	{
		return find(x)==find(y);
	}
	public static void main(String[] args) throws Exception {
        UnionFindByRank uf = new UnionFindByRank(10);
        // 1-2-5-6-7 3-8-9 4
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.isConnected(1, 5)); // true
        System.out.println(uf.isConnected(5, 7)); // true
        System.out.println(uf.isConnected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.isConnected(4, 9)); // true
    }
}
