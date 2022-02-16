/*
Copyright (C) Deepali Srivastava - All Rights Reserved
This code is part of DSA course available on CourseGalaxy.com    
*/

package warshalls;

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
		  g1.insertEdge("Two","One");
		  g1.insertEdge("Three","Zero");
		  g1.insertEdge("Three","Two");
		
		  g1.Warshalls();
	}
}
