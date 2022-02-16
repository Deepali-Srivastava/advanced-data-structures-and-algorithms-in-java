/*
Copyright (C) Deepali Srivastava - All Rights Reserved
This code is part of DSA course available on CourseGalaxy.com    
*/

package dfsRecursiveTime;

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
		
		g.insertEdge("Zero","One");
		g.insertEdge("Zero","Three"); 
		g.insertEdge("One","Two");
		g.insertEdge("One","Four");
		g.insertEdge("One","Five"); 
		g.insertEdge("Two","Five");
		g.insertEdge("Two","Seven");
		g.insertEdge("Three","Six"); 
		g.insertEdge("Four","Three");
		g.insertEdge("Five","Three");
		g.insertEdge("Five","Six");
		g.insertEdge("Five","Eight"); 
		g.insertEdge("Seven","Eight");
		g.insertEdge("Seven","Ten");
		g.insertEdge("Eight","Eleven"); 
		g.insertEdge("Nine","Six");
		g.insertEdge("Eleven","Nine");
			
		g.dfsTraversal();
	}
}
