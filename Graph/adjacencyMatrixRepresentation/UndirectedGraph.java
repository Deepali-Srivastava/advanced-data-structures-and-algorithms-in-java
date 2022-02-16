/*
Copyright (C) Deepali Srivastava - All Rights Reserved
This code is part of DSA course available on CourseGalaxy.com    
*/

package adjacencyMatrixRepresentation;

/* Adjacency matrix representation of an unweighted undirected graph */

public class UndirectedGraph 
{
	public final int MAX_VERTICES = 30;

	int n;           
	int e;           
	boolean [][] adj; 
	Vertex [] vertexList;
   
	public UndirectedGraph()
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
      for (int i=0; i<n; i++)
      {
         for (int j=0; j<n; j++)
            if (adj[i][j]) 
               System.out.print("1 ");
            else
               System.out.print("0 ");
         System.out.println();
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
   
   /* Delete the edge (s1,s2) */
   public void deleteEdge(String s1, String s2)
   {
	   int u = getIndex(s1);
	   int v = getIndex(s2);
	  if(adj[u][v]==false)
		  System.out.println("Edge not present");
	  else	  
	  {
         adj[u][v]=false;
         adj[v][u]=false;         
         e--;
      }
   }
      
   public int degree(String s)
   {
	  int u = getIndex(s); 
	   
      int deg=0;
      for(int v=0; v<n; v++)
         if (adj[u][v])
            deg++;
      return deg;
   }
 }


 