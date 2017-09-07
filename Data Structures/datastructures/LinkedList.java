package datastructures;

public class LinkedList implements List
{
   public Node root;
  
  // start add method with a single string parameter
   public void add( String s )
   {
         Node n = new Node(s);
         Node temp;
         
         if(root==null)
        {
         root=n;
        }
        else
        {
        
            temp=root;
            while (temp.getNext()!=null)
            {
               temp = temp.getNext();
           
            }
            temp.setNext(n);
        
        }
  
   }
   
   //end add method  with  a single string parameter
   
    //start of add method with a int and string parameter
 
   public void add(int idx, String val)
{
     Node r=root;
     Node temp=root;
     Node n=new Node(val);
     int count=0;
     String s="";
     while(r!= null && s!="stop")
     {
         
         if(idx==0)
         {
            n.setNext(root);
            root=n;
            s="stop";
         }
         else if(count==idx)
         {
            temp.setNext(n);
            n.setNext(r);
            s="stop";
         }
         else
         {
            count++;
           temp=r;
          r=r.getNext();
      }
     }
}
  
 //end of add method with a int and string parameter

  
  //start index of method
  public int   indexOf( String s )
  {
      int pos=-1;
      Node r=root;
      String a="";
      int count=0;
      
      while(r!=null && a !="stop")
      {
         if(r.getInfo().equals(s))
         {
            
            pos=count;
            a="stop";
         }
         r=r.getNext();
          count++;
        
      }
      
      
      return pos;
  }
  //end of index of method
  
  //start remove method with a string parameter
  public void remove(String s)
  {
        Node currentNode = root;

        Node previousNode = root;
        
        while(currentNode.getInfo() != s)
        {//start while loop

            if(currentNode.getNext() == null)
            {//start if
                return;

            } //end if
            else 
             {//start else
                 previousNode = currentNode;
                currentNode = currentNode.getNext();
            }//end else

        }//end while loop

        if(currentNode == root)
        {//start if

            root= root.getNext();

        } //end if
        else 
        {//start if
              previousNode.setNext(currentNode.getNext());
        }//end if
    }

  /*System.out.println("FOUND A MATCH");
            System.out.println("currentnode: " + currentNode);
            System.out.println("root: " + root);
*/
  
  
  // public void remove( String s )
 // {
    //     Node r=root;
    //     Node n=new Node();
    //     Node temp;
     //    while(r.getNext()!=null)
      //   {
        //    if(r.getNext().getInfo().equals(s))
      //      {
               
       //     }
        // }
        
 // }
  //end of remove method with a string parameter

  
  //start of get method
  public String get( int idx )
  {
   String s ="banna split";
   Node r=root;
   int count=0;
   String a="";
 while(r!=null && a !="stop")
 {
   if(count==idx)
   {
      s=r.getInfo();
      a="stop";
   }
   r=r.getNext();
   count++;
  
 }
    return s;
  }
   //end of get method
  
  //start of set method with a int and string parameter
  public void set( int idx, String s )
  {
         int count=0;
         Node temp;
         temp=root;
         
         while(count != idx)
         {
            temp=temp.getNext();
            count++;
         
         }
         temp.setInfo(s);
         
         
  }
  
  //end of set method with a int and string parameter

  //start of the contains method
  
  public boolean contains( String s )
  {
      boolean there=false;
      Node r=root;
      String stop="";
      
    if( isEmpty())
     {
          while(r!=null && stop!="stop")
        {  
             if(r.getInfo().equals(s))
             {
                 there=true;
                stop="stop";
             }
          r=r.getNext();
         }   
     }   
     else
     {
         System.out.println("Linked  List is Empty");
     
     }
      
      return there;
  }
  //end of contains method
  
  //start of isEmpty method
  public boolean isEmpty()
  {
       int count=0;
       boolean empty=false;
    Node r=root;
    while(r!=null)
    {
      count++;
      r=r.getNext();
    }
    if(count>0)
    {
      empty=true;
    }
      return empty;          
 }
  
  //end of is empty method
  
  //start of is full method
  public boolean isFull()
  {
      boolean full=false;
      return full;
  }
  //end of the is full method 
 
 
  //start of size method
  public  int size()
  {
    int count=0;
    Node r=root;
    while(r!=null)
    {
      
      count++;
      r=r.getNext();
    }
      
    return count;
    
    
  }
  //end of size method
  
  // start of clear emthod
  public  void clear()
  {
      root=null;
  }
  //end of clear method
   
   //start of string to array method
   //public String[] toArray()
   //{
  
 // }
  //end of to string method
  
  //start of string to string method
  public String toString()
  {
      String s="";
      
      Node r= root;
      
      while(r!=null)
      {
            s+=r.getInfo();
            if(r.getNext()!=null)
            {
               s+= ", ";
            }
            r=r.getNext();
      
      }
      return s;
  }
  //end of to string method
   
}