//----------------------------------------------------------
//Laboratory 03
//StackUnderflowException.java
//Manuel Madrigal Valenzuela
//February 5, 2015
//----------------------------------------------------------

//
//This class is an exception thrown when you try to access an element from the stack
//but the stack is empty
//
public class StackUnderflowException extends RuntimeException {
	
	//
	//this is the default constructor of the exception
	//pre:none
	//post:none
	//
	public StackUnderflowException(){
		super();
	}
	
	//
	//this is the constructor with a string parameter
	//which is showed when the exception is called
	//pre:none
	//post:none
	//
	public StackUnderflowException(String message){
		super(message);
	}
	
}
