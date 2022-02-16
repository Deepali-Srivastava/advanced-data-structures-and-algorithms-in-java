/*
Copyright (C) Deepali Srivastava - All Rights Reserved
This code is part of DSA course available on CourseGalaxy.com    
*/

package avltree;

public class Node 
{
	Node lchild;
	int info;
	Node rchild;
	int balance;
	
	public Node(int i)
	{
		info = i;
		balance = 0;
		lchild = null;
		rchild = null;
	}
}
