
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
