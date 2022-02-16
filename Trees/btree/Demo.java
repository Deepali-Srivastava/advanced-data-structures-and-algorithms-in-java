/*
Copyright (C) Deepali Srivastava - All Rights Reserved
This code is part of DSA course available on CourseGalaxy.com    
*/

package btree;

import java.util.Scanner;

public class Demo 
{
	public static void main(String[] args) 
	{
		Btree tree = new Btree();
        int key,choice;

        Scanner scan = new Scanner(System.in);	
                
        while(true)
        {
	        System.out.println("1.Search");
            System.out.println("2.Insert");
            System.out.println("3.Delete");
            System.out.println("4.Display");
            System.out.println("5.Inorder traversal");
            System.out.println("6.Quit");

	        System.out.print("Enter your choice : ");
            choice = scan.nextInt();

            if (choice == 6)
                break;

	        switch(choice)
	        {
		        case 1:
		    	    System.out.print("Enter the key to be searched : ");
                    key = scan.nextInt();

                    if( tree.Search(key)==true)
                        System.out.println("Key present");
                    else
                        System.out.println("Key not present");
                    break;
		        case 2:
			        System.out.print("Enter the key to be inserted : ");
                    key = scan.nextInt();
			        tree.Insert(key);
			        break;
		        case 3:
			        System.out.print("Enter the key to be deleted : ");
                    key = scan.nextInt();
			        tree.Delete(key);
			        break;
		        case 4:
			        System.out.println("Btree is :\n");
			        tree.Display();
			        System.out.println("\n");
			        break;
		        case 5:
			        tree.Inorder();
			        System.out.println("\n");
			        break;
		         default:
			        System.out.println("Wrong choice\n");
    				break;
	        }
        }
    	scan.close();
	}
	
}

