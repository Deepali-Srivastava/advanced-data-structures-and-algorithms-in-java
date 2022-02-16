/*
Copyright (C) Deepali Srivastava - All Rights Reserved
This code is part of DSA course available on CourseGalaxy.com    
*/

package adjacencyListRepresentation;

public class EdgeNode 
{
	VertexNode endVertex;  
	EdgeNode nextEdge; 
	
	public EdgeNode(VertexNode v)
	{
		endVertex = v;
	}
}
