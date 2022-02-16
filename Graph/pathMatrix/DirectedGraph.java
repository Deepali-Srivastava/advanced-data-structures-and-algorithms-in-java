/*
Copyright (C) Deepali Srivastava - All Rights Reserved
This code is part of DSA course available on CourseGalaxy.com    
*/

package pathMatrix;


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
   
   public void findPathMatrix()
   {
	   int [][] x,adjp,temp;
	   x = new int[n][n];
	   adjp = new int[n][n];
	   temp = new int[n][n];
			   
	   for(int i=0; i<n; i++)
		  for(int j=0; j<n; j++)
			  x[i][j]= adjp[i][j] = adj[i][j] ? 1 : 0 ;
	   
	   for(int p=2; p<=n; p++)
	   {
		   for(int i=0; i<n; i++)
			  for(int j=0; j<n; j++)
			  {
					temp[i][j] = 0;
					for(int k=0; k<n; k++)
						temp[i][j] = temp[i][j] + adjp[i][k] * (adj[k][j]?1:0);
			  }
		   	
		   for(int i=0; i<n; i++)
			  for(int j=0; j<n; j++)
				  adjp[i][j] = temp[i][j];
   		   
		   for(int i=0; i<n; i++)
			   for(int j=0; j<n; j++)
		  		  x[i][j] = x[i][j] + adjp[i][j];
	   }
	   
	   //Display X
	   for(int i=0; i<n; i++)
	      {
	         for (int j=0; j<n; j++)
	            System.out.print(x[i][j] + " ");
	         System.out.println();
	      }
	      System.out.println();      
	  
	   boolean [][] path;
	   path = new boolean[n][n];
	   for(int i=0; i<n; i++)
		   for(int j=0; j<n; j++)
			   	if (x[i][j] == 0 )
					path[i][j] = false;
				else
					path[i][j] = true;	   	
		   
	   //Display Path Matrix
	   for(int i=0; i<n; i++)
	      {
	         for (int j=0; j<n; j++)
	            if (path[i][j]) 
	               System.out.print("1 ");
	            else
	               System.out.print("0 ");
	         System.out.println();
	      }
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

