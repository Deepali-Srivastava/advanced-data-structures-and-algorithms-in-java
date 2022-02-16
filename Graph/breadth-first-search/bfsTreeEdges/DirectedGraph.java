/*
Copyright (C) Deepali Srivastava - All Rights Reserved
This code is part of DSA course available on CourseGalaxy.com    
*/

package bfsTreeEdges;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DirectedGraph 
{
	   public final int MAX_VERTICES = 30;

	   int n;           
	   int e;           
	   boolean [][] adj; 
	   Vertex [] vertexList;
	   
	   /*constants for different states of a vertex*/
	   private static final int INITIAL = 0;   
	   private static final int WAITING = 1;
	   private static final int VISITED = 2;  	 
	   	   
	   public DirectedGraph()
	   {
		   adj = new boolean[MAX_VERTICES][MAX_VERTICES];
		   vertexList = new Vertex[MAX_VERTICES];
	   }
      
	   public void bfsTreeEdges()
	   {
		   int v;
		   for(v=0; v<n; v++) 
		   	 vertexList[v].state = INITIAL;
		   	
		   Scanner scan = new Scanner(System.in);
		   System.out.print("Enter starting vertex for Breadth First Search : ");
		   String s = scan.next();
		   bfsTree(getIndex(s));
		   	 
		   for(v=0; v<n; v++)
			 if(vertexList[v].state == INITIAL)
				bfsTree(v);
	   }
   
	   private void bfsTree(int v)
	   {	   
		   Queue<Integer> qu = new LinkedList<Integer>();
		   qu.add(v);
		   vertexList[v].state = WAITING;
	   	   while(!qu.isEmpty())
	   	   {
	   		 v = qu.remove();
	   		 vertexList[v].state = VISITED;
	   		
	   		 for(int i=0; i<n; i++)
	   		 {
	   			if(isAdjacent(v,i) && vertexList[i].state == INITIAL) 
	   			{
	   				qu.add(i);
	   				vertexList[i].state=WAITING;
	   				System.out.println("Tree Edge : (" + vertexList[v] + "," + vertexList[i] + ")" );
	   			}
	   		 }
	   	  }
	   	  System.out.println();
	   }

	   public void bfsTraversal_All()
	   {
	   	 int v;
	   	 for(v=0; v<n; v++) 
	   		vertexList[v].state = INITIAL;
	   	
	   	 Scanner scan = new Scanner(System.in);
	   	 System.out.print("Enter starting vertex for Breadth First Search : ");
	   	 String s = scan.next();
	  	 bfs(getIndex(s));
	   	 
	   	 for(v=0; v<n; v++)
		 	if(vertexList[v].state == INITIAL)
				bfs(v);
	   }
	   
	   private void bfs(int v)
	   {	   
		   Queue<Integer> qu = new LinkedList<Integer>();
		   qu.add(v);
		   vertexList[v].state = WAITING;
	   	   
		   while(!qu.isEmpty())
	   	   {
	   		 v = qu.remove();
	   		 System.out.print(vertexList[v] + " ");
	   		 vertexList[v].state = VISITED;
	   		
	   		 for(int i=0; i<n; i++)
	   		 {
	   			if(isAdjacent(v,i) && vertexList[i].state == INITIAL) 
	   			{
	   				qu.add(i);
	   				vertexList[i].state=WAITING;
	   			}
	   		 }
	   	  }
	   	  System.out.println();
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

