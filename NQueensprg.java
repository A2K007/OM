//we have to place n queens in n*n chess board

import java.io.*;
import java.util.*;

public class NQueensprg
{
	
	public static void solve(boolean[][] board, int row,boolean[] cols,boolean[] normaldiag,boolean[] reversediag, String answer)
	{
		
		if(row==board.length) //if all the queens are successfully placed in each row 
		{
			System.out.println(answer+"\n------------------------------\n");
			return;
		}
		
	//for each row position we will iterate through every column of board and place the queen in appropriate unoccupied position
		for(int col=0;col<board[0].length;col++)
		{
			if(cols[col]==false && normaldiag[row+col]==false && reversediag[row-col+board.length-1]==false)
			{
				board[row][col]=true; //place the queen at current row and column position on the board
				cols[col]=true; //to indicate that current col position is occupied by queen
				normaldiag[row+col]=true;
				reversediag[row-col+board.length-1]=true;
				
				//place the next queen at current row+1 position i.e. the next row
				solve(board,row+1,cols,normaldiag,reversediag,answer+"queen"+(row+1)+":"+" row="+row+" ,col="+col+"\n");				
				
//if we are unable to place the queen at current row, we will backtrack to last decision point and again recurse to find the appropriate position
//wrong:(this approach is used in backtracking and not in branch and bound)so while backtracking place the last recently placed queen on col+1 position
			//so, in case of backtracking we need to make/reinitialize the preassumed positions to false
				board[row][col]=false;
				cols[col]=false;
				normaldiag[row+col]=false;
				reversediag[row-col+board.length-1]=false;
			}
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("PLease enter the no. of queens: ");
		int n=sc.nextInt();
		
		boolean[][] board=new boolean[n][n];
		
		boolean[] cols=new boolean[n];//to keep track of occupied and unoccupied columns
		boolean[] normaldiag=new boolean[2*n-1]; //total diagonals = 2*n-1 , normal diagonals have common row+column value
		boolean[] reversediag=new boolean[2*n-1]; //total diagonals = 2*n-1 , reverse diagonals have common row-column+boardlength-1 value
		
		solve(board,0,cols,normaldiag,reversediag,"");
	//solve(borad,row position,cols array,normaldiag array,reversediag array,answersofar);
	}
}