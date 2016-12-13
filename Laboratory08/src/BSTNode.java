//----------------------------------------------------------
//Laboratory 08
//BSTNode.java
//Manuel Madrigal Valenzuela
//April 01,2016
//----------------------------------------------------------


public class BSTNode<T extends Comparable<T>> {
	private T info;
	private BSTNode<T> left;
	private BSTNode<T> right;
	
	//
	//This method is the constructor for the BSTNode Class
	//pre: none
	//post: attributes are initialized,creating an unlinked Node 
	//
	public BSTNode(T info){
		this.info=info;
		this.left=null;
		this.right=null;
	}
	
	//
	//This method is the setter for the info attribute
	//pre: none
	//post: The content of the Node is modificated
	//
	public void setInfo(T info){
		this.info=info;
	}
	
	//
	//This method is the getter for the info attribute
	//pre: none
	//post:none
	//
	public T getInfo(){
		return this.info;
	}
	
	//
	//This method is the setter for the right attribute
	//pre: none
	//post: The right link of the Node is modificated
	//
	public void setRight(BSTNode<T> right){
		this.right=right;
	}
	
	//
	//This method is the getter for the right attribute
	//pre: none
	//post:none
	//
	public BSTNode<T> getRight(){
		return this.right;
	}
	
	//
	//This method is the setter for the left attribute
	//pre: none
	//post: The left link of the Node is modificated
	//
	public void setLeft(BSTNode<T> left){
		this.left=left;
	}
	
	//
	//This method is the getter for the left attribute
	//pre: none
	//post:none
	//
	public BSTNode<T> getLeft(){
		return this.left;
	}
}
