/*
Copyright (C) Deepali Srivastava - All Rights Reserved
This code is part of DSA course available on CourseGalaxy.com    
*/

package kruskal;

public class Demo 
{
	public static void main(String [] args)
	{
		UndirectedWeightedGraph g = new UndirectedWeightedGraph();

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

		g.insertEdge("Zero","One", 19);
		g.insertEdge("Zero","Three", 14);
		g.insertEdge("Zero","Four", 12); 
		g.insertEdge("One","Two", 20); 
		g.insertEdge("One","Four", 18); 
		g.insertEdge("Two","Four", 17); 
		g.insertEdge("Two","Five", 15);
		g.insertEdge("Two","Nine", 29);
		g.insertEdge("Three","Four", 13); 
		g.insertEdge("Three","Six", 28); 
		g.insertEdge("Four","Five", 16); 
		g.insertEdge("Four","Six", 21); 
		g.insertEdge("Four","Seven", 22);
		g.insertEdge("Four","Eight", 24);
		g.insertEdge("Five","Eight", 26); 
		g.insertEdge("Five","Nine", 27); 
		g.insertEdge("Six","Seven", 23); 
		g.insertEdge("Seven","Eight", 30);
		g.insertEdge("Eight","Nine", 35);
		
		g.kruskals();
	}
}
