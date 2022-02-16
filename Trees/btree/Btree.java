/*
Copyright (C) Deepali Srivastava - All Rights Reserved
This code is part of DSA course available on CourseGalaxy.com    
*/

package btree;

public class Btree
{
	private static final int M = 5;
    private static final int MAX = M - 1;
    private static final int MIN = (int)Math.ceil((double)M / 2) - 1;
    
    private Node root;

    public Btree()
    {
        root = null;
    }

    public boolean Search(int x)
    {
        if (Search(x, root) == null)
            return false;
        return true;
    }
    
    private Node Search(int x, Node p)
    {
      if (p == null)        /*Key x not present in the tree*/
          return null;

      IntHolder n = new IntHolder(0);
      if (SearchNode(x, p, n) == true)	/* Key x found in node p */
          return p;

      return Search(x, p.child[n.value]); /* Search in nth child of p */
    }
    
    private boolean SearchNode(int x, Node p, IntHolder n)
    {
        if (x < p.key[1]) /* key x is less than leftmost key */
        {
            n.value = 0;
            return false;
        }

        n.value = p.numKeys;
        while ((x < p.key[n.value]) && n.value > 1)
            n.value--;

        if (x == p.key[n.value])
            return true;
        else
            return false;
    }

    public void Inorder()
    {
        Inorder(root);
    }

    private void Inorder(Node p)
    {
        if (p == null)
            return;

        int i;
        for (i = 0; i < p.numKeys; i++)
        {
            Inorder(p.child[i]);
            System.out.print(p.key[i + 1] + "  ");
        }
        Inorder(p.child[i]);
    }

    public void Display()
    {
        Display(root, 0);
    }

    private void Display(Node p, int blanks)
    {
        if (p != null)
        {
            int i;
            for (i = 1; i <= blanks; i++)
                System.out.print(" ");

            for (i = 1; i <= p.numKeys; i++)
                System.out.print(p.key[i] + " ");
            System.out.print("\n");

            for (i = 0; i <= p.numKeys; i++)
                Display(p.child[i], blanks + 10);
        }
    }

    public void Insert(int x)
    {
        IntHolder iKey = new IntHolder(0);
        NodeHolder iKeyRchild = new NodeHolder(null);
        
        boolean taller = Insert(x, root, iKey, iKeyRchild);

        if (taller)  /* Height increased by one, new root node has to be created */
        {
            Node temp = new Node(M);
            temp.child[0] = root;
            root = temp;

            root.numKeys = 1;
            root.key[1] = iKey.value;
            root.child[1] = iKeyRchild.value;
        }
    }

	
	private boolean Insert(int x, Node p, IntHolder iKey, NodeHolder iKeyRchild)
    {
        if (p == null)  /*First Base case : key not found*/
        {
            iKey.value = x;
            iKeyRchild.value = null;
            return true;
        }

        IntHolder n = new IntHolder(0);
        
        if (SearchNode(x, p, n) == true) /*Second Base Case : key found*/
        {
            System.out.println("Key already present in the tree");
            return false; /*No need to insert the key*/
        }

        boolean flag = Insert(x, p.child[n.value], iKey, iKeyRchild);

        if (flag == true)
        {
            if (p.numKeys < MAX)
            {
                InsertByShift(p, n.value, iKey.value, iKeyRchild.value);
                return false; /*Insertion over*/
            }
            else
            {
                Split(p, n.value, iKey, iKeyRchild);
                return true;  /*Insertion not over : Median key yet to be inserted*/
            }
        }
        return false;
    }

    private void InsertByShift(Node p, int n, int iKey, Node iKeyRchild)
    {
        for (int i = p.numKeys; i > n; i--)
        {
            p.key[i+1] = p.key[i];
            p.child[i+1] = p.child[i];
        }

        p.key[n+1] = iKey;
        p.child[n+1] = iKeyRchild;
        p.numKeys++;
    }

    private void Split(Node p, int n, IntHolder iKey, NodeHolder iKeyRchild)
    {
        int i, j;
        int lastKey;
        Node lastChild;

        if (n == MAX)
        {
            lastKey = iKey.value;
            lastChild = iKeyRchild.value;
        }
        else
        {
            lastKey = p.key[MAX];
            lastChild = p.child[MAX];

            for (i = p.numKeys - 1; i > n; i--)
            {
                p.key[i+1] = p.key[i];
                p.child[i+1] = p.child[i];
            }

            p.key[i+1] = iKey.value;
            p.child[i+1] = iKeyRchild.value;
        }

        int d = (M + 1) / 2;
        int medianKey = p.key[d];
        Node newNode = new Node(M);
        newNode.numKeys = M - d;

        newNode.child[0] = p.child[d];
        for (i=1, j=d+1; j<=MAX; i++, j++)
        {
            newNode.key[i] = p.key[j];
            newNode.child[i] = p.child[j];
        }
        newNode.key[i] = lastKey;
        newNode.child[i] = lastChild;

        p.numKeys = d - 1;

        iKey.value = medianKey;
        iKeyRchild.value = newNode;
    }

    public void Delete(int x)
    {
        if (root == null)
        {
            System.out.println("Tree is empty");
            return;
        }

        Delete(x, root);

        if (root != null && root.numKeys == 0) /*Height of the tree decreased by 1*/
            root = root.child[0];
    }

    private void Delete(int x, Node p)
    {
        IntHolder n = new IntHolder(0);

        if (SearchNode(x, p, n) == true) /* Key x found in node p */
        {
            if (p.child[n.value] == null)     /* Node p is a leaf node */
            {
                DeleteByShift(p, n.value);
                return;
            }
            else                    /* Node p is a non-leaf node */
            {
                Node s = p.child[n.value];
                while (s.child[0] != null)
                    s = s.child[0];
                p.key[n.value] = s.key[1];
                Delete(s.key[1], p.child[n.value]);
            }
        }
        else  /* Key x not found in node p */
        {
            if (p.child[n.value] == null) /* p is a leaf node */
            {
                System.out.println("Value " + x + " not present in the tree");
                return;
            }
            else  /* p is a non-leaf node */
                Delete(x, p.child[n.value]);
        }

        if (p.child[n.value].numKeys < MIN)
            Restore(p, n.value);
    }

    private void DeleteByShift(Node p, int n)
    {
        for (int i = n+1; i <= p.numKeys; i++)
        {
            p.key[i-1] = p.key[i];
            p.child[i-1] = p.child[i];
        }
        p.numKeys--;
    }

    /* Called when p.child[n] becomes underflow */
    private void Restore(Node p, int n)
    {
        if (n != 0 && p.child[n-1].numKeys > MIN)
            BorrowLeft(p, n);
        else if (n != p.numKeys && p.child[n+1].numKeys > MIN)
            BorrowRight(p, n);
        else
        {
            if (n != 0)  /*if there is a left sibling*/
                Combine(p, n);	  /*combine with left sibling*/
            else
                Combine(p, n+1);  /*combine with right sibling*/
        }
    }

    private void BorrowLeft(Node p, int n)
    {
        Node underflowNode = p.child[n];
        Node leftSibling = p.child[n-1];

        underflowNode.numKeys++;

        /*Shift all the keys and children in underflowNode one position right*/
        for (int i = underflowNode.numKeys; i > 0; i--)
        {
            underflowNode.key[i+1] = underflowNode.key[i];
            underflowNode.child[i+1] = underflowNode.child[i];
        }
        underflowNode.child[1] = underflowNode.child[0];

        /* Move the separator key from parent node p to underflowNode */
        underflowNode.key[1] = p.key[n];

        /* Move the rightmost key of node leftSibling to the parent node p */
        p.key[n] = leftSibling.key[leftSibling.numKeys];

        /*Rightmost child of leftSibling becomes leftmost child of underflowNode */
        underflowNode.child[0] = leftSibling.child[leftSibling.numKeys];

        leftSibling.numKeys--;
    }

    private void BorrowRight(Node p, int n)
    {
        Node underflowNode = p.child[n];
        Node rightSibling = p.child[n+1];

        /* Move the separator key from parent node p to underflowNode */
        underflowNode.numKeys++;
        underflowNode.key[underflowNode.numKeys] = p.key[n + 1];

        /* Leftmost child of rightSibling becomes the rightmost child of underflowNode */
        underflowNode.child[underflowNode.numKeys] = rightSibling.child[0];

        /* Move the leftmost key from rightSibling to parent node p */
        p.key[n + 1] = rightSibling.key[1];
        rightSibling.numKeys--;

        /* Shift all the keys and children of rightSibling one position left */
        rightSibling.child[0] = rightSibling.child[1];
        for (int i = 1; i <= rightSibling.numKeys; i++)
        {
            rightSibling.key[i] = rightSibling.key[i+1];
            rightSibling.child[i] = rightSibling.child[i+1];
        }
    }

    private void Combine(Node p, int m)
    {
        Node nodeA = p.child[m-1];
        Node nodeB = p.child[m];

        nodeA.numKeys++;

        /* Move the separator key from the parent node p to nodeA */
        nodeA.key[nodeA.numKeys] = p.key[m];

        /* Shift the keys and children that are after separator key in node p 
           one position left */
        int i;
        for (i = m; i < p.numKeys; i++)
        {
            p.key[i] = p.key[i+1];
            p.child[i] = p.child[i+1];
        }
        p.numKeys--;

        /* Leftmost child of nodeB becomes rightmost child of nodeA */
        nodeA.child[nodeA.numKeys] = nodeB.child[0];

        /* Insert all the keys and children of nodeB at the end of nodeA */
        for (i = 1; i <= nodeB.numKeys; i++)
        {
            nodeA.numKeys++;
            nodeA.key[nodeA.numKeys] = nodeB.key[i];
            nodeA.child[nodeA.numKeys] = nodeB.child[i];
        }
    }
  }
