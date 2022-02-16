/*
Copyright (C) Deepali Srivastava - All Rights Reserved
This code is part of DSA course available on CourseGalaxy.com    
*/

package adjacencyMatrixRepresentation;

import java.util.Scanner;

public class DemoUndirectedGraph 
{
	   public static void main(String [] args)
	   {
		  Scanner scan = new Scanner(System.in);
		  
		  UndirectedGraph g = new UndirectedGraph();
		  
		  int choice;
		  String s1,s2;
		  
	      while(true)
		  {
	    	  System.out.println("1.Display Adjacency Matrix");
			  System.out.println("2.Insert a vertex");
			  System.out.println("3.Insert an edge");
			  System.out.println("4.Delete an edge");
			  System.out.println("5.Display Indegree and outdegree of a vertex");
			  System.out.println("6.Check if there is an edge between two vertices");
			  System.out.println("7.Exit");
			  System.out.print("Enter your choice : ");
			  choice = scan.nextInt();
			  if(choice==7)
				break;
			
			 switch(choice)
			 {
			 case 1:
				 g.display();
				 System.out.println("Vertices = " + g.vertices()+ ", Edges = " + g.edges());
			     break;
			 case 2:
				 System.out.print("Insert a vertex : ");
				 s1=scan.next();
				 g.insertVertex(s1);
				 break;
			 case 3:
				 System.out.print("Enter start and end vertices : ");
				 s1=scan.next();
				 s2=scan.next();
				 g.insertEdge(s1,s2);
				 break;
			 case 4:
				 System.out.print("Enter start and end vertices : ");
				 s1=scan.next();
				 s2=scan.next();
				 g.deleteEdge(s1,s2);
				 break;
			 case 5: 
				 System.out.print("Enter a vertex : ");
				 s1=scan.next();
				 System.out.println("Degree is : " + g.degree(s1));
				 break;
			 case 6:
				 System.out.print("Enter two vertices : ");
				 s1=scan.next();
				 s2=scan.next();
				 if(g.edgeExists(s1,s2))
					 System.out.println("There is an edge from " + s1 + " to " + s2);
				 else
					 System.out.println("There is no edge from " + s1 + " to " + s2);
				 break;
			default:
				System.out.println("Wrong choice");
				break;
			}
		}
	  }

}
