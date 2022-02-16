/*
Copyright (C) Deepali Srivastava - All Rights Reserved
This code is part of DSA course available on CourseGalaxy.com    
*/

package bfsShortestPaths;

public class Vertex 
{
	String name;
	int state;
	int predecessor;
	int distance;
	
	Vertex(String name)
	{
		this.name = name;
	}
	public String toString()
	{
	     return name;
	}
}
