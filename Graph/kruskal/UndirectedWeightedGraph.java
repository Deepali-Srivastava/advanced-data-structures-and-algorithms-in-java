/*
Copyright (C) Deepali Srivastava - All Rights Reserved
This code is part of DSA course available on CourseGalaxy.com    
*/

package kruskal;

import java.util.PriorityQueue;

public class UndirectedWeightedGraph 
{
	public final int MAX_VERTICES = 30;

	int n;           
	int e;               
    int [][] adj; 
    Vertex [] vertexList;
        
    private static final int NIL= -1;
        
    public UndirectedWeightedGraph()
    {
      adj = new int[MAX_VERTICES][MAX_VERTICES];
      vertexList = new Vertex[MAX_VERTICES];
    }
   
    public void kruskals()
    {
 	   PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
 	   
 	   int u,v;
 	   for(u=0; u<n; u++)
 		   for(v=0; v<u; v++)
 		   {
 			   if(adj[u][v]!=0)
 				   pq.add(new Edge(u,v,adj[u][v]));
 		   }
 	   
 	   for(v=0; v<n; v++)
 	   		vertexList[v].father = NIL;
 	   
 	   int v1,v2,r1=NIL,r2=NIL;
	   int edgesInTree=0;  
	   int wtTree=0;
	   
 	   while(!pq.isEmpty() && edgesInTree<n-1)
 	   {
 		    Edge edge = pq.remove();
 		    v1=edge.u;
 		    v2=edge.v;
 	   		
 	   		v=v1;
 		    while(vertexList[v].father!=NIL)
 	   			v=vertexList[v].father;
 	   		r1=v;
 		    
 	   		v=v2;
 		    while(vertexList[v].father!=NIL)
 		    	v=vertexList[v].father;
 			r2=v;

 	   		if(r1!=r2)  /*Edge (v1,v2) is included*/
 	   		{
 	   			edgesInTree++;
 	   		    System.out.println(vertexList[v1] + ","  + vertexList[v2] ); 
 	   	    	wtTree += edge.wt;
 	   	        vertexList[r2].father=r1;
 	   		}
 	   	}
 	  
 	   	if(edgesInTree < n-1)
 	   	  throw new RuntimeException("Graph is not connected, no spanning tree possible\n");
 	  	   	
 	   	System.out.println("Weight of Minimum Spanning Tree is " + wtTree);
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
   public void insertEdge(String s1, String s2, int wt)
   {
	  int u = getIndex(s1);
	  int v = getIndex(s2);
      if(adj[u][v] !=0 )
    	  System.out.print("Edge already present");
      else  
      {
         adj[u][v]=wt;
         adj[v][u]=wt;
         e++;
      }
   }
   
}


 