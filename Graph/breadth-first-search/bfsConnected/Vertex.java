/*
Copyright (C) Deepali Srivastava - All Rights Reserved
This code is part of DSA course available on CourseGalaxy.com    
*/

package bfsConnected;

public class Vertex 
{
	String name;
	int state;
	int componentNumber;
	
	Vertex(String name)
	{
		this.name = name;
	}
	public String toString()
	{
	     return name;
	}
}
