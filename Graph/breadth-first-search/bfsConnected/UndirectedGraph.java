/*
Copyright (C) Deepali Srivastava - All Rights Reserved
This code is part of DSA course available on CourseGalaxy.com    
*/

package bfsConnected;

import java.util.LinkedList;
import java.util.Queue;

public class UndirectedGraph 
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
	   
   	public UndirectedGraph()
	{
	   adj = new boolean[MAX_VERTICES][MAX_VERTICES];
	   vertexList = new Vertex[MAX_VERTICES];
	}
   	
   	public boolean isConnected()
    {
    	 for(int v=0; v<n; v++) 
    		 vertexList[v].state = INITIAL;
    	 
    	 int cN=1;
    	 bfsC(0,cN);
    	 
    	 for(int v=0; v<n; v++)
 		    if(vertexList[v].state == INITIAL)
 		     {
 			   cN++;
 			   bfsC(v,cN);
 		     }
 	    
    	 if(cN==1)
 	     {
 		    System.out.println("Graph is connected");
 		    return true;
 	     }
 	     else
 	     {
 		   System.out.println("Graph is not connected, it has " + cN + " connected components"  );
 		   for(int v=0; v<n; v++)
 			  System.out.println(vertexList[v] + "  " + vertexList[v].componentNumber);
 		   return false;
 	     }
    }
  
   	private void bfsC(int v, int cN)
    {	   
 	       Queue<Integer> qu = new LinkedList<Integer>();
 	       qu.add(v);
 	       vertexList[v].state = WAITING;
    	   while(!qu.isEmpty())
    	   {
    		 v = qu.remove();
    		 vertexList[v].state = VISITED;
    		 vertexList[v].componentNumber = cN;
    		 
    		 for(int i=0; i<n; i++)
    		 {
    			if(isAdjacent(v,i) && vertexList[i].state == INITIAL) 
    			{
    				qu.add(i);
    				vertexList[i].state=WAITING;
    			}
    		 }
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
   
   /* Returns true if edge (s1,s2) exists */
   public boolean edgeExists(String s1, String s2)
   {
	   return isAdjacent(getIndex(s1), getIndex(s2));
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


 