//----------------------------------------------------------
//Laboratory 03
//StackInterface.java
//Manuel Madrigal Valenzuela
//February 5, 2015
//----------------------------------------------------------

//
//This generic interface has the methods that are going to be implemented
//in both stacks, Bounded and Unbounded
//
public interface StackInterface<Type> {
	Type pop() throws StackUnderflowException;
	// throws StackUnderflowException if the stack is empty
	// otherwise removes and returns the object at location Top
	Type top() throws StackUnderflowException;
	// throws StackUnderflowException if the stack is empty
	// otherwise returns the object at location Top
	   boolean isEmpty();
	// returns True if the stack is empty; otherwise returns False
}
