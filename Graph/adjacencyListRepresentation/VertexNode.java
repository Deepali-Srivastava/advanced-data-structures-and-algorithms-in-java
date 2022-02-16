/*
Copyright (C) Deepali Srivastava - All Rights Reserved
This code is part of DSA course available on CourseGalaxy.com    
*/

package adjacencyListRepresentation;

public class VertexNode 
{
	String name; 
	VertexNode nextVertex;  
	EdgeNode firstEdge;  
	
	public VertexNode(String s)
	{
		name=s;
	}
	public String toString()
	{
	     return name;
	}
}

