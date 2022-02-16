/*
Copyright (C) Deepali Srivastava - All Rights Reserved
This code is part of DSA course available on CourseGalaxy.com    
*/

package avltree;

public class AVLTree 
{
	private Node root;
	
	static boolean taller;
	static boolean shorter;
	
	public AVLTree()
	{
		root = null;
	}
	
	public boolean isEmpty()
	{
		return (root==null);		
	}
	
	public void display()
	{
		display(root,0);
		System.out.println();
	}
	
	private void display(Node p,int level)
	{
		int i;
		if(p==null)
			return;
	
		display(p.rchild, level+1);
			System.out.println();
	
		for(i=0; i<level; i++)
			System.out.print("    ");
		System.out.print(p.info);
	
		display(p.lchild, level+1);
	}
	
	public void inorder()
	{
		inorder(root);
		System.out.println();
	}

	private void inorder(Node p)
	{
		if(p==null )
			return;
		inorder(p.lchild);
		System.out.print(p.info + " ");
		inorder(p.rchild);
	}

	public void insert(int x)
	{
		root = insert(root,x);
	}
	
	private Node insert(Node p, int x)
	{
		if(p==null)	
		{
			p=new Node(x);
			taller = true;
		}
		else if(x < p.info)	
		{
			p.lchild = insert(p.lchild,x);
			if(taller==true)
				p = insertionLeftSubtreeCheck(p);
		}
		else if(x > p.info)	
		{
			p.rchild = insert(p.rchild,x);
			if(taller==true)
				p = insertionRightSubtreeCheck(p);
		}
		else
		{
			System.out.println(x + " already present in tree");
			taller = false;
		}
		return p;
	}
	
	private Node insertionLeftSubtreeCheck(Node p)
	{
		switch(p.balance)
		{
		 case 0:  //Case L_1 : was balanced  
			p.balance = 1;	// now left heavy 
			break;
		 case -1: //Case L_2 : was right heavy   
			p.balance = 0;	// now balanced 
			taller = false; 
			break;
		 case 1: // Case L_3 : was left heavy    
			p = insertionLeftBalance(p);	//Left Balancing 
			taller = false;
		}
		return p;
	}

	private Node insertionRightSubtreeCheck(Node p)
	{
		switch(p.balance)
		{
		 case 0:   // Case R_1 : was balanced 	
			p.balance = -1;	// now right heavy 
			break;
		 case 1:  // Case R_2 : was left heavy   
			p.balance = 0;	// now balanced  
			taller = false;
			break;
		 case -1: // Case R_3: Right heavy    
			p = insertionRightBalance(p);	// Right Balancing 
			taller = false;
		}
		return p;
	}

	private Node insertionLeftBalance(Node p)
	{
		Node a,b;

		a = p.lchild;
		if(a.balance == 1)  // Case L_3A : Insertion in AL   
		{
			p.balance = 0;
			a.balance = 0;
			p = rotateRight(p);
		}
		else		//  Case L_3B : Insertion in AR  
		{
			b = a.rchild;
			switch(b.balance)
			{
			case 1:		// Case L_3B2 : Insertion in BL  
				p.balance = -1;
				a.balance = 0;
				break;
			case -1:	// Case L_3B2 : Insertion in BR     
				p.balance = 0;
				a.balance = 1;
				break;
			case 0:		// Case L_3B2 : B is the newly inserted node   
				p.balance = 0;
				a.balance = 0;
			}
			b.balance = 0;
			p.lchild = rotateLeft(a);
			p = rotateRight(p);
		}
		return p;
	}

	private Node insertionRightBalance(Node p)
	{
		Node a, b;

		a = p.rchild;
		if(a.balance == -1) // Case R_3A : Insertion in AR   
		{
			p.balance = 0;
			a.balance = 0;
			p = rotateLeft(p);
		}
		else		// Case R_3B : Insertion in AL  
		{
			b = a.lchild;
			switch(b.balance)
			{
			case -1:  // Insertion in BR  
				p.balance = 1;  
				a.balance = 0;
				break;
			case 1:	  // Insertion in BL  
				p.balance = 0;
				a.balance = -1;
				break;
			case 0:	  // B is the newly inserted node  
				p.balance = 0;
				a.balance = 0;
			}
			b.balance = 0;
			p.rchild = rotateRight(a);
			p = rotateLeft(p);
		}
		return p;
	}

	private Node rotateLeft(Node p)
	{
		Node a = p.rchild;	
		p.rchild = a.lchild; 
		a.lchild = p;  
		return a;  
	}

	private Node rotateRight(Node p)
	{
		Node a = p.lchild;	
		p.lchild = a.rchild; 
		a.rchild = p;			
		return a; 
	}
	
	public void delete(int x)
	{
		root = delete(root,x);
	}
		
	private Node delete(Node p, int x)
	{
		Node ch,s;

		if(p==null)
		{
			System.out.println(x + "  not found");
			shorter = false;
			return p;
		}
		if(x < p.info)  //delete from left subtree 
		{
			p.lchild = delete(p.lchild, x);
			if(shorter == true)
				p = deletionLeftSubtreeCheck(p);
		}
		else if(x > p.info) //delete from right subtree 
		{
			p.rchild = delete(p.rchild, x);
			if(shorter==true)
				p = deletionRightSubtreeCheck(p);
		}
		else
		{
			//key to be deleted is found 
			if( p.lchild!=null  &&  p.rchild!=null )  //2 children 
			{
				s=p.rchild;
				while(s.lchild!=null)
					s=s.lchild;
				p.info=s.info;
				p.rchild = delete(p.rchild,s.info);
				if( shorter == true )
					p = deletionRightSubtreeCheck(p);
			}
			else   //1 child or no child 	
			{
				if(p.lchild != null) //only left child 
					ch=p.lchild;
				else  //only right child or no child 
					ch=p.rchild;
				p=ch;
				shorter = true;
			}						
		}
		return p; 
	}
		
	private Node deletionLeftSubtreeCheck(Node p)
	{
		switch(p.balance)
		{
			case 0: // Case L_1 : was balanced         
				p.balance = -1;	// now right heavy   
				shorter = false;
				break;
			case 1: // Case L_2 : was left heavy  	 
				p.balance = 0;	// now balanced  
				break;            
			case -1: // Case L_3 : was right heavy     
				p = deletionRightBalance(p); //Right Balancing 
		}
		return p;
	}

	private Node deletionRightSubtreeCheck(Node p)
	{
		switch(p.balance)
		{
			case 0:	  // Case R_1 : was balanced  		
				p.balance = 1;	// now left heavy  
				shorter = false;
				break;
			case -1:  // Case R_2 : was right heavy  	
				p.balance = 0;	// now balanced  
				break;
			case 1:   // Case R_3 : was left heavy  	
				p = deletionLeftBalance(p);  //Left Balancing 
		}
		return p;
	}
    
	private Node deletionLeftBalance(Node p)
	{
		Node a,b;
		a = p.lchild;
		if( a.balance == 0)  // Case R_3A  
		{
			a.balance = -1;
			shorter = false;
			p = rotateRight(p);
		}
		else if( a.balance == 1 )   // Case R_3B 
		{
			p.balance = 0;
			a.balance = 0;
			p = rotateRight(p);
		}
		else						// Case R_3C  
		{
			b = a.rchild;
			switch(b.balance)
			{
				case 0:				// Case R_3C1  
					p.balance = 0;
					a.balance = 0;
					break;
				case -1:			// Case R_3C2 
					p.balance = 0;		
					a.balance = 1;
					break;
				case 1:			    // Case R_3C3  
					p.balance = -1;	
					a.balance = 0;
			}
			b.balance = 0;			
			p.lchild = rotateLeft(a);
			p = rotateRight(p);
		}
		return p;
	}

	private Node deletionRightBalance(Node p)
	{
		Node a, b;

		a = p.rchild;
		if (a.balance == 0)	// Case L_3A
		{
			a.balance = 1;
			shorter = false;
			p = rotateLeft(p);			
		}
		else if(a.balance == -1 )	// Case L_3B  
		{
			p.balance = 0;
			a.balance = 0;
			p = rotateLeft(p);			
		}
		else						// Case L_3C 
		{
			b = a.lchild;
			switch(b.balance)
			{
				case 0:				// Case L_3C1 
					p.balance = 0;
					a.balance = 0;
					break;
				case 1:				// Case L_3C2  
					p.balance = 0;
					a.balance = -1;
					break;
				case -1:			// Case L_3C3  
					p.balance = 1;
					a.balance = 0;
			}
			b.balance = 0;
			p.rchild = rotateRight(a);
			p = rotateLeft(p);
		}
		return p;
	}
}
