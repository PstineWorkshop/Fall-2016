import java.io.*;         
import java.util.Scanner;

public class DMaze
{
   Display display;
   Scanner kbd = new Scanner(System.in);

	protected final char SPACE = ' ';
	protected final char WALL = '#';
	protected final char FOOTPRINT = '+';
	protected final char START = 'S';
	protected final char END = 'E';
	
	protected int numRows;        
	protected int numCols;        

	protected int startRow;
	protected int startCol;
	protected int endRow;
	protected int endCol;

	protected int numSolutions;
		    
	protected PrintWriter output;
	protected BufferedReader input;

	protected char [][] grid;  
	boolean [][] visited;           
   
	public DMaze(String inputFileName) throws IOException
	{
      FileReader f = new FileReader(inputFileName);
      input = new BufferedReader(f);      
	}

   public void setDisplay(Display d)
   {
      display = d;
   }
	public boolean getMaze() throws IOException
	{
		int i, j;
      grid = FileInput.getNextGrid(input);
		
      numRows = grid.length;
		
		if (numRows == 0)
			return false;
		else
		{
			numCols = grid[0].length;
			visited = new boolean[numRows][numCols];
			return true;
		}
	}

//***************************************************************************	
	public String toString()
	{//start of tostring
		String mazeString = "";
         int r;
         int c;
         int count=0;
         for (r = 0; r< grid.length; r++) 
         {
          //  count=0;
            for (c = 0; c < grid[r].length; c++) 
            {
               
               if(visited[r][c]==true && grid[r][c]==' ')
               {
                  mazeString +='+';
                  continue;
               }
               else
               {
                      mazeString +=grid[r][c];

               }
                             
               
               /*if(grid[r][c]==' ')
               {
                  mazeString +="  ";

               }*/
              }  
                  mazeString+="\n";
            }
               
            
        
      // WRITE THIS METHOD HERE
		// You will neeed both visited AND grid, and character constants
      
      return mazeString;
	} // 	public String toString()
//***************************************************************************	
   public int solveMaze()
	{
		int i, j;
		numSolutions = 0;
			
		// Get start and end coordinates and set visited array to false.
		for (i = 0; i < numRows; i++)
      {
			for (j = 0; j < numCols; j++)
			{
				visited[i][j] = false;
				if (grid[i][j] == START)
				{
					startRow = i;
					startCol = j;
				}
				else if (grid[i][j] == END)
				{
					endRow = i;
					endCol = j;
				}
			}
      }
      /* solve maze */
		visitCell(startRow, startCol);
		
		return numSolutions;
	}	

   public void sleep(int t)      // t==1000, sleep for 1 second
   {
         try
         {
            Thread.sleep(t);
         }
         catch(InterruptedException ie)
         {
            System.out.println(ie);
         }
   }
//***************************************************************************	
	private void visitCell(int i, int j)
	{
		if (i == endRow && j == endCol)
		{
			numSolutions++;
			
         System.out.print("\nSolution number " + numSolutions + ":\n");
			
         System.out.println(this);  // what method is called here?
         
			System.out.print("Hit \"Enter\" to look for another solution...");
			
         kbd.nextLine();
		}
      else if( visited[i][j] == true ) 
      {
         
        return;
        //break out of the method
      }
      else if( grid[i][j] == WALL ) 
      {
        return;
         //break out of the method
      }
		else
		{
         
      //      visited[i][j] = true;
         
      //   if(i ==startRow && j== startCol)
     //    {
     //          grid[i][j] = 'S';
      //   }
         
       //  else 
       //  {
      //         grid[i][j] = '+';
       //  }
         
         
            visited[i][j]=true;
            
            sleep(50);
            
            visitCell(i,j-1);
            
            visitCell(i,j+1);
            
            visitCell(i+1,j);
            
            visitCell(i-1,j);

         
            sleep(50);
         
            visited[i][j]=false;
         
         //   grid[i][j] = ' ';

         
         
         //set visited, sleep for 1/10 sec., visit all the
         //  other cells, sleep another 1/10 sec.  clear the
         //  visited flag (so we can re-use this portion of 
         //  maze in another path)
         
         return;
		}
	}
}
