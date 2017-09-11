import java.util.Scanner;
import java.io.*;        
import javax.swing.JFrame; 
import java.awt.Color;

public class DMazeApp
{
   static Display display;
	public static void main(String[] args) throws IOException
	{
		Scanner conIn = new Scanner(System.in);
		boolean moreMazes;
		String filename;
		int n;

		System.out.print("Enter the input file name:  ");
		filename = conIn.nextLine();

      JFrame frame = new JFrame("Depth First Search");
      display = new Display();
      display.setBackground(new Color(255,255,255));
      frame.add(display);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //frame.setLocationRelativeTo(null);
      frame.setSize(800, 800);
      frame.setVisible(true);
      
      frame.setBackground(new Color(0,0,128));

		DMaze m = new DMaze(filename);
      
		moreMazes = m.getMaze();
      
      display.setDMaze(m);
		while (moreMazes)
		{
			System.out.println("\nHere is the maze:");
						
			System.out.println(m);

			System.out.print("\nHit <Enter> to solve this maze...");
			conIn.nextLine();

			n = m.solveMaze();
			System.out.println("\nDone with this maze.  It has " + n + " solution(s).\n");

			System.out.print("\nHit <Enter> to get the next maze...");
			conIn.nextLine();
			
			moreMazes = m.getMaze();
         display.setDMaze(m);
		}
	   display.setDMaze(null);
		System.out.println("\nNo more mazes in the file...Bye!\n");
      System.exit(0);
	}
}