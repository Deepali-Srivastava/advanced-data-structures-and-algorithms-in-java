/*
Copyright (C) Deepali Srivastava - All Rights Reserved
This code is part of DSA course available on CourseGalaxy.com    
*/

package Dijkstras;

public class DirectedWeightedGraph 
{
   public final int MAX_VERTICES = 30;	
   
   int n;           
   int e;           
   int [][] adj; 
   Vertex [] vertexList;
  
   private static final int TEMPORARY = 1;
   private static final int PERMANENT = 2;
   private static final int NIL = -1;
   private static final int INFINITY = 99999; 
   
   public DirectedWeightedGraph()
   {
        adj = new int [MAX_VERTICES][MAX_VERTICES];
        vertexList = new Vertex[MAX_VERTICES];
   }
   
   private void dijkstra(int s)
   {
   	   int v,c;
   	
   	   for(v=0; v<n; v++)
   	   { 
   		  vertexList[v].status = TEMPORARY;
   		  vertexList[v].pathLength = INFINITY;
   		  vertexList[v].predecessor =  NIL;
   	   }
   	
   	   vertexList[s].pathLength = 0;
   	   
   	   while(true)
   	   {
   		 c=tempVertexMinPL();
   	
   		 if(c==NIL)
   			return;
   		
   		 vertexList[c].status = PERMANENT;

   		 for(v=0; v<n; v++)
   		 {
   			if(isAdjacent(c,v) && vertexList[v].status == TEMPORARY)
   				if( vertexList[c].pathLength + adj[c][v] < vertexList[v].pathLength )
   				{	
   					vertexList[v].predecessor = c;  
   					vertexList[v].pathLength = vertexList[c].pathLength + adj[c][v];    
   				}
   		  }
   	   }
   }
   
   private int tempVertexMinPL( )
   {
	   int min=INFINITY;
	   int x=NIL;  
	   for(int v=0; v<n; v++)
	   {
		   if(vertexList[v].status == TEMPORARY && vertexList[v].pathLength < min)
		   {
			   min=vertexList[v].pathLength;
			   x=v;
		   }
	   }
	   return x;
   }
   
   public void findPaths(String source)
   {
	   int s = getIndex(source);
	   
	   dijkstra(s);
	   
	   System.out.println("Source Vertex : " + source + "\n");
	   for(int v=0; v<n; v++)
	   {
		   System.out.println("Destination Vertex : " + vertexList[v]);
		   if( vertexList[v].pathLength == INFINITY )
	            System.out.println("There is no path from " + source + " to vertex " + vertexList[v] + "\n");
		   else
				findPath(s,v);
	   }
   }
   
   private void findPath(int s, int v)
   {
   	    int i,u;
   	    int [] path = new int[n]; 
   	    int sd=0;	     
   	    int count=0;		    
   	   	
   	    while(v!=s)
   	    {
   		   count++;
   		   path[count] = v;
   	       u = vertexList[v].predecessor;
   		   sd += adj[u][v];
   		   v=u;	
   	     }
   	     count++;
   	     path[count]=s;

   	    System.out.print("Shortest Path is : ");
   	    for(i=count; i>=1; i--)	
   		   System.out.print(path[i] + " ");
   	    System.out.println("\n Shortest distance is : " + sd + "\n");
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
	   return (adj[u][v]!=0);
   }
   
   /*Insert an edge (s1,s2) */
   public void insertEdge(String s1, String s2, int wt)
   {
	   int u = getIndex(s1);
	   int v = getIndex(s2);
	   if(u==v)
	      throw new IllegalArgumentException("Not a valid edge");
      
       if(adj[u][v] !=0 )
    	  System.out.print("Edge already present");
       else  
       {
         adj[u][v]=wt;
         e++;
       }
   }
         
}      
   

 
   