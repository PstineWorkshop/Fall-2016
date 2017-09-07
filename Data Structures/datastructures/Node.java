package datastructures;

public class Node
{
   /* fix this up!  attributes are private and 
      getters/setters are public! */
   private String info;
   private Node next;
   
   public Node ()
   
   {
      next=null;
   }
   public Node (String s)
   {
      this.info=s;
   }
   public Node getNext()
   {
      return this.next;
   }
   public void setNext(Node n)
   {
      this.next=n;
   }
   public void setInfo(String s)
   {
      this.info=s;
   }
   public String getInfo()
   {
      return this.info;
   }
    @Override
   public String toString()
   {
      return this.info;
   }



}