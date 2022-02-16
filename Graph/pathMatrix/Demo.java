/*
Copyright (C) Deepali Srivastava - All Rights Reserved
This code is part of DSA course available on CourseGalaxy.com    
*/

package pathMatrix;

public class Demo 
{
	public static void main(String [] args)
	{
		  DirectedGraph g1 = new DirectedGraph();
		        
		  g1.insertVertex("Zero");
  		  g1.insertVertex("One");
		  g1.insertVertex("Two");
		  g1.insertVertex("Three");

		  g1.insertEdge("Zero","One");
		  g1.insertEdge("Zero","Three");
		  g1.insertEdge("One","Two");
		  g1.insertEdge("One","Three");
		  g1.insertEdge("Three","Two");
		  g1.findPathMatrix();
		  
		  System.out.println();
		 
		  DirectedGraph g2 = new DirectedGraph();
		  
		  g2.insertVertex("Zero");
  		  g2.insertVertex("One");
		  g2.insertVertex("Two");
		  g2.insertVertex("Three");
		  
		  g2.insertEdge("Zero","One");
		  g2.insertEdge("Zero","Three");
		  g2.insertEdge("One","Two");
		  g2.insertEdge("One","Three");
		  g2.insertEdge("Two","Zero");
		  g2.insertEdge("Three","Two");
		  g2.findPathMatrix();
	}	
}
