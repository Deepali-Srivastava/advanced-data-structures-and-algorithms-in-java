/*
Copyright (C) Deepali Srivastava - All Rights Reserved
This code is part of DSA course available on CourseGalaxy.com    
*/

package Dijkstras;

public class Vertex 
{
	String name;
	int status;
	int predecessor;
	int pathLength;
		
	Vertex(String name)
	{
		this.name = name;
	}
	public String toString()
	{
	     return name;
	}
}
