/*
 * Name:Bravish Ghosh
 * Regd no:1941012333
 * Sec:Q
 */

import java.util.Scanner;

class Node{
	protected int regd_no;
	protected float mark;
	protected Node next;
}
public class LinkedList 
{
	public static void main(String[] args)
	{
	    Node start=null;
		Scanner sc=new Scanner(System.in);
		int ch;
		int opt;
		while(true)
		{
			System.out.println("***********************MENU****************************");
			System.out.println("0.Exit");
			System.out.println("1.Creation");
			System.out.println("2.Display");
			System.out.println("3.Insert At Beginning");
			System.out.println("4.Insert At End");
			System.out.println("5.Insert At any position");
			System.out.println("6.Search and Update marks w.r.t. Registration Number");
			System.out.println("7.Delete At Beginning");
			System.out.println("8.Delete At End");
			System.out.println("9.Delete At Any Position");
			System.out.println("10.Sort the list on basis of marks obtained");
			System.out.println("11.Count the no. of nodes present in the list");
			System.out.println("12.Reverse the list");
			System.out.println("Enter your choice");
			ch=sc.nextInt();
			System.out.println("*****************************************************************");
			switch(ch) {
			case 0:System.exit(0);
			  break;
			case 1:
				System.out.println("*****************************************************************");
				start=create(start);
				System.out.println("*****************************************************************");
			break;
			case 2:
				System.out.println("*****************************************************************");
				display(start);
				System.out.println("*****************************************************************");
			break;
			case 3:
				System.out.println("*****************************************************************");
				start=InsBeg(start);
				System.out.println("*****************************************************************");
			break;
			case 4:System.out.println("*****************************************************************");
				start=InsEnd(start);
				System.out.println("*****************************************************************");
			break;
			case 5:
				System.out.println("*****************************************************************");
				start=InsAny(start);
				System.out.println("*****************************************************************");
			break;
			case 6:
				System.out.println("*****************************************************************");
				search(start);
				System.out.println("*****************************************************************");
			break;
			case 7:
				System.out.println("*****************************************************************");
				start=DelBeg(start);
				System.out.println("*****************************************************************");
			break;
			case 8:
				System.out.println("*****************************************************************");
				start=DelEnd(start);
				System.out.println("*****************************************************************");
			break;
			case 9:
				System.out.println("*****************************************************************");
				start=DelAny(start);
				System.out.println("*****************************************************************");
			break;
			case 10:
				System.out.println("*****************************************************************");
				sort(start);
				System.out.println("*****************************************************************");
			break;
			case 11:
				System.out.println("*****************************************************************");
				System.out.println("No of nodes="+count(start));
				System.out.println("*****************************************************************");
			break;
			case 12:
				System.out.println("*****************************************************************");
				start=reverse(start);
				System.out.println("*****************************************************************");
			break;
			default:System.out.println("Wrong choice");
			}
		}
	}
	    public static Node create(Node start)
        {
    	Node p=new Node();
    	Scanner sc=new Scanner(System.in);
    	p.next=null;
    	System.out.println("Enter registered number and marks of student using enter key");
    	p.regd_no=sc.nextInt();
    	p.mark=sc.nextFloat();
    	start=p;
    	Node end=p;
    	System.out.println("Want to enter more nodes?(1 or 0)");
    	int ch=sc.nextInt();
    	while(ch!=0)
    	{
    		p=new Node();
    		p.next=null;
    		System.out.println("Enter registered number and marks of student using enter key");
    		p.regd_no=sc.nextInt();
        	p.mark=sc.nextFloat();
        	end.next=p;
        	end=p;
        	System.out.println("Want to enter more nodes?(1 or 0)");
            ch=sc.nextInt();
    	}return start;
    }
    public static void display(Node start) {
    	if(start==null) {
    		System.out.println("No elements present in node ");
    		return;
    	}Node temp=start;
    	System.out.println("Student details is as follows:");
    	System.out.println("--------------------------------------------------------------");
    	   System.out.println(" | Registration No  | Marks  |     Address of next node    | ");
    	while(temp!=null)
    	{   System.out.println("--------------------------------------------------------------");
    		System.out.println(" |         "+temp.regd_no+"       | "+temp.mark+"  |  "+temp.next+"  | ");
    		System.out.println("--------------------------------------------------------------"); 
    		temp=temp.next;
    	}   	   	
    }
    public static int count(Node start) {

    	int c=0;
    	if(start==null) {
    		System.out.println("No elements present in node ");
    		return c;
    	}Node temp=start;
    	while(temp!=null)
    	{
    		c++;
    		temp=temp.next;
    	} return c;   	   	
    }
    public static Node InsBeg(Node start) {
		Node p=new Node();
		p.next=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter regd no and marks");
		p.regd_no=sc.nextInt();
		p.mark=sc.nextFloat();
		if(start!=null)
	       p.next=start;
	    start=p;
	    return start;		
	}
    public static Node InsEnd(Node start) {
		Node p=new Node();
		p.next=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter regd no and marks");
		p.regd_no=sc.nextInt();
		p.mark=sc.nextFloat();
		if(start==null)
			{start=p;
			return start;
			}
		Node temp=start;
		while(temp.next!=null)
	       temp=temp.next;
	    temp.next=p;
	    return start;
	}
    public static Node InsAny(Node start) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the position where u want node to be inserted");
		int pos=sc.nextInt();
		int c=count(start);
		if(pos>=1&&pos<c+2) {
			if(pos==1)
				InsBeg(start);
			if(pos==c+1)
				InsEnd(start);
			else {
		Node p=new Node();
		p.next=null;
		System.out.println("Enter regd no and marks");
		p.regd_no=sc.nextInt();
		p.mark=sc.nextFloat();
		if(start==null)
			{start=p;
			return start;
			}
		Node temp=start;
		int i=1;
		while(i<pos-1)
		{ temp=temp.next;
		i++;
		}
		p.next=temp.next;
	    temp.next=p;}
	   }
		else
		System.out.println("Not valid position");
		return start;
	}
    public static Node DelBeg(Node start) {
		if(start==null) {
			System.out.println("No elements pesent in node");
			return start;
		}
		System.out.println("Deletion successful at beginning");
		System.out.println("Deleted Node Reg. No:"+start.regd_no);
		start=start.next;
		return start;
	}
	public static Node DelEnd(Node start) {
		if(start==null) {
			System.out.println("No elements pesent in node");
			return start;
		}System.out.println("Deletion successful at last");
		if(start.next==null)
           {start=null;return start;}
		
		Node temp = start;
		Node q=null;
		while(temp.next!=null) {
			q=temp;
			temp=temp.next;
		}
		System.out.println("Deleted Node Reg. No:"+temp.regd_no);
		q.next=null;
		return start;

	} 
	public static Node DelAny(Node start) {
		if(start==null) {
			System.out.println("No elements pesent in node");
			return start;
		}
		Scanner sc=new Scanner(System.in);
		int c=count(start);
		System.out.println("Enter position:");
		int p=sc.nextInt();
		
		if(p>=1&&p<=c) {
		System.out.println("Deletion successful at your specified location");
		if(start.next==null)
           {start=null;return start;}
		if(p==1)
			start=DelBeg(start);
		else if(p==c)
			start=DelEnd(start);
		else {
		Node temp = start;
		Node q=null;
		int i=1;
		while(i<p) {
			q=temp;
			temp=temp.next;
			i++;
		}System.out.println("Deleted Node Reg. No:"+temp.regd_no);
		q.next=temp.next;
		temp.next=null;
		}}
		else
			System.out.println("No such position exists");
		return start;
	}
	public static void search(Node start) {
    	if(start==null) {
    		System.out.println("No elements present in node ");
    		return;
    	}Node temp=start;
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Enter regd no of student u want to update marks");
        int reg=sc.nextInt();
        boolean k=false;
    	//	System.out.println("Student updated details is as follows:");
    	while(temp!=null)
    	{
    		if(temp.regd_no==reg)
    		{
    			System.out.println("Node found");
    			System.out.println("Enter updated marks");
    			temp.mark=sc.nextFloat();
    			k=true;
    		}
    		temp=temp.next;
    	}    	   	
    	if(k==false)
    		System.out.println("No such element present");
    	else if(k==true)
    		System.out.println("Your request is successful");
	}
	 public static void sort(Node start)
	    {
		 System.out.println("Wait!!!We are sorting the list");
	    	Node temp,q,p;
	    	for(temp=start;temp!=null;temp=temp.next)
	    	{
	    		for(q=start;q!=null;q=q.next)
	    		{
	    			if(temp.mark<q.mark)
	    			{
	    			     float m=temp.mark;
	    				temp.mark=q.mark;
	    				q.mark=m;
	    				int r=temp.regd_no;
	    				temp.regd_no=q.regd_no;
	    				q.regd_no=r;
	    			}
	    		}
	    	}System.out.println("We have sorted the list");
	    }

	   public static Node reverse(Node start) {
		   System.out.println("Wait!We are reversing your list");
		   Node prev=null;
		   Node current=start;
		   Node n=null;
		   while(current!=null)
		   {
			   n=current.next;
			   current.next=prev;
			   prev=current;
			   current=n;			   
		   }
		   start=prev;
		   System.out.println("Your list is reversed");
		   return start;		   
		   
	   }
	

}
