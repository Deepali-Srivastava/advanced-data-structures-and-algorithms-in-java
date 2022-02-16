/*
Copyright (C) Deepali Srivastava - All Rights Reserved
This code is part of DSA course available on CourseGalaxy.com    
*/

package prims;

public class Vertex 
{
	String name;
	int status;
	int predecessor;
	int length;
		
	Vertex(String name)
	{
		this.name = name;
	}
	public String toString()
	{
	     return name;
	}
}
