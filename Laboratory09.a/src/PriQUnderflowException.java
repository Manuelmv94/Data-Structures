//----------------------------------------------------------
//Laboratory 09
//PriQUnderflowException.java
//Manuel Madrigal Valenzuela
//April 15,2016
//----------------------------------------------------------

//
//This class is an exception thrown when you try to access an element from the queue
//but the queue is empty
public class PriQUnderflowException extends RuntimeException {
	
	//
	//this is the default constructor of the exception
	//pre:none
	//post:none
	public PriQUnderflowException(){
		super();
	}
	
	//
	//this is the constructor with a string parameter
	//which is showed when the exception is called
	//pre:the parameter has to be a string data type
	//post:none
	public PriQUnderflowException(String message){
		super(message);
	}
}
