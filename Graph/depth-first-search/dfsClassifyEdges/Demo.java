/*
Copyright (C) Deepali Srivastava - All Rights Reserved
This code is part of DSA course available on CourseGalaxy.com    
*/

package dfsClassifyEdges;

public class Demo 
{
	public static void main(String [] args)
	{
		DirectedGraph g = new DirectedGraph();

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
		g.insertVertex("Fifteen");
		g.insertVertex("Sixteen");
		
		g.insertEdge("Zero","One");
		g.insertEdge("Zero","Two");
		g.insertEdge("Zero","Four");
		g.insertEdge("One","Three");
		g.insertEdge("Two","Three");
		g.insertEdge("Two","Four");
		g.insertEdge("Two","Five");
		//g.insertEdge("Three","Zero");
		g.insertEdge("Four","Five");
		g.insertEdge("Five","Three");
		g.insertEdge("Six","One");
		g.insertEdge("Six","Seven");
		g.insertEdge("Six","Eight");
		g.insertEdge("Six","Nine");
		g.insertEdge("Seven","Nine");
		g.insertEdge("Eight","Ten");
		g.insertEdge("Nine","Five");
		//g.insertEdge("Ten","Six");
		g.insertEdge("Ten","Nine");
		g.insertEdge("Eleven","Eight");
		g.insertEdge("Eleven","Thirteen");
		g.insertEdge("Eleven","Fifteen");
		//g.insertEdge("Twelve","Eleven");
		g.insertEdge("Thirteen","Eight");
		g.insertEdge("Thirteen","Fourteen");
		g.insertEdge("Thirteen","Fifteen");
		g.insertEdge("Thirteen","Sixteen");
		g.insertEdge("Fourteen","Sixteen");
		g.insertEdge("Fifteen","Twelve");
		g.insertEdge("Fifteen","Sixteen");

		g.dfsTraversal_All();
		
		if(g.isCyclic())
			System.out.println("Graph is Cyclic");
		else
			System.out.println("Graph is Acylic");
	}
}
