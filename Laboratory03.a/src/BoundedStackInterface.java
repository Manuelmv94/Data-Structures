//----------------------------------------------------------
//Laboratory 03
//BoundedStackInterface.java
//Manuel Madrigal Valenzuela
//February 5, 2015
//----------------------------------------------------------

//
//This generic interface has specific methods that are going to be implemented on 
//the bounded stack
//
public interface BoundedStackInterface<Type> extends StackInterface<Type>{
	
	void push(Type element) throws StackOverflowException;
	// throws StackOverflowException if the stack is full
	// otherwise the places the object in the Stack at location Top 
	
	boolean isFull();
	// returns True if the stack is full; otherwise returns False
}