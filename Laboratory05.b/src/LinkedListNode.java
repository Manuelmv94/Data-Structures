//----------------------------------------------------------
//Laboratory 02
//LinkedListNode.java
//Manuel Madrigal Valenzuela
//January 29, 2015
//----------------------------------------------------------

//
//This Generic Class allow us to create a Node of a Linked List
//
public class LinkedListNode<T> {
	private T info;
	private LinkedListNode<T> link;
	
	
	//
	//This method is the constructor for the LinkedListNode Class
	//pre: none
	//post: attributes are initialized,creating an unlinked Node 
	//
	public LinkedListNode(T info){
		this.setInfo(info);
		this.link=null;
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
	//This method is the setter for the link attribute
	//pre: none
	//post: The link of the Node is modificated
	//
	public void setLink(LinkedListNode<T> link){
		this.link=link;
	}
	
	
	//
	//This method is the getter for the link attribute
	//pre: none
	//post:none
	//
	public LinkedListNode<T> getLink(){
		return this.link;
	}

}
