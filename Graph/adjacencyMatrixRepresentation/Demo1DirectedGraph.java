/*
Copyright (C) Deepali Srivastava - All Rights Reserved
This code is part of DSA course available on CourseGalaxy.com    
*/

package adjacencyMatrixRepresentation;

public class Demo1DirectedGraph
{
	public static void main(String [] args)
	{
		DirectedGraph g = new DirectedGraph();
		
		g.insertVertex("Zero");
		g.insertVertex("One");
		g.insertVertex("Two");
		
		g.insertEdge("One", "Two");
		g.insertEdge("Two", "Zero");
		
		g.display();
		System.out.println("Vertices = " + g.vertices()+ ", Edges = " + g.edges());
	}
}
