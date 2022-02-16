/*
Copyright (C) Deepali Srivastava - All Rights Reserved
This code is part of DSA course available on CourseGalaxy.com    
*/

package bfsConnected;

public class Demo2 
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
		g.insertVertex("Fifteen");
		g.insertVertex("Sixteen");

		
		g.insertEdge("Zero","One");
		g.insertEdge("Zero","Two");
		g.insertEdge("Zero","Three");
		g.insertEdge("One","Three");
		g.insertEdge("Two","Five");
		g.insertEdge("Three","Four");
		g.insertEdge("Four","Five");
		g.insertEdge("Six","Seven");
		g.insertEdge("Six","Eight");
		g.insertEdge("Seven","Ten");
		g.insertEdge("Eight","Nine");
		g.insertEdge("Nine","Ten");
		g.insertEdge("Eleven","Twelve");
		g.insertEdge("Eleven","Fourteen");
		g.insertEdge("Eleven","Fifteen");
		g.insertEdge("Twelve","Thirteen");
		g.insertEdge("Thirteen","Fourteen");
		g.insertEdge("Fourteen","Sixteen");

		g.isConnected();
	}
}
