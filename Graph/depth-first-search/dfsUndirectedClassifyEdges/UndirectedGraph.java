/*
Copyright (C) Deepali Srivastava - All Rights Reserved
This code is part of DSA course available on CourseGalaxy.com    
*/

package dfsUndirectedClassifyEdges;

import java.util.Scanner;

public class UndirectedGraph 
{
	public final int MAX_VERTICES = 30;

	int n;           
	int e;           
	boolean [][] adj; 
	Vertex [] vertexList;
   
	private static boolean hasCycle; 
	private static final int INITIAL = 0;
	private static final int VISITED = 1;
	private static final int FINISHED = 2;
	   
	public UndirectedGraph()
	{
	   adj = new boolean[MAX_VERTICES][MAX_VERTICES];
	   vertexList = new Vertex[MAX_VERTICES];
	}
     
	public void dfsTraversal()
	{
	   	 int v;
	   	 for(v=0; v<n; v++) 
	   		vertexList[v].state = INITIAL;
	   	
	   	Scanner scan = new Scanner(System.in);
	  	 System.out.print("Enter starting vertex for Depth First Search : ");
	  	 String s = scan.next();
	 	 dfs(getIndex(s));
	}

	private void dfs(int v)
	{
		  vertexList[v].state = VISITED;

	   	   for(int i=0; i<n; i++)
	   	   {
	   	    	if(isAdjacent(v,i) && vertexList[v].predecessor!=i )
	   	    	{
	   	    		if(vertexList[i].state == INITIAL)
	   	    		{
	   	    			vertexList[i].predecessor = v;
	   	    	   	 	System.out.println("Tree edge (" + vertexList[v] +"," + vertexList[i] + ")");		
	   	    			dfs(i);
	   	    		}
	   	    		else if(vertexList[i].state == VISITED)
	   	   			 	System.out.println("Back edge (" + vertexList[v] +"," + vertexList[i] + ")");
	   	   		}
	   	   	}
	   	   	vertexList[v].state = FINISHED;   	   
	 }   
	
	   public void dfsTraversal_All()
	   {
	   	 int v;
	   	 for(v=0; v<n; v++) 
	   		vertexList[v].state = INITIAL;
	   	
	   	 Scanner scan = new Scanner(System.in);
	  	 System.out.print("Enter starting vertex for Depth First Search : ");
	  	 String s = scan.next();
	 	 dfs(getIndex(s));
	   	 
	   	 for(v=0; v<n; v++)
		 	if(vertexList[v].state == INITIAL)
				dfs(v);
	   }

	   public boolean isCyclic()
	   {
		   	 int v;
		   	 for(v=0; v<n; v++) 
		   		vertexList[v].state = INITIAL;
		   	
		   	 hasCycle=false;
		   	 
		   	 for(v=0; v<n; v++)
			 	if(vertexList[v].state == INITIAL)
			 		dfsC(v);
			 return hasCycle;			   	 
	   }
	     
	   private void dfsC(int v)
	   {
		   vertexList[v].state = VISITED;
		   	
		   	for(int i=0; i<n; i++)
		   	{
		   		if(isAdjacent(v,i) && vertexList[v].predecessor!=i )
		   		{
		   			if(vertexList[i].state == INITIAL)
		   			{
		   				vertexList[i].predecessor = v;
		   				dfsC(i);
		   			}
		   			else if(vertexList[i].state == VISITED)
						hasCycle=true;
		   		}
		   	}
		   	vertexList[v].state = FINISHED;
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
      if(adj[u][v] == true)
    	  System.out.print("Edge already present");
      else  
      {
         adj[u][v]=true;
         adj[v][u]=true;
         e++;
      }
   }
   
}


 