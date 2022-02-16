/*
Copyright (C) Deepali Srivastava - All Rights Reserved
This code is part of DSA course available on CourseGalaxy.com    
*/

package dfsUndirected;

public class Demo 
{
	public static void main(String [] args)
	{
		UndirectedGraph g = new UndirectedGraph();
				
		g.insertVertex("Zero");
		g.insertVertex("One");
		g.insertVertex("Two");
		g.insertVertex("Three");
		g.insertVertex("Four");
		g.insertVertex("Five");
		g.insertVertex("Six");
		g.insertVertex("Seven");
		g.insertVertex("Eight");
		g.insertVertex("Nine");
		g.insertVertex("Ten");	
		g.insertVertex("Eleven");
		g.insertVertex("Twelve");
		g.insertVertex("Thirteen");
		g.insertVertex("Fourteen");

		g.insertEdge("Zero","One");
		g.insertEdge("Zero","Three");
		g.insertEdge("One","Two");
		g.insertEdge("One","Three");
		g.insertEdge("One","Four");
		g.insertEdge("Three","Four");
		g.insertEdge("Five","Six");
		g.insertEdge("Five","Seven");
		g.insertEdge("Five","Eight");
		g.insertEdge("Seven","Eight");
		g.insertEdge("Nine","Ten");
		g.insertEdge("Nine","Eleven");
		g.insertEdge("Nine","Twelve");
		g.insertEdge("Nine","Thirteen");
		g.insertEdge("Ten","Twelve");
		g.insertEdge("Eleven","Thirteen");
		g.insertEdge("Eleven","Fourteen");

		g.dfsTraversal();
		System.out.println();
		g.dfsTraversal_All();
	}
}
