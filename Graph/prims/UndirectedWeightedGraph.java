/*
Copyright (C) Deepali Srivastava - All Rights Reserved
This code is part of DSA course available on CourseGalaxy.com    
*/

package prims;

public class UndirectedWeightedGraph 
{
	public final int MAX_VERTICES = 30;

	int n;           
	int e;               
    int [][] adj; 
    Vertex [] vertexList;
   
    private static final int TEMPORARY = 1;
    private static final int PERMANENT = 2;
    private static final int NIL= -1;
    private static final int INFINITY = 99999; 
    
   public UndirectedWeightedGraph()
   {
      adj = new int[MAX_VERTICES][MAX_VERTICES];
      vertexList = new Vertex[MAX_VERTICES];
   }
   
   public void Prims()
   {	
	    int c,v;
	    
	    int edgesInTree=0;
	    int wtTree=0;
   			    
   		for(v=0; v<n; v++)
   		{
   			vertexList[v].status = TEMPORARY;
   			vertexList[v].length = INFINITY;
   			vertexList[v].predecessor = NIL;
   		}

   		int root=0;
   		vertexList[root].length = 0;
   		
   		while(true)
   		{
   			c = tempVertexMinL();
   	
   			if(c == NIL) 
   			{
   				if(edgesInTree == n-1) 
   				{
   					System.out.println("Weight of minimum spanning tree is " + wtTree);
   					return;
   				}
   				else 		
   					throw new RuntimeException("Graph is not connected, Spanning tree not possible");
   			}
   		
   			vertexList[c].status = PERMANENT;
   			/* Include edge ( vertexList[c].predecessor,c ) in the tree*/ 
   			if(c!=root)
   			{
   				edgesInTree++;
   				System.out.println("(" + vertexList[c].predecessor + "," + c + ")");
   				wtTree = wtTree + adj[vertexList[c].predecessor][c];
   			}
   			
   			for(v=0; v<n; v++)
   				if(isAdjacent(c,v) && vertexList[v].status == TEMPORARY)
   					if(adj[c][v] < vertexList[v].length)
   					{
   						vertexList[v].length = adj[c][v];
   						vertexList[v].predecessor = c;
   					}
   		}/*End of while*/
 }

   int tempVertexMinL()
   {
 	 
 	 int min = INFINITY;
 	 int x = NIL;
 	
 	 for(int v=0; v<n; v++)
 	 {
 		if(vertexList[v].status == TEMPORARY && vertexList[v].length < min)
 		{
 			min=vertexList[v].length;
 			x=v;
 		}
 	 }
 	 return x;
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