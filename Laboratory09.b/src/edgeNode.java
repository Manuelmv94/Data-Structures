//----------------------------------------------------------
//Laboratory 09
//edgeNode.java
//Manuel Madrigal Valenzuela
//April 15,2016
//----------------------------------------------------------

//
//This Class allow us to create a Node of a Linked List 
//of edges of a Weighted directional Graph
public class edgeNode{
	private int weight;
	private int index;
	private edgeNode link;
	
	//
	//This method is the constructor for the edgeNode Class
	//pre: none
	//post: attributes are initialized,creating an unlinked Node 
	public edgeNode(int index, int weight){
		this.setIndex(index);
		this.setWeight(weight);
		this.link=null;
	}
	
	//
	//This method is the setter for the Weight
	//pre: none
	//post: The weight of the Node is modificated
	public void setWeight(int weight){
		this.weight=weight;
	}
	
	//
	//This method is the getter for the weight attribute
	//pre: none
	//post:none
	public int getWeight(){
		return this.weight;
	}
	
	//
	//This method is the setter for the index
	//pre: none
	//post: The index of the Node is modificated
	public void setIndex(int index){
		this.index=index;
	}
	
	//
	//This method is the getter for the index attribute
	//pre: none
	//post:none
	public int getIndex(){
		return this.index;
	}
	
	//
	//This method is the setter for the link attribute
	//pre: none
	//post: The link of the Node is modificated
	public void setLink(edgeNode link){
		this.link=link;
	}
	
	//
	//This method is the getter for the index attribute
	//pre: none
	//post:none
	public edgeNode getLink(){
		return this.link;
	}
}
