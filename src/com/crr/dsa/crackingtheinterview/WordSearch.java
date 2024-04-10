package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Objects;
public class WordSearch {
public static void main(String[] args) {
	char[][] board1 = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word1 = "ABCCGD";
        System.out.println(new WordSearch().existOptimize(board1, word1)); // Output: true
}

	
	    class Index{
		        int row;
		        int col;
		        Index(int row,int col)
		        {
		            this.row =  row;
		            this.col = col;
		        }
		        @Override
		        public boolean equals(Object obj) {
		            if (this == obj)
		                return true;
		            if (obj == null || getClass() != obj.getClass())
		                return false;
		            Index other = (Index) obj;
		            return row == other.row && col == other.col;
		        }
		        
		        @Override
		        public int hashCode() {
		            return Objects.hash(row, col);
		        }
		    }
		    public boolean exist(char[][] board, String word) {

		        Map<Character,ArrayList<Index>> boardMap = new HashMap<Character,ArrayList<Index>>();
		        for(int row=0;row<board.length;row++)
		        {
		            for(int col=0; col<board[0].length;col++)
		            {
		                Index index =  new Index(row,col);
		                if(boardMap.containsKey(board[row][col]))
		                {
		                    boardMap.get(board[row][col]).add(index);
		                }else{
		                    ArrayList<Index> list = new ArrayList<Index>();
		                    list.add(index);
		                    boardMap.put(board[row][col],list);
		                }
		            }
		        }
		         Set<Index> visitedindex = new HashSet<Index>();
		        for(Index index:  boardMap.get( word.charAt(0)))
		            {
		        		
		        		visitedindex.add(index);
		                for( int chIndex = 1 ;  chIndex<word.length();chIndex++){
		                
		                	index = checkNextCharacter(index ,  board,  visitedindex,word.charAt(chIndex),
	                         index.row, index.col);
			                System.out.println(word.charAt(chIndex) + " for " +index );
			                if(index==null)
			                	break;
			                }
		                if(visitedindex.size()==word.length())
		                	return true;
		                visitedindex.clear();
		            }
		       
		    return false;

		    }
		    public Index checkNextCharacter(Index index , char[][] board, Set<Index> visitedindex,char ch,int row,int col)
		    {
		        int [][] neighbores = { {0,1 },{0,-1},{1,0},{-1,0}  };
		        for(int [] neigbors : neighbores )
		        {
		            int newRow = row+ neigbors[0];
		            int newCol =  col + neigbors[1];
		            Index newIndex =  new Index(newRow,newCol);
		            if(newRow>=0 && newRow<board.length &&  newCol>=0 &&  newCol < board[0].length 
	                && !visitedindex.contains(newIndex) )
		            {
	                    System.out.println(board[newRow][newCol]);
	                    
		                if(board[newRow][newCol] ==  ch){
		                  visitedindex.add(newIndex);
	                        return newIndex;
	                    }
	                   
		            }
		        }
		        return null;
		    }
		    
		    


  private char[][] board;
  private int ROWS;
  private int COLS;

  public boolean existOptimize(char[][] board, String word) {
    this.board = board;
    this.ROWS = board.length;
    this.COLS = board[0].length;

    for (int row = 0; row < this.ROWS; ++row)
      for (int col = 0; col < this.COLS; ++col)
        if (this.backtrack(row, col, word, 0))
          return true;
    return false;
  }

  protected boolean backtrack(int row, int col, String word, int index) {
    /* Step 1). check the bottom case. */
    if (index >= word.length())
      return true;

    /* Step 2). Check the boundaries. */
    if (row < 0 || row == this.ROWS || col < 0 || col == this.COLS
        || this.board[row][col] != word.charAt(index))
      return false;

    /* Step 3). explore the neighbors in DFS */
    boolean ret = false;
    // mark the path before the next exploration
    this.board[row][col] = '#';

    int[] rowOffsets = {0, 1, 0, -1};
    int[] colOffsets = {1, 0, -1, 0};
    for (int d = 0; d < 4; ++d) {
      ret = this.backtrack(row + rowOffsets[d], col + colOffsets[d], word, index + 1);
      if (ret)
        break;
    }

    /* Step 4). clean up and return the result. */
    this.board[row][col] = word.charAt(index);
    return ret;
  }


	
	
}
