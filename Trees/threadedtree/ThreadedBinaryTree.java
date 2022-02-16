/*
Copyright (C) Deepali Srivastava - All Rights Reserved
This code is part of DSA course available on CourseGalaxy.com    
*/

package threadedtree;

public class ThreadedBinaryTree
{
    private Node root;

    public ThreadedBinaryTree()
    {
        root = null;
    }

    public boolean isEmpty()
    {
        return (root == null);
    }
    
    private Node inorderPredecessor(Node p)
    {
        if(p.leftThread == true)
	        return p.left;
        else
        {   
	        p=p.left;
	        while(p.rightThread == false)
		        p=p.right;
	        return p;
        }
    }

    private Node inorderSuccessor(Node p)
    {
        if(p.rightThread == true)
	        return p.right; 
        else
        {
	        p=p.right;
	        while(p.leftThread==false)
		        p=p.left;
	        return p;
        }
    }
   
    public void inorder()
    {
        if(root == null )
        {
            System.out.print("Tree is empty");
	        return;
        }
        	        
        /*Find the leftmost node of the tree*/
        Node p = root;
        while( p.leftThread == false )
	        p = p.left;

        while( p!=null )
        {
	        System.out.print(p.info + " ");
            if (p.rightThread == true)
                p = p.right;
            else
            {
                p = p.right;
                while (p.leftThread == false)
                    p = p.left;
            }
        }
        System.out.println();
    }

    public void insert(int x)
    {
        Node p = root;
        Node par = null;
    
        while (p!=null)
        {
            par = p;
            if (x < p.info)
            {
                if (p.leftThread == false)
                    p = p.left;
                else
                    break;
            }
            else if(x > p.info)
            {
                if (p.rightThread == false)
                    p = p.right;
                else
                    break;
            }
            else
            {
                System.out.println(x + " already present in the tree");
                return;
            }
        }

        Node temp = new Node(x);
        if (par == null)
        {
            root = temp;
        }
        else if (x < par.info) /*inserted as left child*/
        {
            temp.left = par.left;
            temp.right = par;
            par.leftThread = false;
            par.left = temp;
        }
        else  /*inserted as right child*/
        {
            temp.left = par;
            temp.right = par.right;
            par.rightThread = false;
            par.right = temp;
        }
    }

    public void delete(int x)
    {
        Node p = root;
        Node par = null;

        while (p != null)
        {
            if (x == p.info)
                break;
            par = p;
            if (x < p.info)
            {
                if (p.leftThread == false)
                    p = p.left;
                else
                    break;
            }
            else
            {
                if (p.rightThread == false)
                    p = p.right;
                else
                    break;
            }
        }

        if (p == null || p.info != x)
        {
            System.out.println(x + " not found");
            return;
        }
                    
        if (p.leftThread == false && p.rightThread == false)/*Case C: 2 children*/
        {
            /*Find inorder successor and its parent*/
            Node ps = p;
            Node s = p.right;

            while (s.leftThread == false)
            {
                ps = s;
                s = s.left;
            }
            p.info = s.info;
            p = s;
            par = ps;
        }

        /*Case A : No child*/
        if (p.leftThread == true && p.rightThread == true)
        {
            if (par == null)
                root = null;
            else if (p == par.left)
            {
                par.leftThread = true;
                par.left = p.left;
            }
            else
            {
                par.rightThread = true;
                par.right = p.right;
            }
            return;
        }

        /*Case B : 1 child*/
        Node ch;
        if (p.leftThread == false) /*node to be deleted has left child */
            ch = p.left;
        else                /*node to be deleted has right child */
            ch = p.right;

        if (par == null)   /*node to be deleted is root node*/
            root = ch;
        else if (p == par.left)/*node is left child of its parent*/
            par.left = ch;
        else  /*node is right child of its parent*/
            par.right = ch;

        Node pred = inorderPredecessor(p);
        Node succ = inorderSuccessor(p);

        if (p.leftThread == false) /*if p has left child, right is a thread */
            pred.right = succ;
        else  /*p has right child,left is a thread*/
            succ.left = pred;
    }
}
