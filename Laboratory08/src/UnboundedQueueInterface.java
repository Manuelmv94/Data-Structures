//----------------------------------------------------------
//Laboratory 05
//UnboundedQueueInterface.java
//Manuel Madrigal Valenzuela
//February 26, 2015
//----------------------------------------------------------

//
//This generic interface has specific methods that are going to be implemented on 
//the Unbounded Queue
//

public interface UnboundedQueueInterface<Type> extends QueueInterface<Type>{
	void enqueue(Type element);
	// Adds element to the rear of this queue.
}