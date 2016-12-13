//----------------------------------------------------------
//Laboratory 07
//CircularDoublyLinkedList.java
//Manuel Madrigal Valenzuela
//March 11, 2016
//----------------------------------------------------------

//
//This generic class allow us to create an Unsorted List, which is implemented
//on an underlying memory structure of a CircularDoublyLinkedList
public class CircularDoublyLinkedList<Type> implements UnsortedListInterface<Type> {
	private DoublyLinkedListNode<Type> nextElement,currentElement,topElement;
	private boolean found;
	private int size;
	private int location;
	
	//
	//Constructor by default of the Unsorted List
	public CircularDoublyLinkedList(){
		this.nextElement=this.currentElement=this.topElement=null;
		this.size=0;
		this.location=0;
		this.found=true;
	}
	
	//
	// Adds element to this list.
	//pre:none
	//post: an element is added to rear of the list
	public void add(Type element) {
		if(this.size==0){
			this.nextElement=this.topElement=this.currentElement=new DoublyLinkedListNode<Type>(element);
			this.topElement.setFrotLink(this.topElement);
			this.topElement.setBackLink(this.topElement);
		}else{
			this.reset();
			for(int i=0;i<this.size-1;i++){
				this.currentElement=this.currentElement.getFrotLink();
			}
			this.nextElement=new DoublyLinkedListNode<Type>(element);
			this.nextElement.setFrotLink(this.currentElement.getFrotLink());
			this.nextElement.setBackLink(this.currentElement);
			this.currentElement.setFrotLink(this.nextElement);
			this.nextElement.getFrotLink().setBackLink(this.nextElement);
			this.currentElement=this.nextElement;
		}
		this.size++;
		
	}

	//
	// Searches list for an occurrence of an element e such that
    // e.equals(target). If successful, sets instance variables
    // found to true, location to node containing e, and previous
    // to the node that links to location. If not successful, sets 
    // found to false.
	//pre:none
	//post: if the element is found, the found variable is modificated
	public void find(Type target) {
		this.reset();
		for(int i=0; i<this.size;i++){
			this.location=i;
			if(((Comparable)(this.nextElement.getInfo())).compareTo(target)!=0){
				this.currentElement=this.nextElement;
				this.nextElement=this.nextElement.getFrotLink();
			}else{
				this.found=true;
			}
		}
		
	}

	//
	// Returns the number of elements on this list.
	//pre:none
	//post:none
	public int size() {
		return this.size;
	}

	// Returns true if this list contains an element e such that 
    // e.equals(element); otherwise, returns false.
	//pre:none
	//post:none
	public boolean contains(Type element) {
		this.find(element);
		return this.found;
	}

	//
	// Removes an element e from this list such that e.equals(element)
    // and returns true; if no such element exists, returns false.
	//pre:none
	//post: if the element if found, it is removed
	public boolean remove(Type element) {
		this.find(element);
		if(this.found==true){
			this.currentElement.setFrotLink(this.nextElement.getFrotLink());
			this.nextElement.getFrotLink().setBackLink(this.currentElement);
			this.nextElement=this.currentElement;
			if(this.location==0){
				this.topElement=this.currentElement.getFrotLink();
			}
			this.size--;
		}
		
		return this.found;
	}

	//
	// Returns an element e from this list such that e.equals(element);
    // if no such element exists, returns null.
	//pre:none
	//post:none
	public Type get(Type element) {
		this.find(element);
		if(this.found==true){
			return this.nextElement.getInfo();
		}else{
			return null;
		}
	}

	// Initializes current position for an iteration through this list,
    // to the first element on this list.
	//pre:none
	//post:the DoublyLinkedListNode variables are set to the first element on the list
	//     found and location variables are set to their initial values
	public void reset() {
		this.currentElement=this.nextElement=this.topElement;
		this.found=false;
		this.location=0;
		
	}
	
	//
    // Returns the element at the current position on this list.
    // If the current position is the last element, then it advances 
    // the value of the current position to the first element; 
    // otherwise, it advances the value of the current position to 
    // the next element.
	// Preconditions: The list is not empty
    //                The list has been reset
    //        The list has not been modified since most recent reset
    //
	public Type getNext() throws ListUnderflowException {
		if(this.size==0){
			throw new ListUnderflowException();
		}else{
			this.nextElement=this.currentElement;
			this.currentElement=this.currentElement.getFrotLink();
			return this.nextElement.getInfo();
		}	
	}
	
	//
	// Returns a nicely formatted string that represents this list.
	//pre:none
	//post:none
	public String toString(){
		String toPrint="";
		this.reset();
		for(int i=0;i<this.size;i++){
			toPrint+=this.currentElement.getInfo()+"\n";
			this.currentElement=this.currentElement.getFrotLink();
		}
		this.reset();
		return toPrint;
	}
}
