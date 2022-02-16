/*
Copyright (C) Deepali Srivastava - All Rights Reserved
This code is part of DSA course available on CourseGalaxy.com    
*/

package adjacencyMatrixRepresentation;

/* Adjacency matrix representation of an unweighted directed graph */

public class DirectedGraph 
{
	public final int MAX_VERTICES = 30;

	int n;           
	int e;           
	boolean [][] adj; 
	Vertex [] vertexList;
         
   public DirectedGraph()
   {
	   adj = new boolean[MAX_VERTICES][MAX_VERTICES];
	   vertexList = new Vertex[MAX_VERTICES];
      // By default n=0, e=0 
      // By default adj[u][v]=false
   }
   
   public int vertices()
   {  
	   return n; 
   }

   public int edges()
   {
	   return e;
   }
   
   public void display()
   {
      for(int i=0; i<n; i++)
      {
     	  for(int j=0; j<n; j++)
            if (adj[i][j]) 
               System.out.print("1 ");
            else
               System.out.print("0 ");
          System.out.println();
      }
   }

   public void insertVertex(String name)
   {  
	   vertexList[n++] = new Vertex(name);  
   }
      
   private int getIndex(String s)
   {
	   for(int i=0; i<n; i++)
	      if(s.equals(vertexList[i].name))
	   		   return i;
	   throw new RuntimeException("Invalid Vertex");
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
   
   /* Delete the edge (s1,s2) */
   public void deleteEdge(String s1, String s2)
   {
	   int u = getIndex(s1);
	   int v = getIndex(s2);
   
	   if(adj[u][v]==false)
		  System.out.println("Edge not present in the graph");
	   else	  
       {
          adj[u][v] = false;
          e--;
       }
   }
         
   /*Returns number of edges going out from a vertex */
   public int outdegree(String s)
   {
	  int u = getIndex(s); 
   
	  int out=0;
      for(int v=0; v<n; v++)
         if(adj[u][v])
            out++;

      return out;
   }
   
   /*Returns number of edges coming to a vertex */
   public int indegree(String s)
   {
      int u = getIndex(s);
   
      int in=0;
      for(int v=0; v<n; v++)
         if (adj[v][u])
            in++;
      return in;
   }
}

