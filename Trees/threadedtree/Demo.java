/*
Copyright (C) Deepali Srivastava - All Rights Reserved
This code is part of DSA course available on CourseGalaxy.com    
*/

package threadedtree;

import java.util.Scanner;

public class Demo 
{
	public static void main(String[] args) 
	{
	    ThreadedBinaryTree tree = new ThreadedBinaryTree(); 
		int choice,x;
        
		Scanner scan = new Scanner(System.in);	
		
	    while(true)
	    {
		    System.out.println("1.Insert a new node");
		    System.out.println("2.Delete a node");
		    System.out.println("3.Inorder Traversal");
		    System.out.println("4.Exit");
		    
            System.out.print("Enter your choice : ");
		    choice = scan.nextInt();

		    if(choice == 4)
			    break;

		    switch( choice )
		    {
		     case 1:
			    System.out.print("Enter the key to be inserted : ");
			    x = scan.nextInt();
			    tree.insert(x);
			    break;
		     case 2:
			    System.out.print("Enter the key to be deleted : ");
			    x = scan.nextInt();
			    tree.delete(x);
			    break;
		     case 3:
			    tree.inorder();
			    break;
		    }
	    }
	    scan.close();
	}
}
