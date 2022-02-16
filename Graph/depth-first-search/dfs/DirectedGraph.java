/*
Copyright (C) Deepali Srivastava - All Rights Reserved
This code is part of DSA course available on CourseGalaxy.com    
*/

package dfs;

import java.util.Scanner;
import java.util.Stack;

public class DirectedGraph 
{
	public final int MAX_VERTICES = 30;

	int n;           
	int e;           
	boolean [][] adj; 
	Vertex [] vertexList;
	
	private static final int INITIAL = 0;
	private static final int VISITED = 1;
         
   public DirectedGraph()
   {
	   adj = new boolean[MAX_VERTICES][MAX_VERTICES];
	   vertexList = new Vertex[MAX_VERTICES];
   }
   
   public void dfsTraversal()
   {
   	  for(int v=0; v<n; v++) 
   		vertexList[v].state = INITIAL;
   	
   	 Scanner scan = new Scanner(System.in);
   	 System.out.print("Enter starting vertex for Depth First Search : ");
   	 String s = scan.next();
  	 dfs(getIndex(s));
   }

   private void dfs(int v)
   {	   
	   Stack<Integer> st = new Stack<Integer>();
	   st.push(v);
	   while(!st.isEmpty())
	   {
			v = st.pop();
			if(vertexList[v].state==INITIAL)
			{
				System.out.print(vertexList[v] + " ");
				vertexList[v].state=VISITED;
			}
			for(int i=n-1; i>=0; i--)
			{
				if(isAdjacent(v,i) && vertexList[i].state==INITIAL)
					st.push(i);
			}
		}
   	    System.out.println();
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

