package com.binarysearch;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinarySearchTree {

	public Node root;

	public BinarySearchTree(){
		this.root=null;
	}

	public void insert(int data) {
		this.root = insert(this.root, data);
	}

	private Node insert(Node root, int data) {

		if(root==null) {
			root = new Node(data);
			return root;
		}

		if(root.data>=data) {
			root.left=this.insert(root.left,data);
		}else root.right = this.insert(root.right, data);

		return root;
	}

	public int getMaximumDepth() {
		int depth = this.getMaximumDepth(this.root);
		
		//adding count for root node;
		return depth+1;
	}

	private int getMaximumDepth(Node root) {
		if (root == null)
			return -1;
		else
		{
			/* compute the depth of each subtree */
			int lDepth = getMaximumDepth(root.left);
			int rDepth = getMaximumDepth(root.right);

			/* use the larger one */
			if (lDepth > rDepth)
				return (lDepth + 1);
			else
				return (rDepth + 1);
		}
	}

	public int getSizeUsingRecussion(){
		return sizeUsingRecussion(root);
	}

	private int sizeUsingRecussion(Node node){
		if (node == null)
			return 0;
		else
			return(sizeUsingRecussion(node.left) + 1 + sizeUsingRecussion(node.right));
	}
	
	public int getSizeUsingIteration() {
		return sizeUsingIteration(this.root);
	}

	private int sizeUsingIteration(Node root) {
		Node currentNode;
		int size=0;
		Queue<Node> queue = new ArrayDeque<Node>();
		queue.add(root);
		while(!queue.isEmpty()) {
			currentNode = queue.remove();
			size++;
			Node left = currentNode.left;
			Node right = currentNode.right;
			if(left!=null) queue.add(left);
			if(right!=null) queue.add(right);
		}
		return size;
	}
	
    public void preorder() {
        preorder(root);
        System.out.println();
    }

    private void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        /* first recur on left child */
        preorder(root.left);
        
        /* now recur on right child */
        preorder(root.right);
    }
    
    public void inOrder() {
    	inorder(root);
    }

	private void inorder(Node root) {
		if (root == null)
            return;
 
        /* first recur on left child */
       inorder(root.left);
 
        /* then print the data of node */
        System.out.print(root.data + " ");
 
        /* now recur on right child */
        inorder(root.right);
	}
	
	public void postOrder() {
		postOrder(root);
	}

	private void postOrder(Node root) {
		if(root==null)
			return;
		
		 // first recur on left subtree
		postOrder(root.left);
 
        // then recur on right subtree
		postOrder(root.right);
 
        // now deal with the node
        System.out.print(root.data + " ");
	}
	
	public static void main(String[] args) {
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		
		//adding values to binary search tree
		binarySearchTree.insert(25);
		binarySearchTree.insert(15);
		binarySearchTree.insert(50);
		binarySearchTree.insert(10);
		binarySearchTree.insert(22);
		binarySearchTree.insert(35);
		binarySearchTree.insert(70);
		binarySearchTree.insert(4);
		binarySearchTree.insert(12);
		binarySearchTree.insert(18);
		binarySearchTree.insert(24);
		binarySearchTree.insert(31);
		binarySearchTree.insert(44);
		binarySearchTree.insert(66);
		binarySearchTree.insert(90);
		
		System.out.println("Maximum depth :"+binarySearchTree.getMaximumDepth());
		
		System.out.println("Binary Search Tree size using recursive : "+binarySearchTree.getSizeUsingRecussion());
		
		System.out.println("Binary Search Tree size using itreration : "+binarySearchTree.getSizeUsingIteration());
		
		System.out.println("In-order (Root) visits nodes in the following order:");
		binarySearchTree.inOrder();
		
		System.out.println();
		System.out.println("Pre-order traversal visits nodes in the following order:");
		binarySearchTree.preorder();
		
		System.out.println("Post-order traversal visits nodes in the following order:");
		binarySearchTree.postOrder();
	}
}
