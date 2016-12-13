//----------------------------------------------------------
//Laboratory 05
//BoundedQueueInterface.java
//Manuel Madrigal Valenzuela
//February 26, 2015
//----------------------------------------------------------

//
//This generic interface has specific methods that are going to be implemented on 
//the bounded queue
//
public interface BoundedQueueInterface<Type> extends QueueInterface<Type>
{
  void enqueue(Type element) throws QueueOverflowException;
  // Throws QueueOverflowException if this queue is full,
  // otherwise adds element to the rear of this queue.
  
  boolean isFull();
  // Returns true if this queue is full, otherwise returns false.
} 