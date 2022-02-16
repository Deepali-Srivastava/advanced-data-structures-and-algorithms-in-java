/*
Copyright (C) Deepali Srivastava - All Rights Reserved
This code is part of DSA course available on CourseGalaxy.com    
*/

package dfsRecursiveTime;

import java.util.Scanner;

public class DirectedGraph 
{
	public final int MAX_VERTICES = 30;

	int n;           
	int e;           
	boolean [][] adj; 
	Vertex [] vertexList;
	
	private static int time;
	private static final int INITIAL = 0;
	private static final int VISITED = 1;
	private static final int FINISHED = 2;
         
   public DirectedGraph()
   {
	   adj = new boolean[MAX_VERTICES][MAX_VERTICES];
	   vertexList = new Vertex[MAX_VERTICES];
   }
   
   public void dfsTraversal()
   {
   	 int v;
   	 for(v=0; v<n; v++) 
   		vertexList[v].state = INITIAL;
   	
   	 time=0;
   	 Scanner scan = new Scanner(System.in);
   	 System.out.println("Enter starting vertex for Depth First Search : ");
   	 String s = scan.next();
  	 dfs(getIndex(s));
  	 
  	for(v=0; v<n; v++)
  	{
  		System.out.println("Vertex " + vertexList[v]);
  		System.out.print(" Discovery time - " + vertexList[v].discoveryTime);
   		System.out.println(" Finishing time - " + vertexList[v].finishingTime);
  	}
  }

   private void dfs(int v)
   {
   	vertexList[v].state = VISITED;
   	vertexList[v].discoveryTime = ++time;

   	for(int i=0; i<n; i++)
   	{
   		if(isAdjacent(v,i) && vertexList[i].state == INITIAL)
   				dfs(i);
   	}
   	vertexList[v].state = FINISHED;
   	vertexList[v].finishingTime = ++time;
   }

   public void dfsTraversal_All()
   {
   	 int v;
   	 for(v=0; v<n; v++) 
   		vertexList[v].state = INITIAL;
   	
   	 time=0;
   	 Scanner scan = new Scanner(System.in);
   	 System.out.println("Enter starting vertex for Depth First Search : ");
   	 String s = scan.next();
 	 dfs(getIndex(s));
   	
 	 for(v=0; v<n; v++)
	 	if(vertexList[v].state == INITIAL)
			dfs(v);
 	 
 	for(v=0; v<n; v++)
 	{
 		System.out.println("Vertex " + vertexList[v]);
 		System.out.print(" Discovery time - " + vertexList[v].discoveryTime);
   		System.out.println(" Finishing time - " + vertexList[v].finishingTime);
 	}
   }

   
   private int getIndex(String s)
   {
	   for(int i=0; i<n; i++)
	      if(s.equals(vertexList[i].name))
	   		   return i;
	   throw new RuntimeException("Invalid Vertex");
   }
   
   public void insertVertex(String name)
   {  
	   vertexList[n++] = new Vertex(name);  
   }
      
      
   
   private boolean isAdjacent(int u, int v)
   {
	   return adj[u][v];
   }
   
   /*Insert an edge (s1,s2) */
   public void insertEdge(String s1, String s2)
   {
	  int u = getIndex(s1);
	  int v = getIndex(s2);
      if(u==v)
         throw new IllegalArgumentException("Not a valid edge");
      if(adj[u][v] == true)
    	  System.out.print("Edge already present");
      else  
      {
         adj[u][v]=true;
         e++;
      }
   }
   
   
}

