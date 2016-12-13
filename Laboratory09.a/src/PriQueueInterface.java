//----------------------------------------------------------
//Laboratory 09
//PriQueueInterface.java
//Manuel Madrigal Valenzuela
//April 15,2016
//----------------------------------------------------------

public interface PriQueueInterface<T extends Comparable<T>> {

	boolean isEmpty();
	//Returns true if the priority Queue is empty; otherwise returns false
	
	boolean isFull();
	//Returns true if this priority Queue is full; otherwise, returns false.
	
	void enqueue(T element);
	//Throws PriQOverflowException if the priority queue is full;
	//otherwise, adds element to this priority queue
	
	T dequeue();
	//Throws PriQUnderflowException if this priority queue is empty;
	//otherwise, removes element with highest priority from this
	//priority queue and returns it.
}
