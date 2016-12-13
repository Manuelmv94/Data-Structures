//----------------------------------------------------------
//Laboratory 07
//DoublyLinkedListNode.java
//Manuel Madrigal Valenzuela
//March 11,2016
//----------------------------------------------------------

//
//This Generic Class allow us to create a Node of a DoublyLinked List
public class DoublyLinkedListNode<T> {
	private T info;
	private DoublyLinkedListNode<T> frontLink;
	private DoublyLinkedListNode<T> backLink;
	
	
	//
	//This method is the constructor for the DoublyLinkedListNode Class
	//pre: none
	//post: attributes are initialized,creating an unlinked Node 
	public DoublyLinkedListNode(T info){
		this.setInfo(info);
		this.frontLink=null;
		this.backLink=null;
	}
	
	//
	//This method is the setter for the info attribute
	//pre: none
	//post: The content of the Node is modificated
	public void setInfo(T info){
		this.info=info;
	}
	
	//
	//This method is the getter for the info attribute
	//pre: none
	//post:none
	public T getInfo(){
		return this.info;
	}
	
	//
	//This method is the setter for the frontLink attribute
	//pre: none
	//post: The link of the Node is modificated
	public void setFrotLink(DoublyLinkedListNode<T> link){
		this.frontLink=link;
	}
	
	//
	//This method is the getter for the frontLink attribute
	//pre: none
	//post:none
	public DoublyLinkedListNode<T> getFrotLink(){
		return this.frontLink;
	}
	
	//
	//This method is the setter for the backLink attribute
	//pre: none
	//post: The link of the Node is modificated
	public void setBackLink(DoublyLinkedListNode<T> link){
		this.backLink=link;
	}
	
	//
	//This method is the getter for the backLink attribute
	//pre: none
	//post:none
	//
	public DoublyLinkedListNode<T> getBackLink(){
		return this.backLink;
	}
}
