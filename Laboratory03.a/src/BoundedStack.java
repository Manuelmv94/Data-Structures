//----------------------------------------------------------
//Laboratory 03
//BoundedStack.java
//Manuel Madrigal Valenzuela
//February 5, 2015
//----------------------------------------------------------

//
//This generic class allow us to create a Bounded stack, which is implemented
//on an underlying memory that is an array
//
public class BoundedStack<Type> implements BoundedStackInterface<Type>{
	private Type[] Stack;
	private int StackSize;
	private int top;
	
	//
	//this is the constructor of the bounded stack, it receives an int parameter
	//which is going to be the size of the stack
	//pre:none
	//post:The stack is initialized but it is empty
	//
	public BoundedStack(int StackSize){
		this.StackSize=StackSize;
		this.Stack=(Type[]) new Object[StackSize];
		this.top=0;
	}
	
	//
	// throws StackUnderflowException if the stack is empty
	// otherwise removes and returns the object at location Top
	//pre:none
	//post:the top element is removed from the stack, if there is any
	//
	public Type pop() throws StackUnderflowException {
		if(this.top>0){
			Type aux=this.Stack[this.top-1];
			this.Stack[--this.top]=null;
			return aux;
		}else{
			throw new StackUnderflowException("The stack is empty");
		}
	}

	//
	// throws StackUnderflowException if the stack is empty
	// otherwise returns the object at location Top
	//pre:none
	//post:none
	//
	public Type top() throws StackUnderflowException {
		if(this.top>0){
			return this.Stack[this.top-1];
		}else{
			throw new StackUnderflowException("The stack is empty");
		}
	}

	//
	// returns True if the stack is empty; otherwise returns False
	//pre:none
	//post:none
	//
	public boolean isEmpty() {
		if(top==0){
			return true; 
		}else{
			return false;
		}
	}

	//
	// throws StackOverflowException if the stack is full
	// otherwise the places the object in the Stack at location Top 
	//pre:none
	//post:places an element into the stack, if possible
	//
	public void push(Type element) throws StackOverflowException {
		this.Stack[top++]=element;
	}

	//
	// returns True if the stack is full; otherwise returns False
	//pre:none
	//post:none
	public boolean isFull() {
		if(this.StackSize==this.top){
			return true;
		}else{
			return false;
		}
	}

	

}
