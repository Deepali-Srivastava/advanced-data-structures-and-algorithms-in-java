/*
Copyright (C) Deepali Srivastava - All Rights Reserved
This code is part of DSA course available on CourseGalaxy.com    
*/

package dfsRecursiveTime;

public class Vertex 
{
	String name;
	int state;
	int discoveryTime;
	int finishingTime;
	
	Vertex(String name)
	{
		this.name = name;
	}
	public String toString()
	{
	     return name;
	}
}
