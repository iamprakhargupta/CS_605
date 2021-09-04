/*
 * Board.java
 *
 * Version:
 *     16.0.2
 *
 * Revisions:
 *     Nil
 */


package hw1;

/**
 * This program calculates the maximum number of kings that can be placed
 * in an chess board of NxN 
 * @author      Prakhar Gupta
 * 
 * @author      Urjita Rajendra Bedekar
 */

public class Board {
	 /**
	   * This is function to check for all possible check mates 
	   * possible by the king in a particular board position
	   * 
	   *
	   * @param   	board[][] 		Current Board
	   * 			boardold[][]	The empty board for replacing the
	   * 							check mate kings with board values
	   * 			MAX_ROWS		Length of the Board
	   * 			MAX_column		Width of the Board
	   * 			i				The row coordinate of selected king
	   *			j				Column coordinate of selected king
	   * 
	   * @return    unpadboard		Board which has all non possible 
	   * 							kings removed around a selected cell
	   * 							containing the king
	   * 
	  */
		public static char[][] checkk(char board[][],char boardold[][],
				int MAX_ROWS,int MAX_column,int i,int j)
		{
			int padr=MAX_ROWS+2; //Adding padding row wise
			int padc=MAX_column+2;//Adding padding row wise
			/* Creating a padded board with a layer of blocked cells 
			 * around the board to implement the checkmate conditions
			 */
			char padboard[][]=new char[padr][padc];// array to hold padded board
			char unpadboard[][]=new char[MAX_ROWS][MAX_column];// array to hold the unpadded board
			for (int x=0;x<padr;x++)// Creating a padding cells
			{
				for (int y=0;y<padc;y++)
				{
					if(x==0||y==padc-1||x==padr-1||y==0)
					{
						padboard[x][y]='.';
							
					}else
					{
						padboard[x][y]=board[x-1][y-1];
					}
				}
			}
			
			/*
			 * Implementing checkmate to remove kings that can be
			 * checkmate around the selected king
			 */

			for (int x=i;x<=i+2;x++)// Implementing checkmate
			{
				for (int y=j;y<=j+2;y++)
				{
					
					if((padboard[x][y]=='k')&&((x!=i+1)||(y!=j+1)))
					{
						
						padboard[x][y]=boardold[x-1][y-1];
					}
					
				}
				
				
			}
			
			for (int x=0;x<padr;x++)// Removing padding
			{
				for (int y=0;y<padc;y++)
				{
					if(x==0||y==padc-1||x==padr-1||y==0)
					{
						continue;
							
					}else
					{
						unpadboard[x-1][y-1]=padboard[x][y];
					}
				}
			}
			return unpadboard;// returns unpadded board
			
		}
		
		 /**
		   * This is function to print the board
		   * 
		   *
		   * @param     board[][]  	Chess board to print
		   *
		   * @return    void
		  */
		
		public static void printboard(char board[][])
		{
		for(int i =0;i<board.length;i++)
		{
			for(int j =0;j<board[i].length;j++)
			{
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		}
		
		 /**
		   * This is function that places kings on the board 
		   * on all unblocked cells		   * 
		   *
		   * @param     board[][]  		Input chess board 
		   * 			MAX_ROWS		Number of rows
		   * 			MAX_column		Number of columns
		   *
		   * @return    kboard			Board with king at a particular cell
		  */
		
		
		public static char[][] kingboard(char board[][],
				int MAX_ROWS,int MAX_column)
		{
			int l=MAX_ROWS;
			int k=MAX_column;
			char kboard[][]=new char[l][k];
			for(int i =0;i<board.length;i++)
			{
				for(int j =0;j<board[i].length;j++)
				{
					if(board[i][j]!='.')
					{
						kboard[i][j]='k';
						
					}else
					{
						kboard[i][j]='.';
					}
				}
				
			}
			return kboard;
		}
		
		 /**
		   * This is main function and will call other functions for solving
		   *  the problem
		   *
		   * @param     Command line Arguments
		   *
		   * 
		  */
		
		
		public static void main(String[] args)
		{
		/*
		 * 
		 * One possible Test case
		int MAX_ROWS = 3;
		int MAX_column = 3;
		char board[][]=	{ 
			{'b','b','.'}, 
			{'.','.','b'}, 
			{'b','w','b'}
	        };
		*/
			
		//Variable names are same as that of the Professor Hans Peter
		int MAX_ROWS = 6;//  Length of the board(Change them according to the size of board)
		int MAX_column = 6;// Width of the board(Change them according to the size of board)
		
		char board[][]=	{ 
			{'w','b','w','b','w','b'}, 
			{'.','w','.','w','.','w'}, 
			{'w','.','.','.','w','b'},
			{'b','.','b','.','b','w'}, 
			{'.','.','.','.','.','.'},
			{'b','w','b','w','b','w'},
	        };/* '.' represents the blocked cells 'w' and 'b' 
			  represents possible king placements*/
		
		System.out.println("-----Original Board-----");
		System.out.println();
		printboard(board);// Function call to print original board
		System.out.println();
		char a[][]=kingboard(board,MAX_ROWS,MAX_column);
		/* A Temporary board to places the kings in all possible locations 
		 * which are not blocked 
		( Check mate condition is not imposed and will be imposed later)
		*/
		
		
		char Final_Board[][]=a;
		for(int i =0;i<a.length;i++)// Iterating the board to implement checkmate
		{
			for(int j =0;j<a[i].length;j++)
			{ 
			if(Final_Board[i][j]=='k'){
				Final_Board=checkk(Final_Board,board,MAX_ROWS,MAX_column,i,j); // Function to simulate checkmate and removing kings which gets checkmate  
				}
		
		}}
		System.out.println("-----Final Board-----");
		System.out.println();
		printboard(Final_Board);// Print final board configure
		int Count_Of_Kings=0;// Counter to count the maximum number of kings on the board in a set configuration
		for(int i =0;i<Final_Board.length;i++)
		{
			for(int j=0;j<Final_Board[i].length;j++)
			{
				if(Final_Board[i][j]=='k')
				{
				Count_Of_Kings=Count_Of_Kings+1;
			}}
		}
		System.out.println();
		System.out.println("Total number of maximum kings = "+Count_Of_Kings);
		
		}

	}


/*
 * Syntax References- 
 * 
 *  (https://docs.oracle.com/en/java/javase/16/)
 */


