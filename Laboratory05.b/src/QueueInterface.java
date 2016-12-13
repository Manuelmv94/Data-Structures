//----------------------------------------------------------
//Laboratory 05
//QueueInterface.java
//Manuel Madrigal Valenzuela
//February 26, 2015
//----------------------------------------------------------

//
//This generic interface has the methods that are going to be implemented
//in both queues, Bounded and Unbounded
//
public interface QueueInterface<Type>{

	Type dequeue() throws QueueUnderflowException;
  // Throws QueueUnderflowException if this queue is empty,
  // otherwise removes front element from this queue and returns it.
  
	boolean isEmpty();
  // Returns true if this queue is empty, otherwise returns false.
}