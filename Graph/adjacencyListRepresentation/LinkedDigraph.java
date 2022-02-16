/*
Copyright (C) Deepali Srivastava - All Rights Reserved
This code is part of DSA course available on CourseGalaxy.com    
*/

package adjacencyListRepresentation;

public class LinkedDigraph 
{
	VertexNode start;
	int n;
	int e;
	
	public int vertices()
    {
		return n;
	}

	public int edges()
    {
		return e;
	}
	
	public void insertVertex(String s)
	{
		VertexNode temp = new VertexNode(s);
		if(start==null)
			start=temp;
		else
		{
			VertexNode p=start;
			while(p.nextVertex!=null)
			{
				if(p.name.equals(s))
				{
					System.out.println("Vertex already present");
					return;
				}
				p=p.nextVertex;
			}
			if(p.name.equals(s))
			{
				System.out.println("Vertex already present");
				return;
			}	
			p.nextVertex=temp;
		}
		n++;
	}
	
	public void deleteVertex(String s)
	{
		deletefromEdgeLists(s);
		deletefromVertexList(s);
	}

	/*Delete incoming edges*/
	private void deletefromEdgeLists(String s)
	{
		for(VertexNode p=start;  p!=null; p=p.nextVertex)
		{
			if(p.firstEdge==null)
				continue;
			
			if(p.firstEdge.endVertex.name.equals(s))
			{
				p.firstEdge = p.firstEdge.nextEdge;
				e--;
			}
			else
			{
				EdgeNode q=p.firstEdge; 
				while(q.nextEdge!=null)
				{
					if(q.nextEdge.endVertex.name.equals(s)) 
					{
						q.nextEdge = q.nextEdge.nextEdge;
						e--;
						break;
					}
					q=q.nextEdge;
				}
			}
		}
	}


	private void deletefromVertexList(String s)
	{
		if(start==null) 
		{
			System.out.println("No vertices to be deleted");
			return;
		}
	
		if(start.name.equals(s)) /* Vertex to be deleted is first vertex of list*/
		{
			for(EdgeNode q=start.firstEdge; q!=null; q=q.nextEdge)  
				e--;
			start=start.nextVertex;   
			n--;
		}
		else 
		{
	        VertexNode p=start;
			while(p.nextVertex!=null)
			{
				if(p.nextVertex.name.equals(s))     
				   break;		
				p=p.nextVertex;  
			}
			
			if(p.nextVertex==null)
			{
				System.out.println("Vertex not found");
				return;
			}
			else
			{
				for(EdgeNode q=p.nextVertex.firstEdge; q!=null; q=q.nextEdge)
						e--;
				p.nextVertex = p.nextVertex.nextVertex;
				n--;
			}
		}
	}
	
	private VertexNode findVertex(String s)
	{
		VertexNode p=start;
		while(p!=null)
		{
			if(p.name.equals(s))
				return p;
			p=p.nextVertex;
		}
		return null;
	}/*End of findVertex()*/

	/*Insert an edge (s1,s2) */
	public void insertEdge(String s1, String s2)
	{
	    if(s1.equals(s2))
	    {
	    	System.out.println("Inavlid Edge : Start and end vertices are same");
	    	return;
	    }
		
	    VertexNode u = findVertex(s1);
		VertexNode v = findVertex(s2);

		if(u==null)
		{
			System.out.println("Start vertex not present, first insert vertex " + s1);
			return;
		}
		if(v==null)
		{
			System.out.println("End vertex not present, first insert vertex " + s2);
			return;
		}
		
		EdgeNode temp = new EdgeNode(v);
		if(u.firstEdge==null)   
		{
			u.firstEdge=temp;
			e++;
		}
		else
		{
			EdgeNode p=u.firstEdge;
			while(p.nextEdge!=null)
			{	
				if(p.endVertex.name.equals(s2))
				{
					System.out.println("Edge present");
					return;
				}
				p=p.nextEdge;
			}
			if(p.endVertex.name.equals(s2))
			{
				System.out.println("Edge present");
				return;
			}
			p.nextEdge=temp;
			e++;
		}
	}

	/* Delete the edge (s1,s2) */
	public void deleteEdge(String s1, String s2)
	{
		VertexNode u = findVertex(s1);

		if(u==null)
		{
			System.out.println("Start vertex not present");
			return;
		}
		if(u.firstEdge == null)
		{
			System.out.println("Edge not present");
			return;
		}
		    
		if(u.firstEdge.endVertex.name.equals(s2))
		{
			u.firstEdge = u.firstEdge.nextEdge;
			e--;
			return;
		}
		EdgeNode q = u.firstEdge;
		while(q.nextEdge != null)
		{
			if(q.nextEdge.endVertex.name.equals(s2))  
			{
				q.nextEdge = q.nextEdge.nextEdge;
				e--;
				return;
			}
			q=q.nextEdge;
		}
		System.out.println("Edge not present");
	}	
	
	public void display()
	{
		EdgeNode q;
		for(VertexNode p=start; p!=null; p=p.nextVertex)
		{
			System.out.print(p + "->");
			for(q=p.firstEdge; q!=null; q=q.nextEdge)
				System.out.print(" " + q.endVertex);
			System.out.println();
		 }
	}

	/* Returns true if s2 is adjacent to s1, i.e. if edge (s1,s2) exists */
	   public boolean edgeExists(String s1, String s2)
	   {
		   VertexNode u = findVertex(s1);
		   EdgeNode q=u.firstEdge;
		   while(q!=null)
		   {
			   if(q.endVertex.name.equals(s2))
				   return true;
			   q=q.nextEdge;
		   }
			return false;	  
	   }
	/*Returns number of edges going out from vertex s*/
	   public int outDegree(String s)
	   {
	      VertexNode u = findVertex(s);
	      if(u==null)
		  	  throw new IllegalArgumentException("Vertex not present");
		
	      int out=0;
	      EdgeNode q = u.firstEdge;
	      while(q!=null)
	      {	  
	          q=q.nextEdge;  
	    	  out++;
	      }
	      return out;
	   }
	   
	   /*Returns number of edges coming to vertex s*/
	   public int inDegree(String s)
	   {
	      VertexNode u = findVertex(s);
	      if(u==null)
		  	  throw new IllegalArgumentException("Vertex not present");
		
		  int in=0;
	      for(VertexNode p=start; p!=null; p=p.nextVertex)
	      {
	    	  for(EdgeNode q=p.firstEdge; q!=null; q=q.nextEdge)
	    	  	  if(q.endVertex.name.equals(s))
	    			  in++;
	      }
	      return in;
	  }
}
