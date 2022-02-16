/*
Copyright (C) Deepali Srivastava - All Rights Reserved
This code is part of DSA course available on CourseGalaxy.com    
*/

package warshalls;

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
   }
   
   public void Warshalls()
   {
	   boolean [][] p = new boolean[n][n];
	   
	   for(int i=0; i<n; i++)
	       for(int j=0; j<n; j++)
	            p[i][j] = adj[i][j];
	      
	   for(int k=0; k<n; k++)
	   {
			for(int i=0; i<n; i++)
			  for(int j=0; j<n; j++)
			      p[i][j] = ( p[i][j] || ( p[i][k] && p[k][j] ) );
	   }
	   
	   for(int i=0; i<n; i++)
	   {
	        for (int j=0; j<n; j++)
	           if (p[i][j]) 
	              System.out.print("1 ");
	           else
	              System.out.print("0 ");
	        System.out.println();
	   }
	   System.out.println();  
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

