/*
Copyright (C) Deepali Srivastava - All Rights Reserved
This code is part of DSA course available on CourseGalaxy.com    
*/

package bfsShortestPaths;

import java.util.LinkedList;
import java.util.Queue;

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
	   
	   private static final int NIL = -1;
	   private static final int INFINITY = 99999; 
	   
	   public DirectedGraph()
	   {
		   adj = new boolean[MAX_VERTICES][MAX_VERTICES];
		   vertexList = new Vertex[MAX_VERTICES];
	   }
      
	   public void findShortestPath(String s)
	   {
		   for(int v=0; v<n; v++) 
		   {	
			   vertexList[v].state = INITIAL;
			   vertexList[v].predecessor = NIL;
			   vertexList[v].distance = INFINITY;
		   }
		   
		   bfs(getIndex(s));
		   
		   for(int v=0; v<n; v++)
		   {
			   if(vertexList[v].distance == INFINITY)
		        	System.out.println("No path from vertex " + s + " to vertex " + vertexList[v]);
		       else	
		       {
		    	   System.out.println("Shortest distance from vertex " + s + " to vertex " + vertexList[v] + 
		    			                                             " is " +  vertexList[v].distance);
		           /*Store the full path in array path*/
		    	   int [] path = new int[n];
		    	   int count=0;
		    	   int x,y=v;
		    	   while(y!=NIL)
		    	   {
		    		   count++;
		    		   path[count]=y;
		    		   x = vertexList[y].predecessor;
		    		   y = x;	
		    	   }
		    	   System.out.print("Shortest Path is : ");
		    	   int i;
		    	   for(i=count; i>1; i--)	
		    		   System.out.print(vertexList[path[i]]+"->");
		    	   System.out.println(vertexList[path[i]]);
		       }
		   }
	   } 
	   
	   private void bfs(int v)
	   {	   
		   Queue<Integer> qu = new LinkedList<Integer>();
		   qu.add(v);
		   vertexList[v].state = WAITING;
		   vertexList[v].distance = 0;
		   vertexList[v].predecessor = NIL;
		   
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
	   				vertexList[i].predecessor = v;
	   				vertexList[i].distance = vertexList[v].distance + 1;
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

