import datastructures.LinkedList;
import datastructures.List;
import java.util.Arrays;

public class LinkedListTester
{
   public static void main(String[] args)
   {
      //List<String> lst = new LinkedList<>();
      List lst = new LinkedList();
      int p = lst.indexOf("C");
      System.out.println( "C is at position: " + p );
      for( int i=0; i<20; i++ )
      {
         lst.add("" + (char)('A' + (int)(Math.random() * 26)) );      
      }
      p = lst.indexOf("C");
      System.out.println( "C is at position: " + p );
      
      System.out.println( lst );
      
      System.out.println( "------ Using new List ------" );
      //List<String> nameList = new LinkedList<>();
      List nameList = new LinkedList();
      System.out.println( "adding George" );
      nameList.add("George");
      System.out.println( "adding Abraham" );
      nameList.add("Abraham");
      System.out.println( "adding Calvin" );
      nameList.add("Calvin");
      System.out.println( "adding Franklin" );
      nameList.add("Franklin");
      System.out.println( "adding Dwight" );
      nameList.add("Dwight");
      System.out.println( nameList );

      System.out.println( "Removing Calvin" );
      nameList.remove("Calvin");
      System.out.println( nameList );
      
      System.out.println( "Removing Lyndon" );
      nameList.remove("Lyndon");
      System.out.println( nameList );
      
      System.out.println( "Name at position 2: " + nameList.get(2));
      System.out.println( "Setting Woodrow at position 2" );
      nameList.set(2, "Woodrow");
      System.out.println( nameList );
           
      System.out.println( "Location of Dwight: " + nameList.indexOf("Dwight"));
      nameList.add(nameList.indexOf("Dwight"), "Hubert");
      System.out.println( "Adding Ulysses to end of list." );
      nameList.add("Ulysses");
      System.out.println( "Adding Barack to start of list." );
      nameList.add(0, "Barack");
      System.out.println( "Size of list = " + nameList.size() );
      System.out.println( nameList );
      //String[] arrayList = (String[])nameList.toArray();
      //System.out.println( "Size of array = " + arrayList.length );
      //System.out.println( Arrays.toString(arrayList));
      //System.out.println( "Size of array = " + (nameList.toArray()).length );
      //System.out.println( Arrays.toString(nameList.toArray()));
      nameList.clear();
      System.out.println( "Size of list after clear = " + nameList.size() );
      System.out.println( nameList );
   }
}



/*

   Here is my output:
 
 
     
 
  ----jGRASP exec: java LinkedListTester -Xlint:unchecked
 C is at position: -1
 C is at position: 19
 U, H, Y, D, V, U, P, V, N, L, L, H, R, S, U, F, F, I, T, Z
 ------ Using new List ------
 adding George
 adding Abraham
 adding Calvin
 adding Franklin
 adding Dwight
 George, Abraham, Calvin, Franklin, Dwight
 Removing Calvin
 George, Abraham, Franklin, Dwight
 Removing Lyndon
 George, Abraham, Franklin, Dwight
 Name at position 2: Franklin
 Setting Woodrow at position 2
 George, Abraham, Woodrow, Dwight
 Location of Dwight: 3
 Adding Ulysses to end of list.
 Adding Barack to start of list.
 Size of list = 7
 Barack, George, Abraham, Woodrow, Hubert, Dwight, Ulysses
 Size of list after clear = 0
 
 
  ----jGRASP: operation complete.
    
*/