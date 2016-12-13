//----------------------------------------------------------
//Laboratory 06
//SortedList.java
//Manuel Madrigal Valenzuela
//March 4, 2015
//----------------------------------------------------------

//
//This generic class allow us to create a Sorted List, which is implemented
//on an underlying memory structure of a LinkedList
//To create the LinkedList, I used the LinkedLiStNode generic class of Lab2
//
public class SortedList<Type> implements ListInterface<Type> {
	private LinkedListNode<Type> nextElement,currentElement,topElement;
	private int size;
	
	//
	//Constructor by default of the sorted List
	public SortedList(){
		nextElement=currentElement=null;
		this.size=0;
	}
	
	//
	// Returns the number of elements on this list.
	//pre: none
	//post: none
	public int size() {	
		return this.size;
	}
	
	//
	// Adds element to this list.
	//pre: none
	//post: A new element is introduced in the corresponding order to the List
	public void add(Type element) {
		this.reset();
		if(this.size==0){
			this.nextElement=new LinkedListNode<Type>(element);
			this.currentElement=this.topElement=this.nextElement;
			this.size++;
		}else{
			for(int i=0;i<this.size;i++){	
				if(((Comparable)(this.nextElement.getInfo())).compareTo(element)<0){
					this.currentElement=this.nextElement;
					if(this.nextElement.getLink()!=null){
						this.nextElement=this.nextElement.getLink();
					}else{					
						this.nextElement=new LinkedListNode<Type>(element);
						this.currentElement.setLink(this.nextElement);
						this.size++;
						break;
					}
				}else{
					this.nextElement=new LinkedListNode<Type>(element);
					if(i==0){
						this.nextElement.setLink(this.topElement);
						this.topElement=this.nextElement;
					}else{
						this.nextElement.setLink(this.currentElement.getLink());
						this.currentElement.setLink(this.nextElement);
					}
					this.size++;
					break;
				}
			}
			
		}
		
	}
	
	//
	// Removes an element e from this list such that e.equals(element)
	// and returns true; if no such element exists, returns false.
	//pre: none
	//post: If there is a match, the element is removed from the list
	public boolean remove(Type element) {
		this.reset();
		int i=0;
		while(i<this.size){
			if(((Comparable)(this.nextElement.getInfo())).compareTo(element)==0){
				break;
			}else{
				this.currentElement=this.nextElement;
				this.nextElement=this.nextElement.getLink();
				i++;
			}
		}
		if(i<this.size){
			if(i>0){
				this.currentElement.setLink(this.nextElement.getLink());
				this.nextElement=null;
				
			}else{
				this.topElement=this.topElement.getLink();
			}
			this.size--;
			return true;
		}else{
			return false;
		}
	}

	//
	// Returns true if this list contains an element e such that 
	// e.equals(element); otherwise, returns false.
	//pre:none
	//post:none
	public boolean contains(Type element) {
		this.reset();
		int i=0;
		while(i<this.size){
			if(((Comparable)(this.currentElement.getInfo())).compareTo(element)==0){
				break;
			}else{
				this.currentElement=this.currentElement.getLink();
				i++;
			}
		}
		if(i<this.size){
			return true;
		}else{
			return false;
		}
	}

	//
	// Returns an element e from this list such that e.equals(element);
	// if no such element exists, returns null.
	//pre:none
	//post:none
	public Type get(Type element) {
		this.reset();
		int i=0;
		while(i<this.size){
			if(((Comparable)(this.currentElement.getInfo())).compareTo(element)==0){
				break;
			}else{
				this.currentElement=this.currentElement.getLink();
				i++;
			}
		}
		if(i<this.size){
			return this.currentElement.getInfo();
		}else{
			return null;
		}
	}
	
	//
	// Initializes current position for an iteration through this list,
	// to the first element on this list.
	//pre:none
	//post:currentElement points to topElement
	public void reset() {
		this.currentElement=this.nextElement=this.topElement;
		
	}
	
	//
	// Returns the element at the current position on this list.
	// If the current position is the last element, then it advances the 
	// value of the current position to the first element; otherwise, it 
	// advances the value of the current position to the next element.
	// Pre: The list is not empty
	//      The list has been reset
	// 		The list has not been modified since the most recent reset
	// Post:currentElement points to the next element on the list
	public Type getNext() throws ListUnderflowException {
		if(this.size==0){
			throw new ListUnderflowException();
		}else{
			this.nextElement=this.currentElement;
			if(this.currentElement.getLink()!=null){
				this.currentElement=this.currentElement.getLink();
			}else{
				this.currentElement=this.topElement;
			}
			
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
			this.currentElement=this.currentElement.getLink();
		}
		this.reset();
		return toPrint;
		
	}

}
