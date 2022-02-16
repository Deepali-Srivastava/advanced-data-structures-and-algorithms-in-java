/*
Copyright (C) Deepali Srivastava - All Rights Reserved
This code is part of DSA course available on CourseGalaxy.com    
*/

package adjacencyListRepresentation;

import java.util.Scanner;

public class Demo 
{
	public static void main(String [] args)
	{
		  Scanner scan = new Scanner(System.in);
		  		  	  
		  LinkedDigraph g = new LinkedDigraph();
		  		        
	      int choice;
	      String u,v;
      	            
	      while(true)
		  {
			System.out.println("1.Display ");
			System.out.println("2.Insert a vertex");
			System.out.println("3.Delete a vertex");
			System.out.println("4.Insert an edge");
			System.out.println("5.Delete an edge");
			System.out.println("6.Display Indegree and outdegree of a vertex");
			System.out.println("7.Check if there is an edge between two vertices");
			System.out.println("8.Exit");
			System.out.print("Enter your choice : ");
			choice = scan.nextInt();
			if(choice==8)
				break;
			
			switch(choice)
			{
			 case 1:
				 System.out.println();
				 g.display();
				 System.out.println("\n Vertices = " + g.vertices()+ ", Edges = " + g.edges() + "\n");
			     break;
			 case 2:
				 System.out.print("Enter a vertex to be inserted :  ");
				 u=scan.next();
				 g.insertVertex(u);
				 break;
			 case 3:
				 System.out.print("Enter a vertex to be deleted :  ");
				 u=scan.next();
				 g.deleteVertex(u);
				 break;
			 case 4:
				 System.out.print("Enter an edge to be inserted : ");
				 u=scan.next();
				 v=scan.next();
				 g.insertEdge(u,v);
				 break;
			 case 5:
				 System.out.print("Enter an edge to be deleted : ");
				 u=scan.next();
				 v=scan.next();
				 g.deleteEdge(u,v);
				 break;
			 case 6: 
				 System.out.print("Enter a vertex : ");
				 u=scan.next();
				 System.out.println("Indegree is : " + g.inDegree(u));
				 System.out.println("Outdegree is : " + g.outDegree(u));
				 break;
			 case 7:
				 System.out.print("Enter two vertices : ");
				 u=scan.next();
				 v=scan.next();
				 if(g.edgeExists(u,v))
					 System.out.println("Vertex " + v + " is adjacent to vertex " + u);
				 else
				 	 System.out.println("Vertex " + v + " is not adjacent to vertex " + u);
				
				 if(g.edgeExists(v,u))
					 System.out.println("Vertex " + u + " is adjacent to vertex " + v);
				 else
					 System.out.println("Vertex " + u + " is not adjacent to vertex " + v);
				
			default:
				System.out.println("Wrong choice");
				break;
			}
		}
    }

}
