package datastructures;

public interface List
{
   void add( String s );
   int   indexOf( String s );
   void add( int idx, String s );   
   void remove( String s );
   String get( int idx );
   void set( int idx, String s );
   boolean contains( String s );
   boolean isEmpty();
  boolean isFull();
   int size();
   void clear();
  // String[] toArray();
   String toString();      /* inherited from Object */

}