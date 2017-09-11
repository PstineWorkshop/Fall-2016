import java.util.ArrayList;
import java.util.Arrays;

public class RecursionPractice
{
   public static void main(String[] args)
   {
     
     int t=sum(5,10);
     System.out.println(t);
      long nP = numPaths( 12,12);
      System.out.println( "Num paths = " + nP );
      int n = 9;
      System.out.println( "factorial(" + n + ") is " + factorial(n));
      
      n = 12;
      System.out.println( "fibonacci(" + n + ") is " + fibonacci(n));
      System.out.println( "Recursion count = " + fibCount );
      
      int st = 1;
      int end = 4;
      System.out.println( "Sum of the numbers from " + st + " to " + end + " is " + sum(st, end) ); 
      
      towersOfHanoi(3, 1,3,2 );
      String pal = "racecart";
      if( isPalindrome(pal) ) 
      {
         System.out.println( pal + " is a palindrome!" );
      }
      else
      {
         System.out.println( pal + " is NOT a palindrome!" );
      }
      pal = "racecar";
      if( isPalindrome(pal) ) 
      {
         System.out.println( pal + " is a palindrome!" );
      }
      else
      {
         System.out.println( pal + " is NOT a palindrome!" );
      }
      int[] a = {1,2,3,5,4,6,7,8};
      if( isSorted(a) )
      {
         System.out.println( Arrays.toString(a) + " is sorted!" );
      }
      else
      {
         System.out.println( Arrays.toString(a) + " is NOT sorted!" );
      }
      int[] a2 = {3,5,7,8,9,10,12,14};
      if( isSorted(a2) )
      {
         System.out.println( Arrays.toString(a2) + " is sorted!" );
      }
      else
      {
         System.out.println( Arrays.toString(a2) + " is NOT sorted!" );
      }
   }
   
   public static long factorial(int n)
   {
      System.out.println("Method " + n);
      long outcome=0;
      if(n==1)
      {
          System.out.println("Returned 1");
         return 1;
      }
      else
      {
         outcome = n * factorial(n -1);
         System.out.print("Returned " + outcome);
         System.out.println(" : " + n + " * factorial (" + n + " - 1)");
         return outcome;
      }
     
   }
   
   public static int fibCount = 0;
   public static long fibonacci(int n)
   {
      
       if(n == 0)
       {
        return 0;
       }
         else if(n == 1)
         {
            return 1;
      }
      else
      {
         fibCount++;
      }
      //System.out.println(fibCount);
       
      long sum1=fibonacci(n - 1);
       System.out.println("sum1 = " + " fibonacci (" + n + " - 1)" +" = " +  sum1 );
      long sum2=fibonacci(n - 2);
      System.out.println("sum2 = " + " fibonacci (" + n + " - 2)" +" = " +  sum2 );
      long total=sum1+sum2;
      System.out.println("Total = " + sum1 + "+" + sum2 + " = " + total);
      
      return total;
    
   }
   
   public static void towersOfHanoi(int n, int start, int end, int aux)
   {
      if(n==0)
      {
         return;
      }
     towersOfHanoi(n-1, start, end, aux);
    towersOfHanoi(n-1, aux, start, end);
    System.out.printf("Move one disk from pole %s to pole %s \n ", start, end);
   }
   
   /* sum all values between s and n inclusive */
   /*   assume s is less than or equal to n to start */
   public static int sum(int s, int n)
   {
    
    System.out.println("method " + s);
    int total=0;

    if(s>=n)
     {
        
        System.out.println("returned " + n);
        return n;
    }
     else
      {
          int sum = sum(s+1,n);
             System.out.print(" Sum =  " + s + "  + " + sum);
           total =  s + sum;        
            System.out.println(" Total = " + total );

           //System.out.println("total " + total);
                           return total;
      }
      
      
   }
   /* this method is done, it simply calls the recursive method */
   public static boolean isSorted(int[] a)
   {
      return isSortedRec(a, 0, a.length-1);
   }
   /* assume low < high to begin */
   public static boolean isSortedRec( int[] a, int low, int high )
   {
      if(low>=high)
      {
         return true;
      }
      else if(a[low] <a[low+1])
      {
         System.out.println(low+1);      
         return  isSortedRec(a,low+1,high)  ;    
 
      }
      else 
      {
          return false ;

     
      }
      
           }

   /* this next method is done, it simply calls the recursive method */
   public static boolean isPalindrome(String a)
   {
      return isPalindromeRec(a, 0, a.length()-1);
   }
   public static boolean isPalindromeRec( String a, int low, int high )
   {
       if(a.length() == 0 || a.length() == 1)
            // if length =0 OR 1 then it is
            return true; 
            
        if(a.charAt(0) == a.charAt(a.length()-1))
            // check for first and last char of String:
            // if they are same then do the same thing for a substring
            // with first and last char removed. and carry on this
            // until you string completes or condition fails
            return isPalindromeRec(a.substring(1, a.length()-1),1,(a.length()-1));

        // if its not the case than string is not.
        return false;

   }
   //seteps to get from one location to another  to zero zero
   public static long numPaths(int r, int c)
   {//start method
      
      if (r == 1 || c == 1){
         return 1;
      }
       
       
        long pathCount = numPaths(r-1, c)  + numPaths(r, c-1);
       
       // + numberOfPaths(m-1,n-1);
       // you eould add this if the paths from end to another were more than just vertical and horizontal paths
       return pathCount;
   }



 
   
}
