//----------------------------------------------------------
//Laboratory 03
//StackOverflowException.java
//Manuel Madrigal Valenzuela
//February 5, 2015
//----------------------------------------------------------

//
//This class is an exception thrown when you try to push an element into the stack
//but it is already full
//
public class StackOverflowException extends RuntimeException {
	
	//
	//this is the default constructor of the exception
	//pre:none
	//post:none
	//
	public StackOverflowException(){
		super();
	}
	
	//
	//this is the constructor with a string parameter
	//which is showed when the exception is called
	//pre:none
	//post:none
	//
	public StackOverflowException(String message){
		super(message);
	}
}
