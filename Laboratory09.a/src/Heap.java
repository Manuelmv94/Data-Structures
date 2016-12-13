//----------------------------------------------------------
//Laboratory 09
//Heap.java
//Manuel Madrigal Valenzuela
//April 15,2016
//----------------------------------------------------------


import java.util.ArrayList;
//
//This class implements a Heap to hold a priority queue
public class Heap<T extends Comparable<T>> implements PriQueueInterface<T> {
	private static final int DEFCAP=50;
	private ArrayList<T> elements;
	private int lastIndex;	//index of last element in priority queue
	private int maxIndex;	//index of last position in ArrayList
	
	//
	//This is the constructor by default of the class
	//It initializes the ArrayList with a predefined default capacity of 50
	public Heap(){
		this(DEFCAP);
	}
	
	//
	//This is the constructor with parameters of our class
	//It initializes the array with a given value
	public Heap(int maxSize){
		this.elements=new ArrayList<T>(maxSize);
		this.lastIndex=-1;
		this.maxIndex=maxSize-1;
	}
	
	//
	//Returns true if the priority Queue is empty; otherwise returns false
	//pre: none
	//post: none
	public boolean isEmpty() {
		return (this.lastIndex==-1);
	}

	//
	//Returns true if this priority Queue is full; otherwise, returns false.
	//pre: none
	//post: none
	public boolean isFull() {
		return (this.lastIndex==this.maxIndex);
	}
	
	//
	//Inserts element into the tree and ensures shape and order properties.
	//pre:Current lastIndex position is "empty".
	//post: The tree is organized to keep its properties
	private void reheapUp(T element){
		int hole=this.lastIndex;
		while((hole>0)&&(element.compareTo(this.elements.get((hole-1)/2))>0)){
			this.elements.set(hole, elements.get((hole-1)/2));
			hole=(hole-1)/2;
		}
		
		this.elements.set(hole, element);
	}
	
	//
	//Throws PriQOverflowException if the priority queue is full;
	//otherwise, adds element to this priority queue
	//pre: none
	//post: If the queue is not full, an element is added 
	public void enqueue(T element) {
		if (this.isFull()){
			throw new PriQOverflowException("Priority Queue is full");
		}
		else{
			this.lastIndex++;
			this.elements.add(lastIndex,element);
			this.reheapUp(element);
		}
	}
	
	//
	//If either child of hole is larger than element,return the index
	//of the larger child;otherwise, return the index of the hole
	//pre: none
	//post: none
	private int newHole(int hole, T element){
		int left=(hole*2)+1;
		int right=(hole*2)+2;
		
		if(left>lastIndex){
			return hole;
		}
		else if(left==lastIndex){
			if(element.compareTo(elements.get(left))<0){
				return left;
			}else{
				return hole;
			}
		}
		else if(elements.get(left).compareTo(elements.get(right))<0){
			if(elements.get(right).compareTo(element)<=0){
				return hole;
			}else{
				return right;
			}
		}
		else if(elements.get(left).compareTo(element)<=0){
			return hole;
		}
		else{
			return left;
		}
	}
	
	//
	//inserts element into the tree and ensures shape and order properties
	//pre:Current root position is "empty";
	//post: The tree is organized to keep its properties
	private void reheapDown(T element){
		int hole=0;
		int newhole;
		
		newhole=this.newHole(hole, element);
		while(newhole!=hole){
			this.elements.set(hole, elements.get(newhole));
			hole=newhole;
			newhole=this.newHole(hole, element);
		}
		this.elements.set(hole, element);
	}
	
	//
	//Throws PriQUnderflowException if this priority queue is empty;
	//otherwise, removes element with highest priority from this
	//priority queue and returns it.
	//pre: none
	//post: an element is removed from the queue(if possible)
	public T dequeue() {
		T hold;
		T toMove;
		
		if(this.isEmpty()){
			throw new PriQUnderflowException("Priority Queue is Empty");
		}
		else{
			hold=this.elements.get(0);
			toMove=this.elements.remove(lastIndex);
			lastIndex--;
			if(lastIndex!=-1){
				this.reheapDown(toMove);
			}
			return hold;
			
		}
	}
	
	//It returns a nicely formatted Heap
	public String toString(){
		String toReturn="The heap is:\n";
		for(int i=0;i<=this.lastIndex;i++){
			toReturn+=i+"."+elements.get(i)+"\n";
		}
		return toReturn;
			
		
	}

}
